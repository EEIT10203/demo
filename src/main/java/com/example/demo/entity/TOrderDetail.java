package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_order_detail")
public class TOrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "detail_id", unique = true, nullable = false)
	private int detailId;
	@Column(name = "order_id")
	private int orderId;
	@Column(name = "ticket_id")
	private int ticketId;
	@Column(name = "ticket_price")
	private int ticketPrice;
	@Column(name = "buy_ticket")
	private int buyTicket;
	@Column(name = "activity_name")
	private int activityName;	
	
	
	public int getActivityName() {
		return activityName;
	}
	public void setActivityName(int activityName) {
		this.activityName = activityName;
	}
	public int getDetailId() {
		return detailId;
	}
	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
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
	
	
}
