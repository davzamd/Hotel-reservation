package com.david.hotelreservation.service;

import com.david.hotelreservation.model.Client;
import com.david.hotelreservation.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ClientServiceImp implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    @Override
    public Client update(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    @Override
    public void delete(Client client) {
        clientRepository.delete(client);
    }

    @Override
    public List<Client> findByLastName(String lastName) {
        return clientRepository.findClientsByLastName(lastName);
    }

    @Override
    public Client findClientById(String id) {
        return clientRepository.findClientsById(id);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
