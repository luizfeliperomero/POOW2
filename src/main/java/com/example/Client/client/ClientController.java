package com.example.Client.client;

import com.example.Client.exception.ClientNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService){
       this.clientService = clientService;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/findAbove18")
    public ResponseEntity<List<Client>> findAbove18() {
        return ResponseEntity.ok(clientService.findAbove18());
    }

    @GetMapping("/findUnder18")
    public ResponseEntity<List<Client>> findUnder18() {
        return ResponseEntity.ok(clientService.findUnder18());
    }

    @GetMapping("/findById/{id}")
    public Client findById(@PathVariable int id) {
        return clientService.findById(id).orElseThrow(() -> new ClientNotFound("No client found with id " +id));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity deleteById(@PathVariable int id) {
         clientService.deleteById(id);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Client successfully deleted");
    }

    @PutMapping("/update")
    public Client update(@RequestBody Client client) {
        return clientService.update(client).orElseThrow(() -> new ClientNotFound("No client found with id " + client.getId()));
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Client client) {

        if(clientService.findById(client.getId()).isPresent()){
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("User with id " +client.getId()+ " already exists");
        }
        clientService.save(client);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(client);
    }

}
