package com.david.hotelreservation.controller;

import com.david.hotelreservation.model.Client;
import com.david.hotelreservation.model.vo.ClientVO;
import com.david.hotelreservation.service.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class ClientControllerShould {

    private ClientController clientController;

    @Before
    public void setUp() {
        ClientService clientService = Mockito.mock(ClientService.class);
        clientController = new ClientController(clientService);
    }

    @Test
    public void convert_clientVO_to_client() {
        Client client = new Client();
        ClientVO clientVO = new ClientVO();
        clientVO.setName("David");

        clientController.convertClientVOtoClient(clientVO,client);

        assertEquals("David",client.getName());
    }
}