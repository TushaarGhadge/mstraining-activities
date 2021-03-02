package com.ibm.mstraining.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import com.ibm.mstraining.beans.CurrencyConversionBean;
import com.ibm.mstraining.services.CurrencyExchangeServiceProxy;

@RestController
public class CurrencyConversionController {
	private static final String MAIN_SERVICE = "mainService";
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	@GetMapping("/currency-converter/countryCode/{countryCode}/amount/{amount}")
	public double convertCurrency(@PathVariable String countryCode, @PathVariable double amount)
	{
		Map<String, String> uriVariable=new HashMap<>();
		uriVariable.put("countryCode", countryCode);
		ResponseEntity<Double> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/conversion-factor/{countryCode}", Double.class,uriVariable);
		Double response = responseEntity.getBody();
		return response*amount;
	}
	
	@GetMapping("/currency-converter-feign/countryCode/{countryCode}/amount/{amount}")
	@CircuitBreaker(name = MAIN_SERVICE, fallbackMethod="convertCurrencyFallBack")
	public double convertCurrencyFeign(@PathVariable String countryCode, @PathVariable double amount)
	{
		double response = proxy.getConversionFactor(countryCode);
		logger.info("{}",response);
		return response*amount;
	}
	
	 private  double convertCurrencyFallBack(Exception e){
		return 9999999.9999;
	 }
}
