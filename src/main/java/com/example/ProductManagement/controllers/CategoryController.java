package com.example.ProductManagement.controllers;

import com.example.ProductManagement.model.entities.CategoryEntity;
import com.example.ProductManagement.model.entities.ProductEntity;
import com.example.ProductManagement.repsitories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v2.0/category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/getAllCategory")
    public ResponseEntity get(
            @RequestParam(value = "pages") int page,
            @RequestParam(value = "page_size") int pageSize
    ){
        Page<CategoryEntity> categoryEntities=categoryRepository.findAll(PageRequest.of(page,pageSize));
        return  ResponseEntity.ok(categoryEntities);
    }
    //Post
    @PostMapping("/add")
    public ResponseEntity addCategoryEntity(@RequestBody CategoryEntity categoryEntity) {
        return ResponseEntity.ok(categoryRepository.save(categoryEntity));
    }

    //update
    @PutMapping("update")
    public ResponseEntity updateCategoryEntity(@RequestBody CategoryEntity categoryEntity){
        return  ResponseEntity.ok(categoryRepository.save(categoryEntity));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(
            @PathVariable Integer id
    ) {
        Optional<CategoryEntity> categoryEntity = categoryRepository.findById(id);
        return ResponseEntity.ok("Thanh cong");
    }

}
