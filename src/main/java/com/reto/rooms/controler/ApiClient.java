package com.reto.rooms.controler;


import com.reto.rooms.entidad.Client;
import com.reto.rooms.servicio.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/Client/")
public class ApiClient {
    @Autowired
    private ClientService service;

    @GetMapping("/all")
    public List<Client> findAllClients(){
        return service.getClientes();
    }

    @GetMapping("/{id}")
    public Client getClient(long id){
        return service.getClient(id);
    }

    @PostMapping("/save")
    public ResponseEntity saveClient(@RequestBody Client client){
        service.saveClient(client);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity updateClient(@RequestBody Client client){
        service.updateClient(client);
        return ResponseEntity.status(201).build();
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity deleteClient(@PathVariable long id){
        service.deleteClient(id);
        return ResponseEntity.status(204).build();
    }

}
