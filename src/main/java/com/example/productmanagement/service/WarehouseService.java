package com.example.productmanagement.service;

import com.example.productmanagement.model.entities.WarehouseEntity;
import org.springframework.stereotype.Service;

@Service
public interface WarehouseService {
    WarehouseEntity addWarehouse(WarehouseEntity warehouseEntity);


    WarehouseEntity deleteWarehouseEntity(Integer id);
}
