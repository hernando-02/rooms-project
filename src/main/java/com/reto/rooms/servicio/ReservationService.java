package com.reto.rooms.servicio;

import com.reto.rooms.entidad.Client;
import com.reto.rooms.entidad.Reservation;
import com.reto.rooms.entidad.Room;
import com.reto.rooms.entidad.custom.CountClient;
import com.reto.rooms.entidad.custom.CountRoom;
import com.reto.rooms.entidad.custom.StatusAmount;
import com.reto.rooms.repositorio.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
//        reservation.setStatus("created");
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

    public  List<CountRoom> getTopRoom(){
        List<CountRoom>res=new ArrayList<>();
        List<Object[]>report=repository.countTotalReservationsByRoom();
        for(int i=0;i<report.size();i++){
            res.add(new CountRoom((Long)report.get(i)[1],(Room)report.get(i)[0]));
        }
        return res;
    }


    public  List<CountClient> getTopClients(){
        List<CountClient>res=new ArrayList<>();
        List<Object[]>report=repository.countTotalReservationsByClient();
        for(int i=0;i<report.size();i++){
            res.add(new CountClient((Long)report.get(i)[1],(Client) report.get(i)[0]));
        }
        return res;
    }

    public List<Reservation> getReservationPeriod(Date a, Date b){
        return repository.findAllByStartDateAfterAndStartDateBefore(a,b);
    }

    public List<Reservation> getReservationsByStatus(String status){
        return repository.findAllByStatus(status);
    }


    // reto 5  //



    public List<Reservation> getReservationsPeriod(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date a= new Date();
        Date b=new Date();
        try {
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if(a.before(b)){
            return getReservationPeriod(a,b);
        }else{
            return new ArrayList<>();
        }

    }
    public StatusAmount getReservationsStatusReport(){
        List<Reservation>completed=getReservationsByStatus("completed");
        List<Reservation>cancelled=getReservationsByStatus("cancelled");
        return new StatusAmount(completed.size(),cancelled.size());

    }
}
