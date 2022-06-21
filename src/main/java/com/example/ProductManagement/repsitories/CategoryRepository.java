package com.example.ProductManagement.repsitories;

import com.example.ProductManagement.model.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
}
