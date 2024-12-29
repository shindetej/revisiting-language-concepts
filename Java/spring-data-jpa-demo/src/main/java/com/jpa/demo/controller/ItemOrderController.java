package com.jpa.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.demo.dto.OrderRequestDTO;
import com.jpa.demo.models.ItemOrder;
import com.jpa.demo.responses.Response;
import com.jpa.demo.services.IOrderService;
@RestController
@RequestMapping("/orders")
public class ItemOrderController {
	
	private IOrderService orderService;
	
	@Autowired
	public ItemOrderController(IOrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping
	public ResponseEntity<?> addOrder(@RequestBody OrderRequestDTO orderRequest) {
		ItemOrder order = orderService.placeOrder(orderRequest);
		Response<ItemOrder> response = new Response<>("Order created successfully", order, HttpStatus.CREATED.value());
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping("/{orderId}")
	public ResponseEntity<?> updateOrder(@RequestBody OrderRequestDTO orderDTO,@PathVariable int orderId) {
		ItemOrder order = orderService.update(orderDTO,orderId);
		return new ResponseEntity<>(new Response<>("Order Updated Successfully", order, HttpStatus.OK.value()),
				HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> getAllOrders(@RequestParam(required = false) Integer orderId,
			@RequestParam(required = false) Long inventoryId) {
		List<ItemOrder> orders = orderService.getAllOrders(orderId, inventoryId);
		return new ResponseEntity<>(new Response<>("Success",orders,HttpStatus.OK.value()), HttpStatus.OK);
	}
}
