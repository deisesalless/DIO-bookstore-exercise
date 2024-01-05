package edu.example.entity.constant;

public enum Kindbook {
	
	DRAMA(15),
	SUSPENSE(10),
	ROMANCE(5);
	private double factor;

    Kindbook(double factor) {
        this.factor = factor / 100;
    }

    public double getFactor() {
        return factor;
    }

}
