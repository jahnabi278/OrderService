package com.terra.app.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.terra.app.pojos.Order;

@Document(collection = "orderCollection")
public class OrderDTO extends Order {

	@Id
	private String orderId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}
