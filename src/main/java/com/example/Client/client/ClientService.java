package com.example.Client.client;

import com.example.Client.exception.ClientNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll() {
       return clientRepository.findAll();
    }

    public List<Client> findAbove18() {
        return clientRepository.findAbove18();
    }

    public List<Client> findUnder18() {
        return clientRepository.findUnder18();
    }

    public Optional<Client> findById(int id) {
        return  clientRepository.findById(id);
    }

    public void deleteById(int id) {
        if(findById(id).isPresent()){
            clientRepository.deleteById(id);
        } else {
            throw new ClientNotFound("client with id " +id+" not found");
        }
    }

    public void save(Client client) {
        clientRepository.save(client);
    }

    public Optional<Client> update(Client client) {
        return Optional.ofNullable(clientRepository.edit(client));
    }
}
