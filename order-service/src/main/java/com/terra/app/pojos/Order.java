package com.terra.app.pojos;

import java.util.Date;
import java.util.List;

import com.terra.app.status.OrderStatus;

public class Order {
	private float totalAmount;
	private Date orderDate;
	private OrderStatus orderStatus;
	private List<OrderLine> listOfOrderLines;

	public List<OrderLine> getListOfOrderLines() {
		return listOfOrderLines;
	}

	public void setListOfOrderLines(List<OrderLine> listOfOrderLines) {
		this.listOfOrderLines = listOfOrderLines;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
}
