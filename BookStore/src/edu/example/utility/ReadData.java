package edu.example.utility;


import java.util.Optional;
import java.util.Scanner;

import edu.example.business.ProductBusiness;
import edu.example.database.DataBase;
import edu.example.entity.Book;
import edu.example.entity.Coupon;
import edu.example.entity.Notepad;
import edu.example.entity.Order;
import edu.example.entity.Product;
import edu.example.entity.constant.Kindbook;
import edu.example.entity.constant.Materials;

public final class ReadData {
	private static Scanner scanner;
	
	// Método para entrada de dados
	static {
		scanner = new Scanner(System.in);
	}
	
	// Método para ler a entrada de dados
	public static String readData() {
		String text = scanner.nextLine();
		return text;
	}
	
	// Método para ler os dados do livro que será cadastrado
	public static Book readBook() {
		System.out.println("Cadastrando livro...");
		Book book = new Book();

		System.out.println("Digite o nome do livro:");
		String name = readData();
		book.setName(name);

		System.out.println("Digite o gênero: DRAMA, SUSPENSE, ROMANCE");
		String bookType = readData();
		book.setBookType(Kindbook.valueOf(bookType.toUpperCase()));

		System.out.println("Digite o preço:(padrão 0.00)");
		String price = readData();
		book.setPrice(Double.parseDouble(price));
	    return book;
	}
	
	// Método para ler os dados do caderno que será cadastrado
	public static Notepad readNotepad() {
		System.out.println("Cadastrando caderno...");
		Notepad notepad = new Notepad();

		System.out.println("Digite a quantidade de matérias: M2, M5, M10");
		String quantity = readData();
		notepad.setKind(Materials.valueOf(quantity.toUpperCase()));

		System.out.println("Digite o preço: (padrão 0.0)");
		String price = readData();
		notepad.setPrice(Double.parseDouble(price));
		
		return notepad;
	}
	
	// Método para ler os dados dos pedidos cadastrados
	public static Order readOrder(DataBase dataBase) {
		ProductBusiness productBusiness = new ProductBusiness(dataBase);

		System.out.println("Cadastrando pedido...");
		Order order = new Order();
		String option = "s";
		
		do {
			System.out.println("Digite o código do produto (livro/Caderno): ");
			String code = readData();

			Optional<Product> result = productBusiness.consult(code);
			if (result.isPresent()) {

				Product product = result.get();

				System.out.println("Digite a quantidade: (digite numero inteiro)");
				String quantity = readData();
				product.setQuantity(Integer.parseInt(quantity));
				order.getProducts().add(product);
			} else {
				System.out.println("Produto inexistente. Escolha um produto válido.");
			}

			System.out.println("Deseja selecionar mais um produto? s/n");
			option = readData();
		} while("s".equals(option));

		return order;
	}
	
	// Método para ler os cupons
	public static Optional<Coupon> readCoupon(DataBase dataBase) {
		System.out.println("Caso queira utilizar algum cupom escolha entre: CUPOM2, CUPOM5, CUPOM7. Se não desejar, deixe em branco.");
		String discount = readData();

		for (Coupon coupon: dataBase.getCoupons()) {
			if (coupon.getCode().equalsIgnoreCase(discount)) {
				return Optional.of(coupon);
			}
		}
		return Optional.empty();
	}

}
