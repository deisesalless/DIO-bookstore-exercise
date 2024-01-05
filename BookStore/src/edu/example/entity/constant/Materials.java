package edu.example.entity.constant;

public enum Materials {
	
	MATERIA2(2),
	MATERIA5(5),
	MATERIA7(7);
	private double factor;

	Materials(double factor) {
        this.factor = factor / 10;
    }

    public double getFactor() {
        return factor;
    }
}
