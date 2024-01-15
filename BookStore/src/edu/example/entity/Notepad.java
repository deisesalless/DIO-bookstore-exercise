package edu.example.entity;

import edu.example.entity.constant.Materials;

public class Notepad extends Product {
	private Materials kind;
		
	public Materials getKind() {
		return kind;
	}

	public void setKind(Materials kind) {
		this.kind = kind;
	}

	@Override
    public double calculateFreight() {
        return (getPrice() * getQuantity() * (1 + kind.getFactor()));
    }
	
    @Override
    public String toString() {
        return "Caderno {" +
                " tipo = " + kind + '\'' +
                ", codigo = '" + getCode() + '\'' +
                ", preço = '" + getPrice() + '\'' +
                '}';
    }

}
