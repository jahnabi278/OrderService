package com.terra.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.terra.app.pojos.Order;
import com.terra.app.repo.OrderRepository;
import com.terra.app.result.OrderCollectionsResult;
import com.terra.app.result.OrderResult;
import com.terra.app.result.Result;
import com.terra.app.util.ErrorMessages;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	public Result saveOrder(Order order) {
		orderRepository.save(order);
		return new Result(200, ErrorMessages.SAVE_SUCCESSFUL);
	}

	public OrderCollectionsResult getOrdersByPincode(int pinCode) {
		List<Order> listOfOrders = orderRepository.findByPinCode(pinCode);
		OrderCollectionsResult result = new OrderCollectionsResult();
		if (!listOfOrders.isEmpty()) {
			result.setErrorCode(200);
			result.setErrorMessage(ErrorMessages.RETRIEVE_SUCCESSFUL);
			result.setListOfOrders(listOfOrders);
		} else {
			result.setErrorCode(404);
			result.setErrorMessage(ErrorMessages.NOT_FOUND);
			result.setListOfOrders(null);
		}
		return result;
	}

	public OrderResult getOrdersById(String id) {
		OrderResult orderResult = new OrderResult();
		Optional<Order> result = orderRepository.findById(id);
		if (result.isPresent()) {
			orderResult.setErrorCode(200);
			orderResult.setErrorMessage(ErrorMessages.RETRIEVE_SUCCESSFUL);
			orderResult.setOrder(result.get());
		} else {
			orderResult.setErrorCode(404);
			orderResult.setErrorMessage(ErrorMessages.NOT_FOUND);
			orderResult.setOrder(null);
		}
		return orderResult;
	}

}
