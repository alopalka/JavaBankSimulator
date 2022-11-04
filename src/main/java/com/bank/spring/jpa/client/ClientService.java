package com.bank.spring.jpa.client;

import com.bank.spring.jpa.client.model.Client;
import org.springframework.stereotype.Service;

@Service("cs")
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ClientRepository getClientRepository() {
        return clientRepository;
    }

    public Client save(Client client){
        return clientRepository.save(client);
    }

}
