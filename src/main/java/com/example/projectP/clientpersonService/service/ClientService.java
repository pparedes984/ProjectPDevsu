package com.example.projectP.clientpersonService.service;

import com.example.projectP.clientpersonService.exception.ResourceNotFoundException;
import com.example.projectP.clientpersonService.entity.Client;
import com.example.projectP.clientpersonService.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client updatedClient) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found"));
        client.setPassword(updatedClient.getPassword());
        client.setActive(updatedClient.isActive());
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
