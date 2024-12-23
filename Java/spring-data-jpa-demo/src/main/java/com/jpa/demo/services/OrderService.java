package com.jpa.demo.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.jpa.demo.dto.OrderRequestDTO;
import com.jpa.demo.exceptions.InvalidOrderIdException;
import com.jpa.demo.models.InventoryItem;
import com.jpa.demo.models.ItemOrder;
import com.jpa.demo.models.Payment;
import com.jpa.demo.models.Tracking;
import com.jpa.demo.repos.IInventoryItemRepository;
import com.jpa.demo.repos.IOrderRepository;
import com.jpa.demo.repos.IPaymentRepository;
import com.jpa.demo.repos.ITrackingRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class OrderService implements IOrderService {
	
	IOrderRepository orderRepo;
	
	IPaymentRepository paymentRepo;
	
	ITrackingRepository trackingRepo;
	
	IInventoryItemRepository inventoryRepo;
	
	
	// autowiring here
	public OrderService(IOrderRepository orderRepo,IInventoryItemRepository inventoryRepo,IPaymentRepository paymentRepo,ITrackingRepository trackingRepo) {
		this.orderRepo= orderRepo;
		this.inventoryRepo = inventoryRepo;
		this.paymentRepo =paymentRepo;
		this.trackingRepo =trackingRepo;
	}
	

	@Override
	public ItemOrder placeOrder( OrderRequestDTO request) {
		Payment payment = new Payment();
		payment.setAmount(request.getAmount());
		payment.setCustomerId(request.getCustomerId());
		payment.setModeOfPayment(request.getModeOfPayment());
		
		List<InventoryItem> list = inventoryRepo.findAllById(request.getItemIds());
		Tracking tracking = new Tracking();
		tracking.setShipmentNumber("TMS0"+new Random().nextLong(10000));
		tracking.setTrackingStatus("Order Placed");
		tracking.setTrackingVendor(request.getLogistic());
		
		ItemOrder item = new ItemOrder();
		item.setPayment(payment);
		item.setTracking(tracking);
		item.setItems(list);
		return orderRepo.save(item);
	}

	@Override
	public ItemOrder update(OrderRequestDTO request,Integer orderId) {
		ItemOrder existingOrder = orderRepo.findById(orderId)
				.orElseThrow(() -> new InvalidOrderIdException("Order Id Invalid"));

		// Find the Payment and Tracking entities by their respective IDs
		Payment payment = paymentRepo.findById(request.getPaymentId())
				.orElseThrow(() -> new EntityNotFoundException("Payment not found"));

		Tracking tracking = trackingRepo.findById(request.getTrackingId())
				.orElseThrow(() -> new EntityNotFoundException("Tracking not found"));

		payment.setAmount(request.getAmount());
		payment.setCustomerId(request.getCustomerId());
		payment.setModeOfPayment(request.getModeOfPayment());
		
		tracking.setShipmentNumber("REV"+new Random().nextLong(10000));
		tracking.setTrackingVendor(request.getLogistic());
		
		existingOrder.setPayment(payment);
		existingOrder.setTracking(tracking);
		// Save and return the updated order
		return orderRepo.save(existingOrder);
	}

	// Get all Orders with Filters (orderId and inventoryId)
	public List<ItemOrder> getAllOrders(Integer orderId, Long inventoryId) {
		// If orderId is provided, filter orders by orderId
		
		if (orderId != null) {
			Optional<ItemOrder> order = orderRepo.findById(orderId);
			return Arrays.asList(order.get()); // Custom query can be added for filtering by orderId
		}

		// If inventoryId is provided, filter orders by inventory items
		if (inventoryId != null) {

			return orderRepo.findOrdersByInventoryItem(inventoryId); // Custom query here
		}

		return orderRepo.findAll();
	}

	@Override
	public ItemOrder getById(int id) {
		ItemOrder existingOrder = orderRepo.findById(id)
				.orElseThrow(() -> new InvalidOrderIdException("Order Not Found"));
		return existingOrder;
	}
	
	
	// Delete an Order
    public void deleteOrder(Integer orderId) {
        // Check if order exists
    	ItemOrder existingOrder = orderRepo.findById(orderId)
                .orElseThrow(() -> new EntityNotFoundException("Order not found"));

        // Delete the order
        orderRepo.delete(existingOrder);
    }

}
