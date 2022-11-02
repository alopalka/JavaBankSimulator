package com.bank.spring.jpa.client;

public class ClientNotFoundException  extends RuntimeException{

    ClientNotFoundException (Long id) {
        super("Couldn't find client " + id);
    }
}
