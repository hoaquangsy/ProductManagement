package com.example.ProductManagement.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "WarehouseProduct")
public class WarehouseProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private Integer inventory;

    @Column
    private Integer totalImport;

    @Column
    private Integer totalExport;

    @Column
    private Date startDate;

    @Column
    private Date expiredDate;

    @ManyToOne
    @JoinColumn(name = "productId")
    @JsonIgnore
    private ProductEntity productEntity;

    @ManyToOne
    @JoinColumn(name = "warehouseId")
    @JsonIgnore
    private WarehouseEntity warehouseEntity;


}
