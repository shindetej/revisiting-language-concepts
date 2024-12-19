package com.jpa.demo.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class InventoryItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;

	private String itemName;

	private Double itemPrice;

	// Other fields related to the item (like description, quantity, etc.)

	@ManyToMany(mappedBy = "items")
	@JsonIgnore
	private List<ItemOrder> orders ; // Orders containing this item

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public List<ItemOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<ItemOrder> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return " {itemId : " + itemId + ", itemName : " + itemName + ", itemPrice : " + itemPrice + ", orders : "
				+ orders + "}";
	}

}
