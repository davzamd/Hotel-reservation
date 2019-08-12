package com.david.hotelreservation.service;

import com.david.hotelreservation.model.Client;

import java.util.List;

public interface ClientService {
    Client create(Client client);
    Client update(Client client);
    void delete(Client client);
    List<Client> findByLastName(String lastName);
}
