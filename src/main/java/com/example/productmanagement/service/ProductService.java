package com.example.productmanagement.service;

import com.example.productmanagement.model.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;

@Service
public interface ProductService {


    ProductEntity addProductEntity(ProductEntity productEntity) throws ParseException;

    ProductEntity deleteProduct(Integer id);

    ProductEntity update(ProductEntity productEntity);

    Page<ProductEntity> getPage(Pageable pageable);

    ProductEntity findById(int id);

    Page<ProductEntity> listProduct(String name, BigDecimal price, Pageable pageable);
}
