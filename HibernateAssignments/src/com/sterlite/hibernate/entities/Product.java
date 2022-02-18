/**
 * @author prince.modi@stltech.in
 * @version 1.0
 * @date 18-Feb-2022
 * @copyright Sterlite Technologies Ltd. All rights reserved.
 * @description Represent Database Entity (Table) POJO Class
 */

package com.sterlite.hibernate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Prince
 *
 */
@Entity
@Table(name = "Product")
public class Product {
	
	@Id
	@Column(name = "ID")
	private int productId;
	
	@Column(name = "NAME")
	private String productName;
	private String brand;
	private float price;
	
	
	// getter and setter methods
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", brand=" + brand + ", price="
				+ price + "]";
	}
	
}
