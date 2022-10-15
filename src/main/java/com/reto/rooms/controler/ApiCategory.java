package com.reto.rooms.controler;


import com.reto.rooms.entidad.Category;
import com.reto.rooms.entidad.Client;
import com.reto.rooms.servicio.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/Category")
public class ApiCategory {

    @Autowired
    private CategoryService service;

    @GetMapping("/all")
    public List<Category> findAllCategory(){
        return service.getCategories();
    }

    @GetMapping("/{id}")
    public Category getCategory(long id){
        return service.getCategory(id);
    }

    @PostMapping("/save")
    public ResponseEntity saveCategory(@RequestBody Category category){
        service.saveCategory(category);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("/update")
    public ResponseEntity updateCategory(@RequestBody Category category){
        service.updateCategory(category);
        return ResponseEntity.status(201).build();
    }

    // delete
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable long id){
        service.deleteCategory(id);
        return ResponseEntity.status(204).build();
    }

}
