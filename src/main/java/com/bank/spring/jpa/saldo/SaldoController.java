package com.bank.spring.jpa.saldo;

import com.bank.spring.jpa.saldo.model.Saldo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaldoController {

    @Autowired
    private SaldoService saldoService;

    public SaldoController(SaldoService saldoService) {
        this.saldoService = saldoService;
    }

//    //dodac jakos walute do tego
//    @GetMapping("/saldo")
//    public double getSaldo(){
//        return saldoService.getSaldo();
//    }

    @GetMapping("/saldo/{client_id}")
    public List<Saldo> getClientSaldos(@PathVariable long client_id){
        return saldoService.findClientAllSaldos(client_id);
    }


}
