package com.example.productmanagement.service.impl;

import com.example.productmanagement.exceptions.NotFound;
import com.example.productmanagement.model.entities.CategoryEntity;
import com.example.productmanagement.model.entities.ProductEntity;
import com.example.productmanagement.repsitories.CategoryRepository;
import com.example.productmanagement.repsitories.ProductRepository;
import com.example.productmanagement.service.CategoryService;
import com.example.productmanagement.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;


    @Override
    public ProductEntity addProductEntity(ProductEntity productEntity) throws ParseException {
        productEntity.setId(null);
//        if (Integer.parseInt(productEntity.getPrice()+"")<=0){
//            throw new
//        } else if (productEntity.getName().isEmpty() || productEntity.getName().length()>1000) {
//            ResponseEntity.badRequest();
//        }else{
            SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
            //
            String create=simpleDateFormat.format(new Date());
            CategoryEntity category= categoryService.findById(productEntity.getCategoryEntity().getId());

            //
            productEntity.setCategoryEntity(category);
            productEntity.setModifiedAt(new Date());
            productEntity.setStatus(1);
            String code= productEntity.getCategoryEntity().getCode()+"."+productEntity.getSku()+"."+create;
            productEntity.setCode(code);
            return productRepository.save(productEntity);
//        }
//        return null;
    }

    @Override
    public ProductEntity deleteProduct(Integer id){
        Optional<ProductEntity> productEntity=productRepository.findById(id);
        productEntity.get().setStatus(0);

        return productRepository.save(productEntity.get());
    }
    @Override
    public ProductEntity update(ProductEntity productEntity){
        productEntity.setModifiedAt(new Date());
        return productRepository.save(productEntity);
    }
    @Override
    public Page<ProductEntity> getPage(Pageable pageable){
        return  productRepository.findAll(pageable);
    }

    @Override
    public ProductEntity findById(int id){
        Optional<ProductEntity> productEntity=productRepository.findById(id);
        if (productEntity.isPresent()){
            return productEntity.get();
        }

        throw new NotFound("id productEntity not found");
    }
    @Override
    public Page<ProductEntity> listProduct(String name, BigDecimal price, Pageable pageable){
        Page<ProductEntity> productEntityPage=productRepository.listSearch(name,price,pageable);
        return productEntityPage;
    }
}
