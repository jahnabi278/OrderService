package com.terra.app.pojos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class Item {
	@NotBlank
	private String itemName;
	private int quantity;
	@Min(value = 0, message = "price should not be negative")
	private float price;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
