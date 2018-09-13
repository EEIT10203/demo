package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_ticket")

public class TTicket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_id", unique = true, nullable = false)
	private int ticketId;
	@Column(name = "ticket_name")
	private String ticketName;
	@Column(name = "ticket_quantity")
	private int ticketQuantity;
	@Column(name = "ticket_price")
	private int ticketPrice;
	@Column(name = "ticket_sold")
	private int ticketSold;
	@Column(name = "ticket_remain")
	private int ticketRemain;
	@Column(name = "ticket_type")
	private String ticketType;
	@Column(name = "activity_name")
	private String activityName;
	@Column(name = "activity_id")
	private int activityId;	
//	@Column(name = "buy_ticket")
//	private int buyTicket;	
	
//	public int getBuyTicket() {
//		return buyTicket;
//	}
//	public void setBuyTicket(int buyTicket) {
//		this.buyTicket = buyTicket;
//	}
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getTicketName() {
		return ticketName;
	}
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	public int getTicketQuantity() {
		return ticketQuantity;
	}
	public void setTicketQuantity(int ticketQuantity) {
		this.ticketQuantity = ticketQuantity;
	}
	public int getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	public int getTicketSold() {
		return ticketSold;
	}
	public void setTicketSold(int ticketSold) {
		this.ticketSold = ticketSold;
	}
	public int getTicketRemain() {
		return ticketRemain;
	}
	public void setTicketRemain(int ticketRemain) {
		this.ticketRemain = ticketRemain;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	
}
