package com.ibm.mstraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.mstraining.bean.ConversionConfiguration;
import com.ibm.mstraining.config.Configuration;

@RestController
public class CurrencyConversionMasterController {
	
	@Autowired
	private Configuration configuration;
	@GetMapping("/currencyConversion")
	public ConversionConfiguration retrieveConfiguration()
	{
		return new ConversionConfiguration(configuration.getMaximum(), configuration.getMinimum());
		
	}
}
