package com.example.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.terra.app.dto.OrderDTO;
import com.terra.app.pojos.Address;
import com.terra.app.pojos.Item;
import com.terra.app.pojos.OrderLine;
import com.terra.app.status.OrderLineStatus;
import com.terra.app.status.OrderStatus;

public class DataUtils {
	private static Logger logger = LogManager.getLogManager().getLogger(DataUtils.class.getName());

	public OrderDTO createOrder() {
		OrderDTO order = new OrderDTO();
		order.setListOfOrderLines(createListOfOrderLines());
		order.setOrderDate(getDate());
		order.setOrderId("o1");
		order.setOrderStatus(OrderStatus.OPEN);
		order.setTotalAmount(100000.0f);
		return order;
	}

	public List<OrderLine> createListOfOrderLines() {
		List<OrderLine> listOfOrderLine = new ArrayList<>();
		OrderLine orderLine = new OrderLine();
		orderLine.setEta(getDate());
		orderLine.setListOfAddresses(createListOfAddress());
		orderLine.setListOfItems(createListOfItems());
		orderLine.setOrderLineStatus(OrderLineStatus.OPEN);
		listOfOrderLine.add(orderLine);
		return listOfOrderLine;
	}

	public List<Item> createListOfItems() {
		List<Item> listOfItems = new ArrayList<>();
		Item item = new Item();
		item.setItemName("Laptop");
		item.setPrice(40000.0f);
		item.setQuantity(1);
		listOfItems.add(item);
		return listOfItems;

	}

	public List<Address> createListOfAddress() {
		List<Address> listOfAddress = new ArrayList<>();
		Address address = new Address();
		address.setCity("Guwahati");
		address.setCountry("India");
		address.setPinCode(782137);
		listOfAddress.add(address);
		return listOfAddress;
	}

	public Date getDate() {
		Date date = null;
		String sDate1 = "2022/06/09";
		try {
			date = new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);
		} catch (ParseException e) {
			logger.log(Level.SEVERE, "Parsing Exception : ", e);
		}
		return date;
	}
}
