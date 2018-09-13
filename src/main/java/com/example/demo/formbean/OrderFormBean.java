package com.example.demo.formbean;

import java.util.List;

import com.example.demo.bean.TicketDetail;

public class OrderFormBean {
	private int orderId;
	private String userId;
	private Integer[] ticketId;
	private String userName;
	private String mobile;
	private String email;
	private int totalPrice;
	private String orderTime;	
	private String userIdentity;
	private String userBirth;

	private int detailId;
	private int ticketPrice;
	private int buyTicket;
	private int ticketRemain;
	private String activityName;
	private int orderStatus;
	private int activityId;
	
	private List<TicketDetail> ticketList;
	
	public List<TicketDetail> getTicketList() {
		return ticketList;
	}
	public void setTicketList(List<TicketDetail> ticketList) {
		this.ticketList = ticketList;
	}
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public int getTicketRemain() {
		return ticketRemain;
	}
	public void setTicketRemain(int ticketRemain) {
		this.ticketRemain = ticketRemain;
	}
	public int getDetailId() {
		return detailId;
	}
	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}
	public int getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public int getBuyTicket() {
		return buyTicket;
	}
	public void setBuyTicket(int buyTicket) {
		this.buyTicket = buyTicket;
	}
	public String getUserIdentity() {
		return userIdentity;
	}
	public void setUserIdentity(String userIdentity) {
		this.userIdentity = userIdentity;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public Integer[] getTicketId() {
		return ticketId;
	}
	public void setTicketId(Integer[] ticketId) {
		this.ticketId = ticketId;
	}

	
	
}
