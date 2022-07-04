package com.example.productmanagement.repsitories;

import com.example.productmanagement.model.entities.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistricRepository extends JpaRepository<DistrictEntity,Integer> {
}
