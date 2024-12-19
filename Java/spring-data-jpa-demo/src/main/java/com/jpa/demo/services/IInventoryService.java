package com.jpa.demo.services;

import java.util.List;

import com.jpa.demo.models.InventoryItem;

public interface IInventoryService {
	InventoryItem addInventoryItem(InventoryItem item);
	InventoryItem updateInventoryItem(Integer itemId, InventoryItem updatedItem);;
	List<InventoryItem> getInventoryList(Long itemId, String itemName, Double itemPrice);
	InventoryItem getById(Integer itemId);
}
