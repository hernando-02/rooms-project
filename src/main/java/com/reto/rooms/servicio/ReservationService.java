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

    public Reservation getReservation(long id){
        return repository.findById(id).orElse(null);
    }

    // peticion post
    public Reservation saveReservation(Reservation reservation){
        reservation.setStatus("created");
        return repository.save(reservation);
    }

    public Reservation updateReservation(Reservation reservation){
        Reservation reservationOld = getReservation(reservation.getIdReservation());
        reservationOld.setStartDate(reservation.getStartDate());
        reservationOld.setDevolutionDate(reservation.getDevolutionDate());
        reservationOld.setStatus(reservation.getStatus());
        return repository.save(reservationOld);
    }

    public void deleteReservation(long id){
        repository.deleteById(id);
    }
}
