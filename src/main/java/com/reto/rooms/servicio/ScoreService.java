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

    //    public ScoreService() {
    //    }

    public List<Score> getScores() {
        return repository.findAll();
    }

    public Score getScore(long id){
         return repository.findById(id).orElse(null);
    }

    public Score saveScore(Score score) {
        return repository.save(score);
    }

    public Score updateScore(Score score){
        Score scoreOld = getScore(score.getIdScore());
        scoreOld.setScore(score.getScore());
        scoreOld.setMessageText(score.getMessageText());
        return repository.save(scoreOld);
    }

    public void deleteScore(long id){
        repository.deleteById(id);
    }
}
