package com.bank.spring.jpa.saldo;


import com.bank.spring.jpa.client.model.Client;
import com.bank.spring.jpa.saldo.model.Saldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaldoRepository extends JpaRepository<Saldo, Double> {

    List<Saldo> findSaldoByClientId(long clientId);
//    double findBalance();
//    String getCurrency();
}
