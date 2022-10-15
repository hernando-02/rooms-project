package com.reto.rooms.controler;

import com.reto.rooms.entidad.Client;
import com.reto.rooms.entidad.Message;
import com.reto.rooms.servicio.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/Message")
public class ApiMessages {

    @Autowired
    private MessageService service;

    @GetMapping("/all")
    public List<Message> findAllMessages(){
        return service.getMessages();
    }

    @GetMapping("/{id}")
    public Message getMessage(long id){
        return service.getMessage(id);
    }

    @PostMapping("/save")
    public ResponseEntity saveMessage(@RequestBody Message message){
        service.saveMessage(message);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity updateMessage(@RequestBody Message message ){
        service.updateMessage(message);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMessage(@PathVariable long id){
        service.deleteMessage(id);
        return ResponseEntity.status(204).build();
    }
}
