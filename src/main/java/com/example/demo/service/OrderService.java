package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TActivity;
import com.example.demo.entity.TOrder;
import com.example.demo.entity.TOrderDetail;
import com.example.demo.entity.TSaveticket;
import com.example.demo.entity.TTicket;
import com.example.demo.entity.TUser;
import com.example.demo.repository.TActivityRepository;
import com.example.demo.repository.TOrderDetailRepository;
import com.example.demo.repository.TOrderRepository;
import com.example.demo.repository.TSaveticketRepository;
import com.example.demo.repository.TTicketRepository;
import com.example.demo.utils.CommonUtils;
import com.example.demo.utils.CurrentUser;

@Service
public class OrderService {

	@Value("${activity.file.path}")
	private String imageFilePath;
	
	@Autowired
	private TOrderRepository orderRepository;
	
	@Autowired
	private CurrentUser currentuser;
	
	@Autowired
	private TOrderDetailRepository orderDetailRepository;
	
	@Autowired
	private TSaveticketRepository saveticketRepository;

	@Autowired
	private TActivityRepository activityRepository;
	
	@Autowired
	private TTicketRepository ticketRepository;
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private CurrentUser currentUser;
	
	public TOrder createOrder(int activityId, Integer ticketId, Integer buyTicket) {
		

		TActivity activity = activityRepository.getById(activityId);
		TTicket ticket = ticketRepository.getById(ticketId);
		TUser user = userservice.getUserById(currentUser.getUserId());
		//create t_order, 取得order_id
		TOrder order = new TOrder();
		order.setActivityId(activityId);
		order.setEmail(user.getEmail());
		order.setMobile(user.getMobile());
		order.setUserBirth(user.getUserBirth());
		order.setUserIdentity(user.getUserIdentity());
		order.setUserName(user.getUserName());
		order.setTotalPrice(ticket.getTicketPrice()*buyTicket.intValue());
		order.setOrderTime(CommonUtils.getNow());
		order.setUserId(user.getUserId());
		order.setOrderStatus(0);
		order.setActivityName(activity.getActivityName());
		
		TOrder rsorder = orderRepository.save(order);
		
	
		//create t_order_detail
		TOrderDetail detail = new TOrderDetail();
		
		detail.setOrderId(rsorder.getOrderId());
		detail.setTicketId(ticketId);
		detail.setBuyTicket(buyTicket);
		detail.setTicketPrice(ticket.getTicketPrice());
		
		orderDetailRepository.save(detail);
		//create  T_Saveticket
		
		for(int i=1; i<=buyTicket; i++) {
			TSaveticket saveticket = new TSaveticket();
			saveticket.setTicketId(ticket.getTicketId());
			saveticket.setOrderId(rsorder.getOrderId());
			saveticket.setTicketStatus(0);
		
			saveticketRepository.save(saveticket);
		}
		
		return rsorder;
		//多種票
		/*for(int i=0; i< ticketIdArr.length; i++) {
			Integer ticketId = ticketIdArr[i];
			Integer buyTicket = buyTicketArr[i];
			//create t_order_detail
			
			//第幾張票
			for(int j=1; j<=buyTicket; j++) {
				//create  T_Saveticket
			}
		}*/
	}
	public List<TOrder> pay() {
		return orderRepository.getByStatus(currentuser.getUserId(), 2);
	}
	public List<TOrder> waitpayCheck() {
		return orderRepository.getByStatus(currentuser.getUserId(), 0);
	}
	public List<TOrder> Cancel() {
		return orderRepository.getByStatus(currentuser.getUserId(), 9);
	}

	
	
	public void updateStatus(int orderId) {
		TOrder db = orderRepository.getById(orderId);
	
		if(db != null) {
			db.setOrderStatus(2);
			orderRepository.save(db);
		}
		
		List<TSaveticket> ticketList = saveticketRepository.getTicketByOrder(orderId);
		
		for(TSaveticket ticket :ticketList) {
			ticket.setTicketStatus(2);
			saveticketRepository.save(ticket);
		}
		
	}
	
	public void cancelStatus(int orderId) {
		TOrder db = orderRepository.getById(orderId);
	
		if(db != null) {
			db.setOrderStatus(9);
			orderRepository.save(db);
		}
		List<TSaveticket> ticketList = saveticketRepository.getTicketByOrder(orderId);
		
		for(TSaveticket ticket :ticketList) {
			ticket.setTicketStatus(9);
			saveticketRepository.save(ticket);
		}
	}
	
	public TOrder getOrderById(int orderId) {
		TOrder db = orderRepository.getById(orderId);
		
		return db;
	}
	
	
	
}
