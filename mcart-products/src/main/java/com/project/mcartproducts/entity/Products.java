package com.project.mcartproducts.entity;

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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	@Override
	public String toString() {
		return "[ProductId: "+this.productId+"  --- ProductName: "+this.productName+" --- ProductCode: "+
				this.productCode+" --- Description: "+this.description+" --- ImageURL: "+this.imageURL+
				" --- Price: "+this.price+" --- Rating: "+this.rating+" --- Manufacturer: "
				+this.manufacturer+" --- OSType: "+this.osType+"]";
	}
}
