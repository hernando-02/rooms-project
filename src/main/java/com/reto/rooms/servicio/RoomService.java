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

    // get id
    public Room getRoom(long id){
        return repository.findById(id).orElse(null);
    }

    public Room saveRoom(Room room){
        return repository.save(room);
    }

    //put
    public Room updateRoom(Room room){
        Room roomOld = getRoom(room.getId());
        roomOld.setName(room.getName());
        roomOld.setStars(room.getStars());
        roomOld.setHotel(room.getHotel());
        roomOld.setDescription(room.getDescription());
        return  repository.save(roomOld);
    }

    //delete
    public void deleteRoom(long id){
        repository.deleteById(id);

    }

}
