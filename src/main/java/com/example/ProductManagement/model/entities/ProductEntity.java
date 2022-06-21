package com.example.ProductManagement.model.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column
    private String sku;

    @Column(name = "status")
    private Integer status;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId",nullable = false)
    @JsonIgnore
    private CategoryEntity categoryEntity;

    @OneToMany(mappedBy = "productEntity")
    @JsonIgnore
    private List<WarehouseProductEntity> warehouseProductEntities;

}
