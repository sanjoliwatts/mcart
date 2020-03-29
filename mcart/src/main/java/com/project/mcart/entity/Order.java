package com.project.mcart.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name="Order", initialValue=2001) //, allocationSize=50
public class Order extends AuditModel{
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="Order")
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="cart_id")
	private int cartId;
	
	@Column(name="date_of_order")
	private Date dateOfOrder;
	
	@Column(name="order_amount")
	private Long orderAmount;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="order_id", referencedColumnName =  "order_id")
	private List<OrderDetails> productsInOrder;
	
	public Order() {}
}
