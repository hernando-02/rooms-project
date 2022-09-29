package com.reto.rooms.repositorio;

import com.reto.rooms.entidad.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
