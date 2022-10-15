package com.reto.rooms.servicio;

import com.reto.rooms.entidad.Category;
import com.reto.rooms.entidad.Client;
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

    // get id
    public Category getCategory(long id){
        return repository.findById(id).orElse(null);
    }

    // post
    public Category saveCategory(Category category){
        return repository.save(category);
    }

    //put
    public Category updateCategory(Category category){
        Category categoryOld= getCategory(category.getId());
        categoryOld.setName(category.getName());
        categoryOld.setDescription(category.getDescription());
        return  repository.save(categoryOld);
    }

    //delete
    public void deleteCategory(long id){
        repository.deleteById(id);
    }

}
