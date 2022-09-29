package com.reto.rooms.servicio;

import com.reto.rooms.entidad.Category;
import com.reto.rooms.repositorio.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    // get
    public List<Category> getCategories(){
        return repository.findAll();
    }

    // post
    public Category saveCategory(Category category){
        return repository.save(category);
    }
}
