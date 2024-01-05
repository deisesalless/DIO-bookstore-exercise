package edu.example.business;

import java.util.Optional;

import edu.example.database.DataBase;
import edu.example.entity.Product;

public class ProductBusiness {
	private DataBase dataBase;

	public ProductBusiness(DataBase dataBase) {
		this.dataBase = dataBase;
	}
	
	// Método para salvar um novo produto(livro)
    public void create(Product newProduct) {
        String code = "PR00d";
        code = String.format(code, dataBase.getProduct().length);
        newProduct.setCode(code);

        boolean repeatedProduct = false;
        for (Product product: dataBase.getProduct()) {
            if (product.getCode().equalsIgnoreCase(newProduct.getCode())) {
            	repeatedProduct= true;
                System.out.println("Produto já cadastrado.");
                break;
            }
        }

        if (!repeatedProduct) {
            this.dataBase.addProduct(newProduct);
            System.out.println("Produto cadastrado com sucesso.");
        }
    }
    
    // Método de excluir livro
    public void delete(String code) {
        int deleteProduct = -1;
         for(int count = 0; count < dataBase.getProduct().length; count++) {    	 
        	 Product product = dataBase.getProduct()[count];
        	 if(product.getCode().equalsIgnoreCase(code)) {
        		 deleteProduct = count;
        		 break;
        	 }
         }
         
         if (deleteProduct != -1) {
        	 dataBase.removeProduct(deleteProduct);
        	 System.out.println("Produto excluído com sucesso.");
         } else {
        	 System.out.println("Produto não existe no banco de dados.");
         }
    }
    
    // Método de consultar livro
    public Optional<Product> consult(String code) {
        for (Product product: dataBase.getProduct()) {

            if (product.getCode().equalsIgnoreCase(code)) {
                return  Optional.of(product);
            }
        }
        return Optional.empty();
    }
    
    // Método para listar todos os livros
    public void allList() {
        if (dataBase.getProduct().length == 0) {
            System.out.println("Não existem produtos cadastrados.");
        } else {

            for (Product product: dataBase.getProduct()) {
                System.out.println(product.toString());
            }
        }
    }
	
}
