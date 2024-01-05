package edu.example.entity;

import edu.example.entity.constant.Kindbook;

public class Book extends Product {
	private String name;
	private Kindbook kindBook;
	
	public Book() {
		
	}

	public Book(String name, Kindbook bookType) {
		this.name = name;
		this.kindBook = bookType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Kindbook getBookType() {
		return kindBook;
	}

	public void setBookType(Kindbook bookType) {
		this.kindBook = bookType;
	}

	@Override
    public double calculateFreight() {
        return (getPrice() * getQuantity() * (1 + kindBook.getFactor()));
    }
	
    @Override
    public String toString() {
        return "Livro {" +
                "nome ='" + name + '\'' +
                ", genero = " + kindBook + '\'' +
                ", codigo = '" + getCode() + '\'' +
                ", preço = '" + getPrice() + '\'' +
                '}';
    }
}
