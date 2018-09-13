package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.TicketDetail;

@Repository
public interface TicketDetailRepository extends CrudRepository<TicketDetail, Integer>{
	
	@Query(value = "select st.order_id, st.ticket_no, st.ticket_id, t.ticket_name, st.ticket_status, od.ticket_price from  "
			+ "t_saveticket st, t_order_detail od, t_ticket t where st.order_id=:orderId and st.order_id = od.order_id "
			+ "and st.ticket_id = t.ticket_id", nativeQuery=true)
	public List<TicketDetail> getTicketByOrder(@Param("orderId") int orderId);
	
}
