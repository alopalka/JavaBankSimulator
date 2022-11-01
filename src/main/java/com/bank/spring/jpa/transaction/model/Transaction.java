package com.bank.spring.jpa.transaction.model;

import com.bank.spring.jpa.client.model.Client;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "transaction_date")
    private java.sql.Timestamp transaction_date;

    @ManyToOne
    @JoinColumn(name = "client_from_id")
    private Client clientFrom;
    @ManyToOne
    @JoinColumn(name = "client_to_id")
    private Client clientTo;
    private String currency;
    private double amount;

    protected Transaction(){}

    public Transaction(Timestamp transaction_date, Client clientFrom, Client clientTo, String currency, double amount) {
        this.transaction_date = transaction_date;
        this.clientFrom = clientFrom;
        this.clientTo = clientTo;
        this.currency = currency;
        this.amount = amount;
    }

    public Client getClientTo() {
        return clientTo;
    }

    public void setClientTo(Client clientTo) {
        this.clientTo = clientTo;
    }

    public Client getClientFrom() {
        return clientFrom;
    }

    public void setClientFrom(Client clientFrom) {
        this.clientFrom = clientFrom;
    }

    public Timestamp getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(Timestamp transaction_date) {
        this.transaction_date = transaction_date;
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

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", transaction_date=" + transaction_date +
                ", clientFrom=" + clientFrom +
                ", clientTo=" + clientTo +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                '}';
    }
}
