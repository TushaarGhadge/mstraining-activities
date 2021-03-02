package com.ibm.mstraining.bean;

public class ConversionConfiguration {
	int maximum;
	int minimum;
	
	protected ConversionConfiguration()
	{
		
	}

	public ConversionConfiguration(int maximum, int minimum) {
		super();
		this.maximum = maximum;
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public int getMinimum() {
		return minimum;
	}
	
}
