package com.bank.spring.jpa.client;

import com.bank.spring.jpa.client.model.Client;
import com.bank.spring.jpa.saldo.SaldoService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;
    //TUTAJ
    @Autowired
    private SaldoService saldoService;

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
    public void newClient(@RequestBody Client newClient) {
        clientService.addNewClient(newClient);
        saldoService.generateAllSaldos(newClient);
    }

    @PutMapping("/update/{username}")
    public void updateClient(
            @PathVariable("username") String username,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String password) {
        clientService.updateClient(username, firstName, lastName);
    }

}
