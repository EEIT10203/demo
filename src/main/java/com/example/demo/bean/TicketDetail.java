package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TicketDetail {

	
	@Id
	private int ticketNo;
	private int orderId;
	private Integer ticketId;
	private Integer ticketStatus;
	private String ticketName;
	private int ticketPrice;

//	private String ticketStatusName;
//	
//	
//	public String getTicketStatusName() {
//		return ticketStatusName;
//	}
//	public void setTicketStatusName(String ticketStatusName) {
//		this.ticketStatusName = ticketStatusName;
//	}
	public String getTicketName() {
		return ticketName;
	}
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	public int getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public int getTicketNo() {
		return ticketNo;
	}
	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Integer getTicketId() {
		return ticketId;
	}
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	public Integer getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(Integer ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	@Override
	public String toString() {
		return "TicketDetail [ticketNo=" + ticketNo + ", orderId=" + orderId + ", ticketId=" + ticketId
				+ ", ticketStatus=" + ticketStatus + "]";
	}

	
}
