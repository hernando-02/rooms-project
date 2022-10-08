//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.reto.rooms.controler;

import com.reto.rooms.entidad.Score;
import com.reto.rooms.servicio.ScoreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(
        origins = {"*"}
)
@RequestMapping({"api/Score"})
public class ApiScore {
    @Autowired
    private ScoreService service;

    public ApiScore() {
    }

    @GetMapping({"/all"})
    public List<Score> findAllScore() {
        return this.service.getScores();
    }

    @PostMapping({"/save"})
    public ResponseEntity saveScore(@RequestBody Score score) {
        this.service.saveScore(score);
        return ResponseEntity.status(201).build();
    }
}
