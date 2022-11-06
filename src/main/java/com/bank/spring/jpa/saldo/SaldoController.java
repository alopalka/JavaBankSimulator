package com.bank.spring.jpa.saldo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaldoController {

    @Autowired
    private SaldoService saldoService;

    public SaldoController(SaldoService saldoService) {
        this.saldoService = saldoService;
    }

    //dodac jakos walute do tego
    @GetMapping("/saldo")
    public double getSaldo(){
        return saldoService.getSaldo();
    }


}
