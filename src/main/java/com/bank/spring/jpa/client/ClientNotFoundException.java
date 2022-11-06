package com.bank.spring.jpa.client;

public class ClientNotFoundException extends RuntimeException {

    ClientNotFoundException(String username) {
        super("Couldn't find client " + username);
    }
}
