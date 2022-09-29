package com.reto.rooms.repositorio;

import com.reto.rooms.entidad.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
