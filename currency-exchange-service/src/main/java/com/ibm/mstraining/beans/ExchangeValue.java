package com.ibm.mstraining.beans;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.springframework.beans.factory.annotation.Value;


@Entity
public class ExchangeValue {

	@Id
	@GeneratedValue
	private Long id;
	private String countryCode;
	private double conversionFactor;
	
	
	public Long getId() {
		return id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public double getConversionFactor() {
		return conversionFactor;
	}
}
