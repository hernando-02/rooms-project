package com.reto.rooms.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idScore;
    private String messageText;
    private int score;
    @OneToMany
    @JsonIgnoreProperties("reservation")
    private List<Reservation> reservations;

//    @ManyToOne
//    @JoinColumn(name = "score_id")
//    @JsonIgnoreProperties({"scores"})
//    private Room room;

}