package com.example.productmanagement.mapper;

import com.example.productmanagement.model.dto.CategoryDto;
import com.example.productmanagement.model.entities.CategoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryMapper {
    @Autowired
    private ModelMapper mapper;

    public CategoryEntity convertToEntity(CategoryDto categoryDto){
        CategoryEntity categoryEntity=mapper.map(categoryDto,CategoryEntity.class);
        return categoryEntity;
    }

    public CategoryDto convertToDto(CategoryEntity categoryEntity){
        CategoryDto categoryDto=mapper.map(categoryEntity,CategoryDto.class);
        return  categoryDto;
    }
}
