package com.bank.spring.jpa.client;

import com.bank.spring.jpa.client.model.Client;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findClientByUsername(String username);

    Optional<Client> findClientByEmail(String email);
}
