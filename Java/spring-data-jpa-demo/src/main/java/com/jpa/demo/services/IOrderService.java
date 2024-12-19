package com.jpa.demo.services;

import java.util.List;

import com.jpa.demo.dtp.OrderRequestDTO;
import com.jpa.demo.models.InventoryItem;
import com.jpa.demo.models.ItemOrder;

public interface IOrderService {
	ItemOrder placeOrder(OrderRequestDTO request);
	ItemOrder update(OrderRequestDTO request,Integer orderId,Long paymentId, Long trackId);
	List<ItemOrder> getAllOrders(Integer orderId, Long inventoryId);
	ItemOrder getById(int id);
}
