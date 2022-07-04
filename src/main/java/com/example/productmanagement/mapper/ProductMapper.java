package com.example.productmanagement.mapper;

import com.example.productmanagement.model.dto.ProductDto;
import com.example.productmanagement.model.entities.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    @Autowired
    private ModelMapper mapper;

    public ProductEntity convertToEntity(ProductDto productDto){
        ProductEntity productEntity=mapper.map(productDto,ProductEntity.class);
        return productEntity;
    }

    public ProductDto convertToDto(ProductEntity productEntity){
        ProductDto productDto=mapper.map(productEntity,ProductDto.class);
        return productDto;
    }
}
