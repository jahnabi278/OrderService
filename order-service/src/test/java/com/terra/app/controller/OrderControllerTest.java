package com.terra.app.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
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
	private static Logger logger = LogManager.getLogManager().getLogger(OrderControllerTest.class.getName());

	@Mock
	OrderService orderService;

	@InjectMocks
	OrderController orderController;

	@Mock
	Result result;

	@Mock
	OrderResult orderResult;

	@Mock
	OrderCollectionsResult orderCollectionResult;

	@Test
	public void createOrderTestforNullCheck() {
		Order order = createOrder();
		Result result = orderController.create(order);
		assertNull(result);
	}

	@Test
	public void createOrderTestForNotNullCheck() {
		Order order = createOrder();
		Mockito.when(orderService.saveOrder(order)).thenReturn(new Result(200, ErrorMessages.SAVE_SUCCESSFUL));
		Result result = orderController.create(order);
		Mockito.verify(orderService).saveOrder(order);
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
			logger.log(Level.SEVERE, "Parsing Exception : ", e);
		}
		return date;
	}

	@Test
	public void getOrdersByPincodeTestForNotNullCheck() {
		int pincode = 782137;
		Mockito.when(orderService.getOrdersByPincode(pincode)).thenReturn(new OrderCollectionsResult());
		OrderCollectionsResult result = orderController.getOrdersByPincode(782137);
		Mockito.verify(orderService).getOrdersByPincode(pincode);
		assertNotNull(result);
	}

	@Test
	public void getOrdersByIdTestNotNullCheck() {
		String id = "629f4a70b16b474bee7c8066";
		Mockito.when(orderService.getOrdersById(id)).thenReturn(new OrderResult());
		OrderResult result = orderController.getOrdersById(id);
		Mockito.verify(orderService).getOrdersById(id);
		assertNotNull(result);
	}

	@Test
	public void getOrdersByPincodeTestNullCheck() {
		OrderCollectionsResult result = orderController.getOrdersByPincode(782137);
		assertNull(result);
	}

	@Test
	public void getOrdersByIdTestNullCheck() {
		OrderResult result = orderController.getOrdersById("629f4a70b16b474bee7c8066");
		assertNull(result);
	}

}
