package com.reto.rooms.controler;

import com.reto.rooms.entidad.Reservation;
import com.reto.rooms.servicio.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/Reservation")
public class ApiReservation {

    @Autowired
    private ReservationService service;

    @GetMapping("/all")
    public List<Reservation> findAllReservation(){
        return service.getReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservation(long id){
        return service.getReservation(id);
    }

    @PostMapping("/save")
    public ResponseEntity saveReservation(@RequestBody Reservation reservation){
        service.saveReservation(reservation);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity updateReservation(@RequestBody Reservation reservation){
        service.updateReservation(reservation);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteReservation(@PathVariable long id){
        service.deleteReservation(id);
        return ResponseEntity.status(204).build();
    }


}
