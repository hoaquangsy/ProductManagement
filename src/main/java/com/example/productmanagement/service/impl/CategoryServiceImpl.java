package com.example.productmanagement.service.impl;

import com.example.productmanagement.exceptions.NotFound;
import com.example.productmanagement.mapper.CategoryMapper;
import com.example.productmanagement.model.entities.CategoryEntity;
import com.example.productmanagement.model.entities.ProductEntity;
import com.example.productmanagement.repsitories.CategoryRepository;
import com.example.productmanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    //insert
    @Override

    public CategoryEntity addCategoryEntity(CategoryEntity category){
        category.setId(null);
        category.setStatus(1);
        return categoryRepository.save(category);
    }
    //update
    @Override
    public CategoryEntity updateCategoryEntity(CategoryEntity categoryEntity){
       Integer id=categoryEntity.getId();
       if (id!=null){
           Optional<CategoryEntity> category=categoryRepository.findById(id);
           return categoryRepository.save(category.get());
       }
       return null;
    }
    //delete
    @Override
    public CategoryEntity deleteCategoryEntity(CategoryEntity categoryEntity){
        Integer id=categoryEntity.getId();
        if (id!=null){
            Optional<CategoryEntity> category=categoryRepository.findById(id);
            category.get().setStatus(0);
            return categoryRepository.save(category.get());
        }
        return null;
    }
    //getAll
    @Override
    public Page<CategoryEntity> getPage(Pageable pageable){
        return categoryRepository.findAll(pageable);
    }
    @Override
    public CategoryEntity findById(int id){
        Optional<CategoryEntity> categoryEntity=categoryRepository.findById(id);
        if (categoryEntity.isPresent()){
            return categoryEntity.get();
        }

        throw new NotFound("id CategoryEntity not found");
    }
}
