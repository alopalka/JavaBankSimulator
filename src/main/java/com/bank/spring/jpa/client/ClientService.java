package com.bank.spring.jpa.client;

import com.bank.spring.jpa.client.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service()
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void addNewClient(Client client) {
        Optional<Client> optionalClient = clientRepository.findClientByEmail(client.getEmail());
        if (optionalClient.isPresent()) {
            throw new IllegalStateException("Email is already taken!");
        }
        clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client findByUsername(String username) {
        return clientRepository.findClientByUsername(username).orElseThrow(() -> new ClientNotFoundException(username));
    }

    @Transactional
    public void updateClient(String username, String firstName, String lastName) {
        Client client = clientRepository.findClientByUsername(username).orElseThrow(() -> new IllegalStateException("Provided username was not found !"));

        if (firstName != null && firstName.length() > 0) {
            client.setFirstName(firstName);
        }

        if (lastName != null && lastName.length() > 0) {
            client.setLastName(lastName);
        }

    }
}
