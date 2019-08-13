package com.david.hotelreservation.controller;

import com.david.hotelreservation.model.Client;
import com.david.hotelreservation.model.vo.ClientVO;
import com.david.hotelreservation.service.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
@Api(tags = "client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    @ApiOperation(value = "Create Client", notes = "Service to create a new client")
    @ApiResponses(value = {
            @ApiResponse(code = 201,message = "Client Successfully Created"),
            @ApiResponse(code = 400,message = "Invalid Request")})
    public ResponseEntity<Client> createClient(@RequestBody ClientVO clientVO) {

        Client client = new Client();

        convertClientVOtoClient(clientVO, client);

        return new ResponseEntity<>(this.clientService.create(client), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Client", notes = "Service to update a client")
    @ApiResponses(value = {
            @ApiResponse(code = 201,message = "Client Successfully Updated"),
            @ApiResponse(code = 404,message = "Client not found")})
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
    @ApiOperation(value = "Delete Client", notes = "Service to delete a client")
    @ApiResponses(value = {
            @ApiResponse(code = 201,message = "Client Successfully Deleted"),
            @ApiResponse(code = 404,message = "Client not found")})
    public void removeClient(@PathVariable String id) {
        Client clientById = this.clientService.findClientById(id);

        if (clientById != null) {
            this.clientService.delete(clientById);
        }
    }

    @GetMapping
    @ApiOperation(value = "List Clients", notes = "Service to list all the clients")
    @ApiResponses(value = {
            @ApiResponse(code = 201,message = "Clients Found"),
            @ApiResponse(code = 404,message = "Clients not found")})
    public List<Client> findAll() {
        System.out.println("test");
        return this.clientService.findAll();
    }


}
