package com.ap.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	
	@Id
	private String orderId;
	
	private String orderStatus; // pending ,delivered,dispatched
	
	private String payementStatus; // paid ,not paid
	
	private Integer orderAmount;
	
	@Column(length = 1000)
	private String billingAddress;
	
	private String billingPhone;
	
	private String billingName;
	
	private Date orderedDate;
	
	private Date deliveredDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "userId")
	private User userId;
	
	@OneToMany(mappedBy = "orderId",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<OrderItems> orderItems=new ArrayList<>();

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

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public List<OrderItems> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderStatus=" + orderStatus + ", payementStatus=" + payementStatus
				+ ", orderAmount=" + orderAmount + ", billingAddress=" + billingAddress + ", billingPhone="
				+ billingPhone + ", billingName=" + billingName + ", orderedDate=" + orderedDate + ", deliveredDate="
				+ deliveredDate + ", userId=" + userId + ", orderItems=" + orderItems + "]";
	}
	
	
	
	

}
