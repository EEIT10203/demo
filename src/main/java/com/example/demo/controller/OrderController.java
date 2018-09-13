package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.entity.TActivity;
import com.example.demo.entity.TOrder;
import com.example.demo.entity.TPayment;
import com.example.demo.entity.TTicket;
import com.example.demo.formbean.OrderFormBean;
import com.example.demo.formbean.PaymentFormBean;
import com.example.demo.formbean.SigninFormBean;
import com.example.demo.formbean.TicketFormBean;
import com.example.demo.repository.TPaymentRepository;
import com.example.demo.service.ActivityService;
import com.example.demo.service.OrderService;
import com.example.demo.service.TicketService;
import com.example.demo.utils.CommonUtils;

@Controller
@RequestMapping(value = "/order", method = RequestMethod.GET)
public class OrderController {
	@Value("${activity.file.path}")
	private String imageFilePath;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private TPaymentRepository paymentRepository;
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private ActivityService activityService;
	
//	@Autowired
//	private CurrentUser currentUser;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) {

		return "redirect:/order";
	}	

	@PreAuthorize("hasAnyAuthority('U','M','T','P')")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String toAdd() {
		return "order/create";
	}
	
    @PreAuthorize("hasAnyAuthority('U','M','T','P')")
	@RequestMapping(value = "/activity/{id}/signin", method = RequestMethod.GET)
	public String signin(Model model, @PathVariable("id") int id) {
		
		TActivity entity = activityService.getActivityById(id);	
		SigninFormBean bean = new SigninFormBean();
		
			bean.setActivityId(entity.getActivityId());
			bean.setActivityName(entity.getActivityName());
			bean.setActivityDate(CommonUtils.timestampToString(entity.getActivityDate()));
			bean.setActivityPlace(entity.getActivityPlace());
			bean.setActiivityDescription(entity.getActiivityDescription());
			bean.setActivityImage(entity.getActivityImage());
			bean.setHostTel(entity.getHostTel());
			bean.setHostMail(entity.getHostMail());
			

			
		List<TTicket> entity1= ticketService.getByActivityId(id);
		List<TicketFormBean> ticket1 = new ArrayList<TicketFormBean>();	
		

		for(TTicket entity2 :entity1) {
			TicketFormBean ticketbean = new TicketFormBean();
		
			ticketbean.setTicketId(entity2.getTicketId());
			ticketbean.setTicketName(entity2.getTicketName());
			ticketbean.setTicketPrice(entity2.getTicketPrice());
			ticketbean.setTicketRemain(entity2.getTicketRemain());
			ticketbean.setTicketType(entity2.getTicketType());	
			
			ticket1.add(ticketbean);
		}
	        
		model.addAttribute("bean",bean);
		model.addAttribute("ticket",ticket1);
		return "/signin/signintable";
	}
    
    
	
	@PreAuthorize("hasAnyAuthority('U','M','T','P')")
	@RequestMapping(value = "/addsignin", method = RequestMethod.POST)
	public String add(SigninFormBean formBean) {
		
		
		TOrder order = orderService.createOrder(formBean.getActivityId(), formBean.getTicketId(), formBean.getBuyTicket());
		if(order.getTotalPrice()>0) {
			return "redirect:/order/"+order.getOrderId()+"/pay";
		}
		else {
			return "redirect:/order/"+order.getOrderId()+"/orderComplete";
		}
		
	}	
	
	@PreAuthorize("hasAnyAuthority('U','M','T','P')")
	@RequestMapping(value = "/ticket", method = RequestMethod.GET)
	public String toAdd(Model model ,@PathVariable("id") String id) {
//		TOrder entity = Oservice.getByUserId(id);
//		OrderFormBean bean = new OrderFormBean();
//		bean.setOrderId(entity.getOrderId());
//		bean.setMobile(entity.getMobile());
//		bean.setEmail(entity.getEmail());
//		bean.setUserBirth(CommonUtils.timestampToString(entity.getUserBirth()));
//		bean.setUserIdentity(entity.getUserIdentity());
//		model.addAttribute("bean",bean);
		
		return "/order/order";
	}

	@PreAuthorize("hasAnyAuthority('U','M','T','P')")
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	public String doAdd(OrderFormBean order) {
		


		return "redirect:/order/ticket";
	}
	
	
	@PreAuthorize("hasAnyAuthority('U','M','T','P')")
	@RequestMapping(value ="/{orderId}/pay", method = RequestMethod.GET)
	public String topay(Model model, @PathVariable("orderId") int id) {
		
		TOrder order = orderService.getOrderById(id);
		
		
		model.addAttribute("orderId" ,id );
		model.addAttribute("totalPrice" ,order.getTotalPrice() );
		
		return "/payment/payment";
	}	
	
	
	@PreAuthorize("hasAnyAuthority('U','M','T','P')")
	@RequestMapping(value = "/dopay", method = RequestMethod.POST)
	public String dopay(PaymentFormBean payment) {
		
		TPayment entity = new TPayment();
		TOrder order = orderService.getOrderById(payment.getOrderId());
		entity.setOrderId(order.getOrderId());
		entity.setTotalPrice(order.getTotalPrice());
		entity.setPaymentStatus("O"); //原始交易
		entity.setPaymentType(payment.getPaymentType());
		paymentRepository.save(entity);
		
		return "redirect:/order/"+payment.getOrderId()+"/orderComplete";
	}	
	
	
	@PreAuthorize("hasAnyAuthority('U','M','T','P')")
	@RequestMapping(value = "/{orderId}/orderComplete", method = RequestMethod.GET)
	public String orderComplete(@PathVariable("orderId") int id) {
		

		orderService.updateStatus(id);
		

		return "redirect:/ticket/tickethomepage";
	}	

	@RequestMapping(value = "/{id}/cancel", method = RequestMethod.GET)
	public String cancel(Model model, @PathVariable("id") int id) {
		
		List<TPayment> orgPayments =  paymentRepository.getByOrderId(id);
		if(orgPayments.size() > 0) {
			TPayment orgPayment = orgPayments.get(0);
			TPayment entity = new TPayment();
			TOrder order = orderService.getOrderById(orgPayment.getOrderId());
			entity.setOrderId(order.getOrderId());
			entity.setTotalPrice(order.getTotalPrice()*(-1));
			entity.setPaymentStatus("Refound"); //退貨交易
			entity.setPaymentType(orgPayment.getPaymentType());
			paymentRepository.save(entity);
		}
		//取消
		orderService.cancelStatus(id);

		return "redirect:/ticket/tickethomepage";
	}

}
