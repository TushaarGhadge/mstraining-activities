package com.ibm.mstraining.beans;

import java.math.BigDecimal;

public class CurrencyConversionBean {
	private Long id;
	private String countryCode;
	private double conversionFactor;
	private double amount;
	private double convertedAmount;
	
	
	public CurrencyConversionBean(String countryCode, double conversionFactor, double amount, double convertedAmount) {
		super();
		this.countryCode = countryCode;
		this.conversionFactor = conversionFactor;
		this.amount = amount;
		this.convertedAmount = convertedAmount;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public double getConversionFactor() {
		return conversionFactor;
	}
	public void setConversionFactor(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getConvertedAmount() {
		return convertedAmount;
	}
	public void setConvertedAmount(double convertedAmount) {
		this.convertedAmount = convertedAmount;
	}
	
	
	
}
