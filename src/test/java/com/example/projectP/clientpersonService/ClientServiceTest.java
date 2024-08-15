package com.example.projectP.clientpersonService;


import com.example.projectP.clientpersonService.entity.Client;
import com.example.projectP.clientpersonService.repository.ClientRepository;
import com.example.projectP.clientpersonService.service.ClientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ClientServiceTest {

    @Autowired
    private ClientService clientService;

    @MockBean
    private ClientRepository clientRepository;

    @Test
    public void testCreateClient() {
        Client client = new Client();
        client.setPassword("password");
        client.setActive(true);

        Mockito.when(clientRepository.save(client)).thenReturn(client);

        assertEquals(client, clientService.createClient(client));
    }
}

