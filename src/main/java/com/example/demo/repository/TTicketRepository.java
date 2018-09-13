package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TTicket;

@Repository
public interface TTicketRepository extends CrudRepository<TTicket, Integer>{
	@Query("select a from TTicket a where a.ticketId=:ticketId")
	public TTicket getById(@Param("ticketId") int id);
	
	@Query("select a from TTicket a")
	public List<TTicket> getAllTicket();
	
	@Query("select a from TTicket a where a.activityId=:activityId")
	public List<TTicket> getByActivityId(@Param("activityId") int activityId);
	
}
