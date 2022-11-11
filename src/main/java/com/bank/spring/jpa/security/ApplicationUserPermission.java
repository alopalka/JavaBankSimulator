package com.bank.spring.jpa.security;

public enum ApplicationUserPermission {
    CLIENT_READ("client:read"),
    CLIENT_WRITE("client:write"),
    SALDO_READ("saldo:read"),
    SALDO_WRITE("saldo:write"),
    ;

    private final String PERMISSION;

    ApplicationUserPermission(String PERMISSION) {
        this.PERMISSION = PERMISSION;
    }

    public String getPERMISSION() {
        return PERMISSION;
    }
}
