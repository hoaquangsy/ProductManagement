package com.example.productmanagement.service;

import com.example.productmanagement.model.entities.ProvinceEntity;
import org.springframework.stereotype.Service;

@Service
public interface ProvinceService {
    ProvinceEntity findById(Integer id);
}
