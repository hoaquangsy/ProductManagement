package com.example.ProductManagement.controllers;

import com.example.ProductManagement.model.entities.CategoryEntity;
import com.example.ProductManagement.model.entities.ProductEntity;
import com.example.ProductManagement.repsitories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v2.0/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/getAllProduct")
    public ResponseEntity getAll( @RequestParam(value = "pages") int page,
                                  @RequestParam(value = "page_size") int pageSize
    ){
        Page<ProductEntity> productEntities=productRepository.findAll(PageRequest.of(page,pageSize));
        return ResponseEntity.ok(productEntities);
    }
    @PostMapping("/add")
    public ResponseEntity addProductEntity(@RequestBody ProductEntity productEntity) {
        return ResponseEntity.ok(productRepository.save(productEntity));
    }
    @GetMapping("/{id}")
    public ResponseEntity get1(@PathVariable(name = "id") ProductEntity productEntity){
//        Optional<ProductEntity> productEntity= productRepository.findById(1);
        return  ResponseEntity.ok(productEntity);
    }
    @PostMapping("/update")
    public ResponseEntity updateProductEntity(@RequestBody ProductEntity productEntity) {
        return ResponseEntity.ok(productRepository.save(productEntity));
    }

    @GetMapping("search")
    public ResponseEntity searchProduct( @RequestParam(value = "name") String name
    ){
        Pageable pageable=PageRequest.of(0,5);

        name="áo";

        Page<ProductEntity> productEntities=productRepository.listSearch(name,pageable);
        return ResponseEntity.ok(productEntities);
    }
}
