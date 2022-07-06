package com.example.productmanagement.model.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;


import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;
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

    private BigDecimal price;

    @Column
    private String sku;

    @Column(name = "status")
    private Integer status;

    @Column(name = "description")
    private String description;

    @Column(name = "code")
    private String code;

    @Column(name = "createAt")
    @CreationTimestamp
    private Date createAt;

    @Column(name = "modifiedAt")
    @UpdateTimestamp
    private Date modifiedAt;

    @ManyToOne
    @JoinColumn(name = "categoryId",nullable = false)
    @JsonIgnore
    private CategoryEntity categoryEntity;

    @OneToMany(mappedBy = "productEntity")
    @JsonIgnore
    private List<WarehouseProductEntity> warehouseProductEntities;

}
