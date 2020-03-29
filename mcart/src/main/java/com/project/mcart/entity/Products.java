package com.project.mcart.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
@TableGenerator(name="Products", initialValue=1)
public class Products {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="Products")
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="product_code")
	private String productCode;
	
	@Column(name="description")
	private String description;
	
	@Column(name="image_url")
	private String imageURL;
	
	@Column(name="price")
	int price;
	
	@Column(name="rating")
	int rating;
	
	@Column(name="manufacturer")
	private String manufacturer;
	
	@Column(name="os_type")
	private String osType;

}
