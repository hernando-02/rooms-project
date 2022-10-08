//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.reto.rooms.servicio;

import com.reto.rooms.entidad.Score;
import com.reto.rooms.repositorio.ScoreRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository repository;

    public ScoreService() {
    }

    public List<Score> getScores() {
        return this.repository.findAll();
    }

    public Score saveScore(Score score) {
        return (Score)this.repository.save(score);
    }
}
