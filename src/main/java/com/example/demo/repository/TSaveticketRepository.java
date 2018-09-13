package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TSaveticket;

@Repository
public interface TSaveticketRepository extends CrudRepository<TSaveticket, Integer>{
	
	@Query("select a from TSaveticket a where a.ticketId=:ticketId")
	public TSaveticket getById(@Param("ticketId") int ticketId);
	
	@Query("select a from TSaveticket a")
	public List<TSaveticket> getAll();
	
	@Query("select a from TSaveticket a where a.ticketStatus=:ticketStatus")
	public List<TSaveticket> getTicketByStatus(@Param("ticketStatus") int ticketStatus);
	
	
	@Query("select a from TSaveticket a where  a.orderId=:orderId")
	public List<TSaveticket> getTicketByOrder(@Param("orderId") int orderId);
	
	/*@Modifying
	@Query("update TSaveticket a set a.ticketStatus=:ticketStatus where a.orderId=:orderId")
	public void updateStatusByOrderId(@Param("orderId") int orderId, @Param("ticketStatus") int ticketStatus);*/
}
