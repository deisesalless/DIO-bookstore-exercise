package edu.example.entity;

public class Coupon {
	private String code;
	private int discount;
	
	public Coupon() {
		
	}

	public Coupon(String code, int discount) {
		super();
		this.code = code;
		this.discount = discount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	
	
}
