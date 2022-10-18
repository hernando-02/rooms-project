package com.reto.rooms.repositorio;

import com.reto.rooms.entidad.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT c.room, COUNT(c.room) from Reservation AS c group by c.room order by COUNT(c.room) DESC")
    public List<Object[]> countTotalReservationsByRoom();


    //select clientId, count(*) as "total" from reservation group by clientId order by total desc;
    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c group by c.client order by COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationsByClient();

    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo );

    public List<Reservation>findAllByStatus(String status);
}
