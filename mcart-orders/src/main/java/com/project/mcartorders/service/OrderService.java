package com.project.mcartorders.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
	
	@Autowired 
	DiscoveryClient client;
	
	final Logger logger = (Logger)LoggerFactory.getLogger(this.getClass());
	

	
	public String createNewOrder(String username, int orderAmount) {
		logger.info("Service username "+username+" orderAmount "+orderAmount);
		
		CartDTO cartDTO =  getCallToUpdateCartStatus(username, "Closed");
		
		Orders order = new Orders();
		order.setDateOfOrder(new Date());
		order.setOrderAmount(orderAmount);
		order.setCartId(cartDTO.getCartId());
		order = orderRepository.save(order);
		
		
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
		 
		 List<ServiceInstance> instances=client.getInstances("MCARTCART");
		 ServiceInstance instance=instances.get(0);
		 URI cartURI = instance.getUri();
		 
		 return restTemplate.getForObject(cartURI+"/carts/updateCartStatus?"
					+"username="+username+"&status="+status, CartDTO.class);
	 }
	 
	 public String postCallToSaveOrderDetails(OrderDetailsDTO orderDetails) {
			List<ServiceInstance> instances=  client.getInstances("MCARTORDERDETAILS");
			ServiceInstance instance=instances.get(0);
			URI orderDetailsURI = instance.getUri();
		 
		 return new RestTemplate().postForObject(orderDetailsURI+"/orderDetails/saveOrderDetails/", orderDetails, String.class);
	 }
}
