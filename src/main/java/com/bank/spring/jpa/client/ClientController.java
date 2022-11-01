package com.bank.spring.jpa.client;

import com.bank.spring.jpa.client.model.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

//    @GetMapping("/allusers/)
//    public String getAllClients(Model model){
//        model.addAttribute("client",Client);
//
//    }
}
