package com.bank.spring.jpa.client;

import com.bank.spring.jpa.client.model.Client;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientRepository repository;
    private final ClientService clientService;

    public ClientController(ClientRepository repository, ClientService clientService) {
        this.repository = repository;
        this.clientService = clientService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Client> all() {
        return repository.findAll();
    }

    //get single client

    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public User findClient(@PathVariable String username) {
        return repository.findByUsername(username).orElseThrow(() -> new ClientNotFoundException(username));
    }

    //post new client

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Client newClient(@RequestBody Client newClient) {
        return clientService.save(newClient);
    }

}
