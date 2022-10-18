package com.reto.rooms.entidad.custom;

import com.reto.rooms.entidad.Room;


public class CountRoom {
    private Long total;
    private Room room;

    public CountRoom(Long total, Room room) {
        this.total = total;
        this.room = room;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Room getCar() {
        return room;
    }

    public void setCar(Room room) {
        this.room = room;
    }
}
