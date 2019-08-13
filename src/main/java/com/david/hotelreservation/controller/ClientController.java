package com.david.hotelreservation.controller;

import com.david.hotelreservation.model.Client;
import com.david.hotelreservation.model.vo.ClientVO;
import com.david.hotelreservation.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody ClientVO clientVO) {

        Client client = new Client();

        convertClientVOtoClient(clientVO, client);

        return new ResponseEntity<>(this.clientService.create(client), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable String id, @RequestBody ClientVO clientVO) {
        Client clientById = this.clientService.findClientById(id);
        Client updatedClient = new Client();

        if (clientById == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            convertClientVOtoClient(clientVO, updatedClient);
        }

        return new ResponseEntity<>(this.clientService.update(updatedClient), HttpStatus.OK);
    }

    protected void convertClientVOtoClient(ClientVO clientVO, Client client) {
        client.setName(clientVO.getName());
        client.setLastName(clientVO.getLastName());
        client.setDirection(clientVO.getDirection());
        client.setTelephoneNumber(clientVO.getTelephoneNumber());
        client.setEmail(clientVO.getEmail());
    }

    @DeleteMapping
    public void removeClient(@PathVariable String id) {
        Client clientById = this.clientService.findClientById(id);

        if (clientById != null) {
            this.clientService.delete(clientById);
        }
    }

    @GetMapping
    public List<Client> findAll(){
        return this.clientService.findAll();
    }


}
