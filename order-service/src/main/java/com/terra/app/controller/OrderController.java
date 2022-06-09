package com.terra.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.terra.app.pojos.Order;
import com.terra.app.result.OrderCollectionsResult;
import com.terra.app.result.OrderResult;
import com.terra.app.result.Result;
import com.terra.app.service.OrderService;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
	@Autowired
	OrderService orderService;

	@PostMapping
	public Result create(@Valid @RequestBody Order order) {
		return orderService.saveOrder(order);
	}

	@GetMapping("pincode/{pinCode}")
	public OrderCollectionsResult getOrdersByPincode(@PathVariable int pinCode) {
		return orderService.getOrdersByPincode(pinCode);
	}

	@GetMapping("/{id}")
	public OrderResult getOrdersById(@PathVariable String id) {
		return orderService.getOrdersById(id);
	}
}
