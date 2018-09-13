package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.TicketDetail;
import com.example.demo.entity.TTicket;
import com.example.demo.repository.TTicketRepository;
import com.example.demo.repository.TicketDetailRepository;

@Service
public class TicketService {
	@Autowired
	private TTicketRepository repository;
	
	@Autowired
	private TicketDetailRepository ticketDetailRepository;
	
	public List<TicketDetail> getTicketByOrder(int orderId) {
		return ticketDetailRepository.getTicketByOrder(orderId);
	}
	public List<TTicket> getByActivityId(int id) {
		return repository.getByActivityId(id);
	}
	
	public Iterable<TTicket> findAll() {
		return repository.findAll();
	}
	
	public TTicket getTicketById(int id) {
		return repository.getById(id);
	}
	
	public List<TTicket> selectAll() {
		return repository.getAllTicket();
	}
	public TTicket create(TTicket ticket) {
		ticket.setTicketSold(0);
		return repository.save(ticket);
	}
	
	public void update(TTicket ticket) {
		TTicket db = repository.getById(ticket.getTicketId());
	
		db.setTicketName(ticket.getActivityName());
		db.setActivityId(ticket.getActivityId());
		db.setTicketId(ticket.getTicketId());
		db.setTicketName(ticket.getTicketName());
		db.setTicketPrice(ticket.getTicketPrice());
		db.setTicketQuantity(ticket.getTicketQuantity());
		db.setTicketRemain(ticket.getTicketRemain());
		db.setTicketSold(ticket.getTicketSold());
		db.setTicketType(ticket.getTicketType());
	
		repository.save(db);
	}
}