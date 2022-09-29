package com.reto.rooms.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "message_id_room")
    @JsonIgnoreProperties("messages")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "message_id_client")
    @JsonIgnoreProperties("messages")
    private Client client;

}
