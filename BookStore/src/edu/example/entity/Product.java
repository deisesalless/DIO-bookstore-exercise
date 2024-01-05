package edu.example.entity;

public abstract class Product {
	
	private String code;
	private int quantity;
	private  double price;

	public Product() {
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public abstract double calculateFreight();
	
	
	
}
