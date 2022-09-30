package com.example.Client.client;

import com.example.Client.address.Address;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ClientRepository {
    Address address1 = new Address(1, "Street1", "S1", "11111-11", "N1", "C1");
    Address address2 = new Address(2, "Street2", "S2", "222222-22", "N2", "C2");
    Address address3 = new Address(3, "Street3", "S3", "33333-33", "N3", "C3");
    Address address4 = new Address(4, "Street4", "S4", "44444-44", "N4", "C4");
    Address address5 = new Address(5, "Street5", "S5", "55555-55", "N5", "C5");

    Client client1 = new Client(1, "Client1", address1, 18);
    Client client2 = new Client(2, "Client2", address2, 21);
    Client client3 = new Client(3, "Client3", address3, 3);
    Client client4 = new Client(4, "Client4", address4, 14);
    Client client5 = new Client(5, "Client5", address5, 50);

    List<Client> clients = new ArrayList<>(Arrays.asList(client1, client2, client3, client4, client5));

    public List<Client> findAll() {
        return clients;
    }

    public List<Client> findAbove18() {
       return clients.stream()
               .filter(c ->  c.getAge() >= 18)
               .collect(Collectors.toList());
    }

    public List<Client> findUnder18() {
        return clients.stream()
                .filter(c ->  c.getAge() < 18)
                .collect(Collectors.toList());
    }

    public Optional<Client> findById(int id) {
        return clients.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    public void deleteById(int id) {
         this.clients = clients.stream()
                .filter(c -> c.getId() != id)
                 .collect(Collectors.toList());

    }

    public Client edit(Client client) {
          this.clients = clients.stream()
                  .map( c -> c.getId() == client.getId() ? client : c)
                  .collect(Collectors.toList());

          return client;
    }

    public void save(Client client) {
       this.clients.add(client);
    }

}
