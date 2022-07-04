package com.example.productmanagement.service.impl;

import com.example.productmanagement.exceptions.NotFound;
import com.example.productmanagement.model.entities.WarehouseEntity;
import com.example.productmanagement.repsitories.DistricRepository;
import com.example.productmanagement.repsitories.ProvinceRepository;
import com.example.productmanagement.repsitories.WarehouseRepository;
import com.example.productmanagement.service.DistrictService;
import com.example.productmanagement.service.ProvinceService;
import com.example.productmanagement.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseRepository warehouseRepository;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private ProvinceService provinceService;


    @Override
    public WarehouseEntity addWarehouse(WarehouseEntity warehouseEntity){
        warehouseEntity.setProvinceEntity(provinceService.findById(warehouseEntity.getProvinceEntity().getId()));
        warehouseEntity.setDistrictEntity(districtService.findById(warehouseEntity.getDistrictEntity().getId()));
        String adress=warehouseEntity.getAddress()+","+warehouseEntity.getDistrictEntity().getName()+","+
                warehouseEntity.getProvinceEntity().getName();
        warehouseEntity.setStatus(1);
        warehouseEntity.setAddress(adress);
     return warehouseRepository.save(warehouseEntity);
    }
    @Override
    public WarehouseEntity deleteWarehouseEntity(Integer id){
        System.out.println(id);
        WarehouseEntity warehouseEntity=findById(id);
        warehouseEntity.setStatus(0);
        return warehouseRepository.save(warehouseEntity);
    }
    public WarehouseEntity findById(Integer id){

        Optional<WarehouseEntity> warehouseEntity=warehouseRepository.findById(id);
        if (warehouseEntity.isPresent()){
            return warehouseEntity.get();
        }

        throw new NotFound("id warehouseEntity  not found");
    }
}
