package com.ap.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;

public class OrderDto {
	
	private String orderId;
	private String orderStatus="PENDING"; 
	private String payementStatus="NOTPAID"; 
	private Integer orderAmount;
	@Column(length = 1000)
	private String billingAddress;
	private String billingPhone;
	private String billingName;
	private Date orderedDate;
	private Date deliveredDate;
//	private User userId;
	private List<OrderItemDto> orderItems = new ArrayList<>();

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPayementStatus() {
		return payementStatus;
	}

	public void setPayementStatus(String payementStatus) {
		this.payementStatus = payementStatus;
	}

	public Integer getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Integer orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public String getBillingPhone() {
		return billingPhone;
	}

	public void setBillingPhone(String billingPhone) {
		this.billingPhone = billingPhone;
	}

	public String getBillingName() {
		return billingName;
	}

	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}

	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	public Date getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(Date deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public List<OrderItemDto> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemDto> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "OrderDto [orderId=" + orderId + ", orderStatus=" + orderStatus + ", payementStatus=" + payementStatus
				+ ", orderAmount=" + orderAmount + ", billingAddress=" + billingAddress + ", billingPhone="
				+ billingPhone + ", billingName=" + billingName + ", orderedDate=" + orderedDate + ", deliveredDate="
				+ deliveredDate + ", orderItems=" + orderItems + "]";
	}
	
	

}
