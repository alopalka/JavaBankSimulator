package com.bank.spring.jpa.saldo;

import com.bank.spring.jpa.client.model.Client;
import com.bank.spring.jpa.saldo.model.Saldo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaldoService {

    @Autowired
    private SaldoRepository saldoRepository;

    public SaldoService(SaldoRepository saldoRepository) {
        this.saldoRepository = saldoRepository;
    }

    public void generateSaldo(Client client) {
        Saldo saldo = new Saldo(client,"PLN", 0);
    }

    public double getSaldo() {
       return saldoRepository.findBalance();
    }

    public String getCurrency() {
        return saldoRepository.getCurrency();
    }
}
