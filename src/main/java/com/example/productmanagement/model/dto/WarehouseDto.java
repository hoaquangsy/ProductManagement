package com.example.productmanagement.model.dto;

import com.example.productmanagement.model.entities.DistrictEntity;
import com.example.productmanagement.model.entities.ProvinceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseDto {

    private Integer id;

    private String name;

    private String address;

    private Integer status;

    private ProvinceEntity provinceEntity;

    private DistrictEntity districtEntity;
}
