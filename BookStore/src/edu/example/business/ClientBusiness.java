package edu.example.business;

import java.util.Optional;

import edu.example.database.DataBase;
import edu.example.entity.Client;

public class ClientBusiness {
	private DataBase dataBase;

	public ClientBusiness(DataBase dataBase) {
		this.dataBase = dataBase;
	}
	
	// Método para consultar cliente
    public Optional<Client> consult(String cpf) {
        Client client = dataBase.getClient();
        if (client != null && client.getCpf() != null && client.getCpf().equalsIgnoreCase(cpf)) {
            return Optional.of(client);
        } else {
            return Optional.empty();
        }	
    }
}
