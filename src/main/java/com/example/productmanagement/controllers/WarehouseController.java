package com.example.productmanagement.controllers;

import com.example.productmanagement.exceptions.NotFound;
import com.example.productmanagement.mapper.WarehouseMapper;
import com.example.productmanagement.model.dto.WarehouseDto;
import com.example.productmanagement.model.entities.WarehouseEntity;
import com.example.productmanagement.model.response.ProductResponse;
import com.example.productmanagement.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2.0/warehouse")
public class WarehouseController {
    @Autowired
    private WarehouseService warehouseService;

    @Autowired
    private WarehouseMapper mapper;
    @PostMapping("add")
    public ResponseEntity addWarehouse(@RequestBody WarehouseDto warehouseDto){
        WarehouseEntity warehouseEntity=mapper.convertToEntity(warehouseDto);
        warehouseService.addWarehouse(warehouseEntity);
        ProductResponse productResponse=new ProductResponse("true","thanhCong",warehouseEntity);
        return ResponseEntity.ok(productResponse);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteWarehouse(@PathVariable(name = "id",required = false)Integer id){

        warehouseService.deleteWarehouseEntity(id);
        ProductResponse productResponse=new ProductResponse("true","thanhCong",warehouseService.deleteWarehouseEntity(id));
        return ResponseEntity.ok(productResponse);
    }
}
