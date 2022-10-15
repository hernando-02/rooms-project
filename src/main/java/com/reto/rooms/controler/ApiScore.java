//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.reto.rooms.controler;

import com.reto.rooms.entidad.Category;
import com.reto.rooms.entidad.Score;
import com.reto.rooms.servicio.ScoreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    public Score getScore(long id){
        return service.getScore(id);
    }

    @PostMapping({"/save"})
    public ResponseEntity saveScore(@RequestBody Score score) {
        this.service.saveScore(score);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity updateScore(@RequestBody Score score){
        service.updateScore(score);
        return ResponseEntity.status(201).build();
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity deleteScore(@PathVariable long id){
        service.deleteScore(id);
        return ResponseEntity.status(204).build();
    }

}
