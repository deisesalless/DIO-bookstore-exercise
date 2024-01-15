package edu.example.entity;

public class Client {
	private String name;
	private String cpf;

	public Client() {
		this.name = "Deise Sales";
		this.cpf = "123456789";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
    @Override
    public String toString() {
        return "Cliente { nome='" + name + "'}";
    }
}
