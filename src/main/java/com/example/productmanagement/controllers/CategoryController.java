package com.example.productmanagement.controllers;

import com.example.productmanagement.model.dto.CategoryDto;
import com.example.productmanagement.mapper.CategoryMapper;
import com.example.productmanagement.model.entities.CategoryEntity;
import com.example.productmanagement.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2.0/category")
public class CategoryController {

    @Autowired
    private CategoryMapper mapper;

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/getAllCategory")
    public ResponseEntity get(
            @RequestParam(value = "pages") int page,
            @RequestParam(value = "page_size") int pageSize
    ){
         PageRequest pageRequest=PageRequest.of(page,pageSize);
          return ResponseEntity.ok(categoryService.getPage(pageRequest));
    }
    //Post
    @PostMapping("/add")
    public ResponseEntity addCategoryEntity(@Validated @RequestBody CategoryDto categoryDto) {
        CategoryEntity categoryEntity=mapper.convertToEntity(categoryDto);
        return ResponseEntity.ok(categoryService.addCategoryEntity(categoryEntity));
    }

    //update
    @PutMapping("update")
    public ResponseEntity updateCategoryEntity(@Validated @RequestBody CategoryDto categoryDto){
        CategoryEntity categoryEntity=mapper.convertToEntity(categoryDto);
        return  ResponseEntity.ok(categoryService.updateCategoryEntity(categoryEntity));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(
            @PathVariable Integer id
    ) {
       CategoryEntity category=categoryService.findById(id);
        return ResponseEntity.ok(categoryService.deleteCategoryEntity(category));
    }

}
