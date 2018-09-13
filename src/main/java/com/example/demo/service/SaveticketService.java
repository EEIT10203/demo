package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TSaveticket;
import com.example.demo.repository.TSaveticketRepository;

@Service
public class SaveticketService {
	
	@Autowired
	private TSaveticketRepository saveticketRepository;


	
	public Iterable<TSaveticket> findAll() {
		return saveticketRepository.findAll();
	}
	
//	public TSaveticket getTicketById(Integer id) {
//		return repository.getById(id);
//	}	
	
	public List<TSaveticket> selectAll() {
		return saveticketRepository.getAll();
	}
	
	
	public TSaveticket create(TSaveticket saveticket) {
		
		return saveticketRepository.save(saveticket);
	}
	
	public void update(TSaveticket saveticket) {
		TSaveticket db = saveticketRepository.getById(saveticket.getOrderId());
	

		db.setTicketId(saveticket.getTicketId());
		db.setTicketNo(saveticket.getTicketNo());
		
		saveticketRepository.save(db);
	}

}
