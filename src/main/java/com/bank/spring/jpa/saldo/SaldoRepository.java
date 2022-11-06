package com.bank.spring.jpa.saldo;


import com.bank.spring.jpa.saldo.model.Saldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SaldoRepository extends JpaRepository<Saldo, Double>{

    @Query("select amount from Saldo")
    double findBalance();

    @Query("select currency from Saldo")
    String getCurrency();
}
