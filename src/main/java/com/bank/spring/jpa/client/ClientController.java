package com.bank.spring.jpa.client;

import com.bank.spring.jpa.client.model.Client;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Client> all() {
        return clientService.getAllClients();
    }

    @GetMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public Client findClient(@PathVariable String username) {
        return clientService.findByUsername(username);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Client newClient(@RequestBody Client newClient) {
        return clientService.save(newClient);
    }

}
