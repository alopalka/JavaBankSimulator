package com.bank.spring.jpa.saldo;

import com.bank.spring.jpa.saldo.model.Saldo;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("saldo/withdraw/{client_id}/{currency}")
    public void withdrawCash(
            @PathVariable long client_id,
            @RequestParam double amount,
            @PathVariable String currency) {
        saldoService.withdrawal(client_id, amount, currency);
    }

    @PostMapping("saldo/deposit/{client_id}/{currency}")
    public void depositCash(
            @PathVariable long client_id,
            @RequestParam double amount,
            @PathVariable String currency) {
        saldoService.deposit(client_id, amount, currency);
    }
}
