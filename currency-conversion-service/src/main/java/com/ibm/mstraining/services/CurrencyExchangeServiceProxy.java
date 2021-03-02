package com.ibm.mstraining.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ibm.mstraining.beans.CurrencyConversionBean;

//@FeignClient(name="currency-exchange-service",url="localhost:8000")
@FeignClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
	@GetMapping("/currency-exchange/conversion-factor/{countryCode}")
	public double getConversionFactor(@PathVariable String countryCode);
}
