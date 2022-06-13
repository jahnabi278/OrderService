package com.terra.app.pojos;

import java.util.Date;
import java.util.List;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.terra.app.status.OrderStatus;

public class Order {

	@Min(value = 0, message = "price should not be negative")
	private float totalAmount;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd")
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	@Enumerated(EnumType.STRING)
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
