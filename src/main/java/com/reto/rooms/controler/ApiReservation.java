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

    @PostMapping("/save")
    public ResponseEntity saveReservation(@RequestBody Reservation reservation){
        service.saveReservation(reservation);
        return ResponseEntity.status(201).build();
    }



}
