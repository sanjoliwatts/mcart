package com.project.mcartorders.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.project.mcartorders.dto.CartDTO;
import com.project.mcartorders.dto.CartDetailsDTO;
import com.project.mcartorders.dto.OrderDetailsDTO;
import com.project.mcartorders.entity.Orders;
import com.project.mcartorders.repository.OrderRepository;



@Service("orderService")
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	final Logger logger = (Logger)LoggerFactory.getLogger(this.getClass());
	
	public String createNewOrder(String username, int orderAmount) {
		logger.info("Service username "+username+" orderAmount "+orderAmount);
		
		CartDTO cartDTO =  getCallToUpdateCartStatus(username, "Closed");
		
		Orders order = new Orders();
		order.setDateOfOrder(new Date());
		order.setOrderAmount(orderAmount);
		order.setCartId(cartDTO.getCartId());
		order = orderRepository.save(order);
		
		List<OrderDetailsDTO> list = new ArrayList<OrderDetailsDTO>();
		for(CartDetailsDTO c: cartDTO.getProductsInCart()) {
			OrderDetailsDTO orderDetails = new OrderDetailsDTO();
			orderDetails.setProductName(c.getProductName());
			orderDetails.setQuantity(c.getQuantity());
			//orderDetails.setProductId(c.getProductId());  ----  Autogenerate primary key
			orderDetails.setOrderId(order.getOrderId());
			//list.add(orderDetails);
			postCallToSaveOrderDetails(orderDetails);
		}
		return "New Order Placed With Id: "+order.getOrderId();
	}
	
	 public CartDTO getCallToUpdateCartStatus(String username, String status) {
		 return restTemplate.getForObject("http://localhost:8083/updateCartStatus?"
					+"username="+username+"&status="+status, CartDTO.class);
	 }
	 
	 public String postCallToSaveOrderDetails(OrderDetailsDTO orderDetails) {
		 return restTemplate.postForObject("http://localhost:8086/saveOrderDetails/", orderDetails, String.class);
	 }
}
