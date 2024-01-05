package edu.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private String code;
	private List<Product> products;
	private Client client;
	private double totalPrice;
	
	public Order() {
		
	}

	public Order(List<Product> products) {
		this.products = new ArrayList<>();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	private String getBoughtProducts() {

        StringBuilder products = new StringBuilder();
        products.append("[");
        for (Product product: getProducts()) {
            products.append(product.toString());
            products.append("Qtd:");
            products.append(product.getQuantity());
            products.append(" ");
        }
        products.append("]");

        return products.toString();
    }
	
	@Override
    public String toString() {
        return "Pedido {" +
                "codigo = '" + code + '\'' +
                ", cliente = " + client +
                ", produtos = " + getBoughtProducts() +
                ", total = " + totalPrice +
                '}';
    }
}
