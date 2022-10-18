package com.reto.rooms.controler;

import com.reto.rooms.entidad.Reservation;
import com.reto.rooms.entidad.custom.CountClient;
import com.reto.rooms.entidad.custom.CountRoom;
import com.reto.rooms.entidad.custom.StatusAmount;
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


    // ------

    @GetMapping("/report-room")
    public List<CountRoom> getReservationsReportRoom(){
        return service.getTopRoom();
    }

    @GetMapping("/report-clients")
    public List<CountClient> getReservationsReportClient(){
        return service.getTopClients();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservationsReportDates(@PathVariable("dateOne") String dateOne,@PathVariable("dateTwo") String dateTwo){
        return service.getReservationsPeriod(dateOne,dateTwo);
    }
    @GetMapping("/report-dates/amount/{dateOne}/{dateTwo}")
    public Integer getReservationsReportDatesAmount(@PathVariable("dateOne") String dateOne,@PathVariable("dateTwo") String dateTwo){
        return service.getReservationsPeriod(dateOne,dateTwo).size();
    }

    @GetMapping("/report-status")
    public StatusAmount getReservationsStatusReport(){
        return service.getReservationsStatusReport();
    }

}
