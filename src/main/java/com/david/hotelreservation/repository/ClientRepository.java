package com.david.hotelreservation.repository;

import com.david.hotelreservation.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,String> {

    List<Client> findClientsByLastName(String lastName);
}
