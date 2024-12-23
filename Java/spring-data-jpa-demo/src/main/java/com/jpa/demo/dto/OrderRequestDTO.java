package com.jpa.demo.dto;

import java.util.List;

public class OrderRequestDTO {
	private Double amount;
	private String modeOfPayment;
	private Long customerId;
	private Long paymentId;
	private Long trackingId;
	private List<Integer> itemIds;
	private String logistic; // e.g., "Standard", "Express"

	// Constructors
	public OrderRequestDTO() {
	}

	public OrderRequestDTO(Double amount, String modeOfPayment, Long customerId, Long paymentId, Long trackingId,
			List<Integer> itemIds, String logistic) {
		super();
		this.amount = amount;
		this.modeOfPayment = modeOfPayment;
		this.customerId = customerId;
		this.paymentId = paymentId;
		this.trackingId = trackingId;
		this.itemIds = itemIds;
		this.logistic = logistic;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(Long trackingId) {
		this.trackingId = trackingId;
	}

	public List<Integer> getItemIds() {
		return itemIds;
	}

	public void setItemIds(List<Integer> itemIds) {
		this.itemIds = itemIds;
	}

	public String getLogistic() {
		return logistic;
	}

	public void setLogistic(String logistic) {
		this.logistic = logistic;
	}

	@Override
	public String toString() {
		return "OrderRequestDTO [amount=" + amount + ", modeOfPayment=" + modeOfPayment + ", customerId=" + customerId
				+ ", paymentId=" + paymentId + ", trackingId=" + trackingId + ", itemIds=" + itemIds + ", logistic="
				+ logistic + "]";
	}
	
	

}
