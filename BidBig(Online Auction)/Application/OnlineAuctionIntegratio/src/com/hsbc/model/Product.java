package com.hsbc.model;

import java.sql.Blob;
import java.util.List;

public class Product {
	private long  prodID,catID,sellerID;
	int quantity;
	private  String name,description;
	private double actualPrice;
	Blob productimage;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(long prodID, long catID, long sellerID, String name, String description,int quantity, 
			double actualPrice) {
		super();
		this.prodID = prodID;
		this.catID = catID;
		this.sellerID = sellerID;
		this.quantity = quantity;
		this.name = name;
		this.description = description;
		this.actualPrice = actualPrice;
		//this.productimage=productimage;
	}

	public long getProdID() {
		return prodID;
	}

	public void setProdID(long prodID) {
		this.prodID = prodID;
	}

	public long getCatID() {
		return catID;
	}

	public void setCatID(long catID) {
		this.catID = catID;
	}

	public long getSellerID() {
		return sellerID;
	}

	public void setSellerID(long sellerID) {
		this.sellerID = sellerID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(double actualPrice) {
		this.actualPrice = actualPrice;
	}
	
	

	public Blob getProductimage() {
		return productimage;
	}

	public void setProductimage(Blob productimage) {
		this.productimage = productimage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(actualPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (catID ^ (catID >>> 32));
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (prodID ^ (prodID >>> 32));
		result = prime * result + quantity;
		result = prime * result + (int) (sellerID ^ (sellerID >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (Double.doubleToLongBits(actualPrice) != Double.doubleToLongBits(other.actualPrice))
			return false;
		if (catID != other.catID)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (prodID != other.prodID)
			return false;
		if (quantity != other.quantity)
			return false;
		if (sellerID != other.sellerID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [prodID=" + prodID + ", catID=" + catID + ", sellerID=" + sellerID + ", quantity=" + quantity
				+ ", name=" + name + ", description=" + description + ", actualPrice=" + actualPrice + "]";
	}

	
	
}
