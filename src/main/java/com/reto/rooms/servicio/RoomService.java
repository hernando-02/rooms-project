package com.reto.rooms.servicio;

import com.reto.rooms.entidad.Room;
import com.reto.rooms.repositorio.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository repository;

    //get
    public List<Room> getRooms(){
        return repository.findAll();
    }

    public Room saveRoom(Room room){
        return repository.save(room);
    }

}
