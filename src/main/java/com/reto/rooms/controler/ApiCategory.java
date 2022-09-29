package com.reto.rooms.controler;


import com.reto.rooms.entidad.Category;
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

    @PostMapping("/save")
    public ResponseEntity saveCategory(@RequestBody Category category){
        service.saveCategory(category);
        return ResponseEntity.status(201).build();
    }

}
