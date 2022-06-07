package com.terra.app.result;

import java.util.List;

import com.terra.app.pojos.Order;

public class OrderCollectionsResult extends Result {
	private List<Order> listOfOrders;

	public List<Order> getListOfOrders() {
		return listOfOrders;
	}

	public void setListOfOrders(List<Order> listOfOrders) {
		this.listOfOrders = listOfOrders;
	}
}
