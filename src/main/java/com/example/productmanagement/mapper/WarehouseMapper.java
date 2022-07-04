package com.example.productmanagement.mapper;

import com.example.productmanagement.model.dto.WarehouseDto;
import com.example.productmanagement.model.entities.WarehouseEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseMapper {
    @Autowired
    private ModelMapper mapper;

    public WarehouseEntity convertToEntity(WarehouseDto warehouseDto){
        WarehouseEntity warehouseEntity=mapper.map(warehouseDto,WarehouseEntity.class);
        return warehouseEntity;
    }
    public WarehouseDto convertToDto(WarehouseEntity warehouseEntity){
        WarehouseDto warehouseDto=mapper.map(warehouseEntity,WarehouseDto.class);
        return warehouseDto;
    }
}
