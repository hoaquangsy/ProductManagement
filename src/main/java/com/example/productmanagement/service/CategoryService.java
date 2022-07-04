package com.example.productmanagement.service;

import com.example.productmanagement.model.entities.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    //insert
    CategoryEntity addCategoryEntity(CategoryEntity category);

    //update
    CategoryEntity updateCategoryEntity(CategoryEntity categoryEntity);

    //delete
    CategoryEntity deleteCategoryEntity(CategoryEntity categoryEntity);

    //getAll
    Page<CategoryEntity> getPage(Pageable pageable);

    CategoryEntity findById(int id);



}
