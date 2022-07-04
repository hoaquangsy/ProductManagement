package com.example.productmanagement.repsitories;

import com.example.productmanagement.model.entities.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<ProvinceEntity,Integer> {
}
