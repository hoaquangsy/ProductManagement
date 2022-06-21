package com.example.ProductManagement.repsitories;


import com.example.ProductManagement.model.entities.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    @Query("select p from ProductEntity p where p.name like %:name% and p.price>=50000 order by p.price DESC ")
    public Page<ProductEntity> listSearch(@Param("name")String name, Pageable pageable);
}
