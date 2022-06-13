package com.terra.app.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.util.DataUtils;
import com.terra.app.pojos.Order;
import com.terra.app.repo.OrderRepository;
import com.terra.app.result.OrderCollectionsResult;
import com.terra.app.result.OrderResult;
import com.terra.app.result.Result;
import com.terra.app.util.ErrorMessages;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class OrderServiceTest {

	@Mock
	DataUtils dataUtil;

	@Mock
	OrderRepository orderRepository;

	@InjectMocks
	OrderService orderService;

	@Mock
	Result result;

	@Mock
	OrderResult orderResult;

	@Mock
	OrderCollectionsResult orderCollectionResult;

	@Test
	void saveOrderTestForNotNullCheck() {
		assertFalse(false);
		Order order = dataUtil.createOrder();
		Mockito.when(orderService.saveOrder(order)).thenReturn(new Result(200, ErrorMessages.SAVE_SUCCESSFUL));
		Result result = orderService.saveOrder(order);
		Mockito.verify(orderService).saveOrder(order);
		assertNotNull(result);

	}

//	@Test
//	public void getOrdersByPincodeTestForNotNullCheck() {
//		int pincode = 782137;
//		Mockito.when(orderService.getOrdersByPincode(pincode)).thenReturn(new OrderCollectionsResult());
//		OrderCollectionsResult result = orderService.getOrdersByPincode(782137);
//		Mockito.verify(orderService).getOrdersByPincode(pincode);
//		assertNotNull(result);
//	}
//
//	@Test
//	public void getOrdersByIdTestForNotNullCheck() {
//		String id = "629f4a70b16b474bee7c8066";
//		Mockito.when(orderService.getOrdersById(id)).thenReturn(new OrderResult());
//		OrderResult result = orderService.getOrdersById(id);
//		Mockito.verify(orderService).getOrdersById(id);
//		assertNotNull(result);
//	}

}
