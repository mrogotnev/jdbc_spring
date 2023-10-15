package com.mrogotnev.jdbc_jpa_spring.services;

import com.mrogotnev.jdbc_jpa_spring.dao.ClientDao;
import com.mrogotnev.jdbc_jpa_spring.entity.Client;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ClientService {
    private ClientDao clientDao;
    public List<Client> getAllClients() {
        return clientDao.getAllClients();
    }

    public Client readClient(int id) {
        return clientDao.readClient(id);
    }

    public int createClient(Client client) {
        return clientDao.createClient(client);
    }

    public void updateClient(int id, Client client) {
        clientDao.updateClient(id, client);
    }

    public void deleteClient(int id) {
        clientDao.deleteClient(id);
    }
}
