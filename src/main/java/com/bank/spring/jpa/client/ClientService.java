package com.bank.spring.jpa.client;

import com.bank.spring.jpa.client.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("cs")
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientRepository getClientRepository() {
        return clientRepository;
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client findByUsername(String username) {
        return clientRepository.findByUsername(username).orElseThrow(() -> new ClientNotFoundException(username));
    }
}
