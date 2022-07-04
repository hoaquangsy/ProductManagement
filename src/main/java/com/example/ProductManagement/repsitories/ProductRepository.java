package com.example.productmanagement.repsitories;


import com.example.productmanagement.model.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    @Query("select p from ProductEntity p where p.name like %:name% and p.price>=:price order by p.price DESC ")
    public Page<ProductEntity> listSearch(@Param("name")String name, @Param("price")BigDecimal price, Pageable pageable);
}
