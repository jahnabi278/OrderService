package com.terra.app.pojos;

import java.util.Date;
import java.util.List;

import com.terra.app.status.OrderLineStatus;

public class OrderLine {
	private List<Item> listOfItems;
	private Date eta;
	private OrderLineStatus orderLineStatus;
	private List<Address> listOfAddresses;

	public List<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(List<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}

	public List<Item> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<Item> listOfItems) {
		this.listOfItems = listOfItems;
	}

	public Date getEta() {
		return eta;
	}

	public void setEta(Date eta) {
		this.eta = eta;
	}

	public OrderLineStatus getOrderLineStatus() {
		return orderLineStatus;
	}

	public void setOrderLineStatus(OrderLineStatus orderLineStatus) {
		this.orderLineStatus = orderLineStatus;
	}
}
