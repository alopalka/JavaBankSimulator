package com.bank.spring.jpa.client.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ClientDto {

    //TODO: add some validation for attributes

    private long id;
    private String firstName;
    private String lastName;
    private String password;
    private String username;
    private String email;

    public static ClientDto fromEntity(Client client) {
        return ClientDto.builder()
                .id(client.getId())
                .firstName(client.getFirstName())
                .lastName(client.getLastName())
                .password(client.getPassword())
                .username(client.getUsername())
                .email(client.getEmail())
                .build();
    }

    public Client toEntity() {
        return Client.builder()
                .firstName(firstName)
                .lastName(lastName)
                .password(password)
                .username(username)
                .email(email)
                .build();
    }
}
