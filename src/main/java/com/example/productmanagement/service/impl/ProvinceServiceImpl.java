package com.example.productmanagement.service.impl;

import com.example.productmanagement.exceptions.NotFound;
import com.example.productmanagement.model.entities.ProvinceEntity;
import com.example.productmanagement.repsitories.ProvinceRepository;
import com.example.productmanagement.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;
    @Override
    public ProvinceEntity findById(Integer id){

        Optional<ProvinceEntity> ProvinceEntity=provinceRepository.findById(id);
        if (ProvinceEntity.isPresent()){
            return ProvinceEntity.get();
        }

        throw new NotFound("id ProvinceEntity not found");
    }

}
