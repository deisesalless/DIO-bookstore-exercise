package edu.example.business;

import java.time.LocalDate;
import java.util.List;

import edu.example.database.DataBase;
import edu.example.entity.Coupon;
import edu.example.entity.Order;
import edu.example.entity.Product;

public class OrderBusiness {
	private DataBase dataBase;

	public OrderBusiness(DataBase dataBase) {
		this.dataBase = dataBase;
	}

	// Método para calcular o valor total do pedido
    private double calculateTotal(List<Product> products, Coupon coupon) {
        double total = 0.0;
        for (Product product: products) {
            total += product.calculateFreight();
        }

        if (coupon != null) {
            return  total * (1 - coupon.getDiscount());
        } else {
            return total;
        }
    }
	
    // Método para criar um novo pedido sem cupom
    public void create(Order newOrder) {
        create(newOrder);
    }
    
    // Método para criar um novo pedido com cupom
    public void create(Order newOrder, Coupon coupon) {
    	String code = "PE%4d%2d%04d";
        create(newOrder, coupon);
        LocalDate today = LocalDate.now();
        
        code = String.format(code, today.getYear(), today.getMonthValue(), dataBase.getOrders().length);
        newOrder.setCode(code);
        newOrder.setClient(dataBase.getClient());
        newOrder.setTotalPrice(calculateTotal(newOrder.getProducts(), coupon));
        dataBase.addOrder(newOrder);
        System.out.println("Pedido salvo com sucesso.");
    }
    
    // Método para deletar o pedido
    public void delete(String code) {
        int deleteOrder = -1;
        
        for (int i = 0; i < dataBase.getOrders().length; i++) {
            Order order = dataBase.getOrders()[i];
            if (order.getCode().equals(code)) {
            	deleteOrder = i;
                break;
            }
        }

        if (deleteOrder != -1) {
        	dataBase.removeOrder(deleteOrder);
            System.out.println("Pedido excluído com sucesso.");
        } else {
            System.out.println("Pedido inexistente.");
        }     
    }
    
    // Método para listar todos os pedidos
    public void allList() {
        if (dataBase.getOrders().length == 0) {
            System.out.println("Não existem pedidos cadastrados");
        } else {

            for (Order order: dataBase.getOrders()) {
                System.out.println(order.toString());
            }
        }
    }
    

    
}
