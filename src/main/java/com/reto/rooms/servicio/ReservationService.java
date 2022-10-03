package com.reto.rooms.servicio;

import com.reto.rooms.entidad.Reservation;
import com.reto.rooms.repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    // peticion get
    public List<Reservation> getReservations(){
        return repository.findAll();
    }

    // peticion post
    public Reservation saveReservation(Reservation reservation){
        reservation.setStatus("created");
        return repository.save(reservation);
    }
}
