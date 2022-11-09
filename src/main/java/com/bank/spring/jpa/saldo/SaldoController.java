package com.bank.spring.jpa.saldo;

import com.bank.spring.jpa.saldo.model.Saldo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SaldoController {


    private final SaldoService saldoService;

    public SaldoController(SaldoService saldoService) {
        this.saldoService = saldoService;
    }

    @GetMapping("/saldo/{client_id}")
    public List<Saldo> getClientSaldos(@PathVariable long client_id) {
        return saldoService.findClientAllSaldos(client_id);
    }

    @GetMapping("/saldo/{client_id}/{currency}")
    public double getClientCurrencyAmount(
            @PathVariable long client_id,
            @PathVariable String currency
    ) {
        return saldoService.getSaldo(client_id, currency);
    }
}
