package edu.example.app;

import java.util.Optional;

import edu.example.business.ClientBusiness;
import edu.example.business.OrderBusiness;
import edu.example.business.ProductBusiness;
import edu.example.database.DataBase;
import edu.example.entity.Book;
import edu.example.entity.Client;
import edu.example.entity.Coupon;
import edu.example.entity.Notepad;
import edu.example.entity.Order;
import edu.example.utility.ReadData;

public class Star {
	
    private static Client loggedClient = null;
    private static DataBase dataBase = new DataBase();
    private static ClientBusiness clientBusiness = new ClientBusiness(dataBase);
    private static OrderBusiness orderBusiness = new OrderBusiness(dataBase);
    private static ProductBusiness productBusiness = new ProductBusiness(dataBase);

	public static void main(String[] args) {
		
        System.out.println("Bem vindo(a) ao e-Compras");
        String option = "";

        while(true) {
            if (loggedClient == null) {
                System.out.println("Digite o CPF:");
                String cpf = "";
                cpf = ReadData.readData();
                identifyUser(cpf);
            }

            System.out.println("Selecione uma opção:");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Excluir Livro");
            System.out.println("3 - Cadastrar Caderno");
            System.out.println("4 - Excluir Caderno");
            System.out.println("5 - Fazer pedido");
            System.out.println("6 - Excluir pedido");
            System.out.println("7 - Listar produtos");
            System.out.println("8 - Listar pedidos");
            System.out.println("9 - Deslogar");
            System.out.println("10 - Sair");

            option = ReadData.readData();

            switch (option) {
                case "1": // Cadastra livro
                    Book book = ReadData.readBook();
                    productBusiness.create(book);
                    break;
                    
                case "2": // Exclui livro
                    System.out.println("Digite o código do livro:");
                    String bookCode = ReadData.readData();
                    productBusiness.delete(bookCode);
                    break;
                    
                case "3": // Cadastra caderno
                    Notepad notepad = ReadData.readNotepad();
                    productBusiness.create(notepad);
                    break;
                    
                case "4": // Exclui caderno
                    System.out.println("Digite o código do caderno:");
                    String notepadCode = ReadData.readData();
                    productBusiness.delete(notepadCode);
                    break;
                    
                case "5": // Fazer pedido com e sem cupom de desconto
                    Order order = ReadData.readOrder(dataBase);
                    Optional<Coupon> coupon = ReadData.readCoupon(dataBase);

                    if (coupon.isPresent()) {
                    	orderBusiness.create(order, coupon.get());
                    } else {
                    	orderBusiness.create(order);
                    }
                    break;
                    
                case "6": // Excluir pedido
                    System.out.println("Digite o código do pedido:");
                    String orderCode = ReadData.readData();
                    productBusiness.delete(orderCode);
                    break;
                    
                case "7": // Lista todos os produtos
                	productBusiness.allList();
                    break;
                    
                case "8": // Lista todos os pedidos
                    orderBusiness.allList();
                    break;
                    
                case "9": // Desloga cliente
                    System.out.println(String.format("Volte sempre %s!", loggedClient.getName()));
                    loggedClient = null;
                    break;
                    
                case "10": // Sai da aplicação
                    System.out.println("Aplicação encerrada.");
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
	}
	
	private static void identifyUser(String cpf) {
        Optional<Client> result = clientBusiness.consult(cpf);

        if (result.isPresent()) {
            Client client = result.get();
            System.out.println(String.format("Olá %s! Você está logado.", client.getName()));
            loggedClient = client;
        } else {
            System.out.println("Usuário não cadastrado.");
            System.exit(0);
        }
    }
}
