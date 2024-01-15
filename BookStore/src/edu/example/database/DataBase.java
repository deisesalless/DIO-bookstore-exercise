package edu.example.database;

import java.util.ArrayList;
import java.util.List;

import edu.example.entity.Client;
import edu.example.entity.Coupon;
import edu.example.entity.Order;
import edu.example.entity.Product;

public class DataBase {
	private List<Product> products;
	private List<Order> orders;
	private List<Coupon> coupons;
	private Client client;
	
	public DataBase() {
		this.products = new ArrayList<>();
		this.orders = new ArrayList<>();
		this.client = new Client();
		
		this.coupons = new ArrayList<>();
        coupons.add(new Coupon("CUPOM2", 2));
        coupons.add(new Coupon("CUPOM5", 5));
        coupons.add(new Coupon("CUPOM7", 7));
	}
	
    public Client getClient() {
        return client;
    }

    public Coupon[] getCoupons() {
    	return coupons.toArray(new Coupon[coupons.size()]);
    }

    public Order[] getOrders() {
        return orders.toArray(new Order[orders.size()]);
    }

    public Product[] getProduct() {
        return products.toArray(new Product[products.size()]);
    }

    public void addProduct(Product product) {
    	products.add(product);
    }

    public void removeProduct(int posicion) {
    	products.remove(posicion);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(int posicion) {
    	orders.remove(posicion);
    }
	
	
}
