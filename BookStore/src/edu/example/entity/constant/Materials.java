package edu.example.entity.constant;

public enum Materials {
	
	M2(2),
	M5(5),
	M7(7);
	private double factor;

	Materials(double factor) {
        this.factor = factor / 10;
    }

    public double getFactor() {
        return factor;
    }
}
