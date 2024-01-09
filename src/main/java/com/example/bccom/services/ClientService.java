package com.example.bccom.services;

import com.example.bccom.models.Client;
import com.example.bccom.repo.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> listClients(String name) {
        if (name != null) clientRepository.findByName(name);
        return clientRepository.findAll();
    }

    public void saveClient (Client client){
        log.info("Saving new {}", client);
        clientRepository.save(client);
    }

    public void deleteClient (Long id){
        clientRepository.deleteById(id);
    }

    public Client getClientById (Long id){
        return clientRepository.findById(id).orElse(null);
    }

}
