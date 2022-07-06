package com.example.productmanagement.controllers;

import com.example.productmanagement.mapper.ProductMapper;
import com.example.productmanagement.model.dto.ProductDto;
import com.example.productmanagement.model.entities.ProductEntity;
import com.example.productmanagement.model.response.PageResponse;
import com.example.productmanagement.model.response.PaginationResponse;
import com.example.productmanagement.model.response.ProductResponse;
import com.example.productmanagement.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.ParseException;

@RestController
@RequestMapping("/api/v2.0/product")
public class ProductController {
    @Autowired
    private ProductMapper mapper;

    @Autowired
    private ProductService productService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/getAllProduct")
    public ResponseEntity getAll( @RequestParam(value = "pages") int page,
                                  @RequestParam(value = "page_size") int pageSize
    ){
        Pageable pageable=PageRequest.of(page,pageSize);
        Page<ProductDto> productEntitiePage=productService.getPage(pageable)
                .map(productEntity -> modelMapper.map(productEntity,ProductDto.class));

        PageResponse pageResponse=new PageResponse(page,pageSize,productEntitiePage.getTotalElements());
        PaginationResponse paginationResponse=new PaginationResponse("true","ThanhCong",productEntitiePage.getContent(),pageResponse);
        return ResponseEntity.ok(paginationResponse);
    }
    @PostMapping("/add")
    public ResponseEntity addProductEntity(@Validated @RequestBody ProductDto productDto) throws ParseException {
        ProductEntity productEntity=mapper.convertToEntity(productDto);
        productService.addProductEntity(productEntity);
        ProductResponse productResponse=new ProductResponse("true","ThanhCong",productEntity);
        return ResponseEntity.ok(productResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity get1(@PathVariable(name = "id") ProductEntity productEntity){
           ProductDto productDto=mapper.convertToDto(productEntity);
        ProductResponse productResponse=new ProductResponse("true","ThanhCong",productEntity);
        return  ResponseEntity.ok(productResponse);
    }
    @PutMapping("/update")
    public ResponseEntity updateProductEntity(@Validated @RequestBody ProductDto productDto) throws ParseException {
        ProductEntity productEntity=mapper.convertToEntity(productDto);
        ProductResponse productResponse=new ProductResponse("true","ThanhCong",productEntity);
        productService.update(productEntity);
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping("search")
    public ResponseEntity searchProduct( @RequestParam(value = "name", required = false) String name,
                                         @RequestParam(value = "price", required = false) BigDecimal price,
                                         @RequestParam(value = "pages") int page,
                                         @RequestParam(value = "page_size") int pageSize
    ){
        Pageable pageable=PageRequest.of(0,5);

        Page<ProductDto> productEntities=productService.listProduct(name,price,pageable)
                .map(productEntity -> modelMapper.map(productEntity,ProductDto.class));

        PageResponse pageResponse=new PageResponse(page,pageSize,productEntities.getTotalElements());
        PaginationResponse paginationResponse=new PaginationResponse("true","ThanhCong",productEntities.getContent(),pageResponse);
        return ResponseEntity.ok(productEntities);
    }

    @DeleteMapping ("delete/{id}")
    public ResponseEntity deleteProduct(@PathVariable(name = "id") ProductEntity productEntity){
        ProductResponse productResponse=new ProductResponse("true","ThanhCong",productEntity);
        productService.deleteProduct(productEntity.getId());
        return ResponseEntity.ok(productResponse);
    }

}
