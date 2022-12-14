package com.bank.spring.jpa.saldo.model;

import com.bank.spring.jpa.client.model.Client;
import com.bank.spring.jpa.currency.Currency;

import javax.persistence.*;

@Entity
@Table(name = "saldo")
public class Saldo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(name = "currency")
    private String currency;

    @Column(name = "amount")
    private double amount;

    protected Saldo() {
    }

    public Saldo(Client client, String currency, double amount) {
        this.client = client;
        this.currency = currency;
        this.amount = amount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
