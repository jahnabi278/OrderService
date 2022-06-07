package com.terra.app.pojos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Address {
	@Min(value = 6, message = "pincode should be at least 6 digits")
	private int pinCode;
	@NotBlank
	private String city;

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	private String country;
}
