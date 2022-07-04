package com.example.productmanagement.service.impl;

import com.example.productmanagement.exceptions.NotFound;
import com.example.productmanagement.model.entities.DistrictEntity;
import com.example.productmanagement.repsitories.DistricRepository;
import com.example.productmanagement.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistricRepository districRepository;
    @Override
    public DistrictEntity findById(Integer id){

        Optional<DistrictEntity> districtEntity=districRepository.findById(id);
        if (districtEntity.isPresent()){
            return districtEntity.get();
        }

        throw new NotFound("id not found");
    }
}
