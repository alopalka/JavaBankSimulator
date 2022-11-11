package com.bank.spring.jpa.security;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.bank.spring.jpa.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    CLIENT(Sets.newHashSet(SALDO_READ,CLIENT_READ)),
    ADMIN(Sets.newHashSet(SALDO_READ,SALDO_WRITE,CLIENT_READ,CLIENT_WRITE)),
    ;

    private final Set<ApplicationUserPermission> PERMISSIONS;

    ApplicationUserRole(Set<ApplicationUserPermission> PERMISSIONS) {
        this.PERMISSIONS = PERMISSIONS;
    }
}
