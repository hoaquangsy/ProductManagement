package com.example.productmanagement.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Warehouse")
public class WarehouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;
    @Column
    private String address;
    @Column
    private Integer status;

    //
    @ManyToOne
    @JoinColumn(name = "provinceId")
    @JsonIgnore
    private ProvinceEntity provinceEntity;

    @ManyToOne
    @JoinColumn(name = "districtId")
    @JsonIgnore
    private DistrictEntity districtEntity;

    @OneToMany(mappedBy = "warehouseEntity")
    @JsonIgnore
    private List<WarehouseProductEntity> warehouseProductEntities;

}
