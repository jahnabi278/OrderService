package com.terra.app.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.util.DataUtils;
import com.terra.app.dto.OrderDTO;
import com.terra.app.result.OrderCollectionsResult;
import com.terra.app.result.OrderResult;
import com.terra.app.result.Result;
import com.terra.app.service.OrderService;
import com.terra.app.util.ErrorMessages;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {

	@Mock
	DataUtils dataUtil;

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
		OrderDTO order = null;
		Result result = orderController.create(order);
		assertNull(result);
	}

	@Test
	public void createOrderTestForNotNullCheck() {
		OrderDTO order = dataUtil.createOrder();
		Mockito.when(orderService.saveOrder(order)).thenReturn(new Result(200, ErrorMessages.SAVE_SUCCESSFUL));
		Result result = orderController.create(order);
		Mockito.verify(orderService).saveOrder(order);
		assertNotNull(result);
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
