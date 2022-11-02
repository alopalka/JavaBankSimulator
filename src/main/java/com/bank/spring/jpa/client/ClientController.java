package com.bank.spring.jpa.client;

import com.bank.spring.jpa.client.model.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    private final ClientRepository repository;

    ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/client")
    List<Client> all(){
        return repository.findAll();
    }

    //get single client

    @GetMapping("/client/{id}")
    Client single(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }

    //post new client

    @PostMapping("/client")
    Client newClient(@RequestBody Client newClient) {
        return repository.save(newClient);
    }


}
