package com.jpa.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.demo.models.InventoryItem;
import com.jpa.demo.repos.IInventoryItemRepository;
import com.jpa.demo.repos.IOrderRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.Predicate;

@Service
public class InventoryService implements IInventoryService {

	@Autowired
	private IInventoryItemRepository inventoryItemRepository;

	@Autowired
	private IOrderRepository orderRepository;

	@Override
	public InventoryItem addInventoryItem(InventoryItem item) {
		return inventoryItemRepository.save(item);
	}

	@Override
	public InventoryItem updateInventoryItem(Integer itemId, InventoryItem updatedItem) {
		InventoryItem item = inventoryItemRepository.findById(itemId)
				.orElseThrow(() -> new EntityNotFoundException("Inventory Item Not Found"));
		// Set all new values to the existing item
		item.setItemName(updatedItem.getItemName());
		item.setItemPrice(updatedItem.getItemPrice());

		// Save and return the updated inventory item
		return inventoryItemRepository.save(item);
	}

	@Override
	public List<InventoryItem> getInventoryList(Long itemId, String itemName, Double itemPrice) {
		return inventoryItemRepository.findAll((root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (itemId != null) {
                predicates.add(criteriaBuilder.equal(root.get("itemId"), itemId));
            }
            if (itemName != null) {
                predicates.add(criteriaBuilder.equal(root.get("itemName"), itemName));
            }
            if (itemPrice != null) {
                predicates.add(criteriaBuilder.equal(root.get("itemPrice"), itemPrice));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
	}

	@Override
	public InventoryItem getById(Integer itemId) {
		return inventoryItemRepository.findById(itemId)
		.orElseThrow(() -> new EntityNotFoundException("Inventory Item Not Found"));
	}

}
