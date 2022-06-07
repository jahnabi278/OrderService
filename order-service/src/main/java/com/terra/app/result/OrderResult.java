package com.terra.app.result;

import com.terra.app.pojos.Order;

public class OrderResult extends Result {
	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
