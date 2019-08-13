package com.david.hotelreservation.service;

import com.david.hotelreservation.model.Client;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClientService {
    Client create(Client client);

    Client update(Client client);

    void delete(Client client);

    List<Client> findByLastName(String lastName);

    Client findClientById(String id);

    List<Client> findAll();
}
