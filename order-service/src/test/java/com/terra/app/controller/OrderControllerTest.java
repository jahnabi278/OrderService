package com.terra.app.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.terra.app.pojos.Address;
import com.terra.app.pojos.Item;
import com.terra.app.pojos.Order;
import com.terra.app.pojos.OrderLine;
import com.terra.app.result.OrderCollectionsResult;
import com.terra.app.result.OrderResult;
import com.terra.app.result.Result;
import com.terra.app.service.OrderService;
import com.terra.app.status.OrderLineStatus;
import com.terra.app.status.OrderStatus;
import com.terra.app.util.ErrorMessages;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {

	@Mock
	OrderService orderService;

	@Mock
	OrderController orderController;

	@Mock
	Result result;

	@Mock
	OrderResult orderResult;

	@Mock
	OrderCollectionsResult orderCollectionResult;

//	@Test
//	public void createOrderTestforNullCheck() {
//		Order order = createOrder();
//		Result result = orderController.create(order);
//		assertNull(result);
//	}

	@Test
	public void createOrderTestForNotNullCheck() {
		Order order = createOrder();
		OrderService orderService =  Mockito.mock(OrderService.class);
	    Mockito.when(orderService.saveOrder(order)).thenReturn(new Result(200, ErrorMessages.SAVE_SUCCESSFUL)); 
		Mockito.when(orderService.saveOrder(order));
		Result result = orderController.create(order);
		assertNotNull(result);
	}

	private Order createOrder() {
		Order order = new Order();
		order.setListOfOrderLines(createListOfOrderLines());
		order.setOrderDate(getDate());
		order.setOrderId("o1");
		order.setOrderStatus(OrderStatus.OPEN);
		order.setTotalAmount(100000.0f);
		return order;
	}

	private List<OrderLine> createListOfOrderLines() {
		List<OrderLine> listOfOrderLine = new ArrayList<>();
		OrderLine orderLine = new OrderLine();
		orderLine.setEta(getDate());
		orderLine.setListOfAddresses(createListOfAddress());
		orderLine.setListOfItems(createListOfItems());
		orderLine.setOrderLineStatus(OrderLineStatus.OPEN);
		listOfOrderLine.add(orderLine);
		return listOfOrderLine;
	}

	private List<Item> createListOfItems() {
		List<Item> listOfItems = new ArrayList<>();
		Item item = new Item();
		item.setItemName("Laptop");
		item.setPrice(40000.0f);
		item.setQuantity(1);
		listOfItems.add(item);
		return listOfItems;

	}

	private List<Address> createListOfAddress() {
		List<Address> listOfAddress = new ArrayList<>();
		Address address = new Address();
		address.setCity("Guwahati");
		address.setCountry("India");
		address.setPinCode(782137);
		listOfAddress.add(address);
		return listOfAddress;
	}

	private Date getDate() {
		Date date = null;
		String sDate1 = "2022/06/09";
		try {
			date = new SimpleDateFormat("yyyy/MM/dd").parse(sDate1);
		} catch (ParseException e) {
			// LOGGER
		}
		return date;
	}

//	@Test
//	public void getOrdersByPincodeTest1() {
//		OrderCollectionsResult result = orderController.getOrdersByPincode(782137);
//		assertNull(result);
//	}
//
//	@Test
//	public void getOrdersByIdTest1() {
//		OrderResult result = orderController.getOrdersById("629f4a70b16b474bee7c8066");
//		assertNotNull(result);
//	}
//
//	@Test
//	public void getOrdersByPincodeTest2() {
//		OrderCollectionsResult result = orderController.getOrdersByPincode(782137);
//		assertNull(result);
//	}
//
//	@Test
//	public void getOrdersByIdTest2() {
//		OrderResult result = orderController.getOrdersById("629f4a70b16b474bee7c8066");
//		assertNotNull(result);
//	}

}
