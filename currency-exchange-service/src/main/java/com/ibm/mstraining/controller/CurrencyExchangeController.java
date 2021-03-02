package com.ibm.mstraining.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibm.mstraining.beans.ExchangeValue;
import com.ibm.mstraining.exception.CountryCodeNotFoundException;
import com.ibm.mstraining.repository.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ExchangeValueRepository repository;
	
	@PostMapping(path="/currency-exchange/conversion-factor")
	public ResponseEntity<?> addConversionFactor(@RequestBody ExchangeValue exchangeValue)
	{
		ExchangeValue savedValue=repository.save(exchangeValue);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedValue.getCountryCode()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/currency-exchange/conversion-factor/{countryCode}")
	public double getConversionFactor(@PathVariable String countryCode)
	{
		System.out.println("in exchangeeeeee");
		Optional<ExchangeValue> exchangeValueOptional = repository.findByCountryCode(countryCode);
		if(exchangeValueOptional.isEmpty())
			throw new CountryCodeNotFoundException("Country Code not found");
		
		return exchangeValueOptional.get().getConversionFactor();
	}
	
	@PutMapping("/currency-exchange/conversion-factor")
	public ResponseEntity<Void> updateConversionFactor(@RequestBody ExchangeValue exchangeValue)
	{
		Optional<ExchangeValue> exchangeValueOptional = repository.findByCountryCode(exchangeValue.getCountryCode());
		if(exchangeValueOptional.isEmpty())
			throw new CountryCodeNotFoundException("Country Code not found");
		
		repository.save(exchangeValue);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/currency-exchange/conversion-factor")
	public List<ExchangeValue> getConversionFactorForAll()
	{		
		return repository.findAll();
	}

}
