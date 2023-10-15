package com.mrogotnev.jdbc_jpa_spring.controller;

import com.mrogotnev.jdbc_jpa_spring.entity.Client;
import com.mrogotnev.jdbc_jpa_spring.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;
    @GetMapping("/getAllClients")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/readClients/{id}")
    public Client readClient(@PathVariable int id) {
        return clientService.readClient(id);
    }

    @PostMapping(value = "/createClient", consumes = {"application/json"})
    public int createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @PutMapping("/updateClient/{id}")
    public void updateClient(@PathVariable int id, @RequestBody Client client) {
        clientService.updateClient(id, client);
    }

    @DeleteMapping ("/deleteClient/{id}")
    public void deleteClient(@PathVariable int id) {
        clientService.deleteClient(id);
    }
}
