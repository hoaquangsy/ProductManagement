package com.example.productmanagement.model.response;

import com.example.productmanagement.model.entities.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponse {
    private String succsses;
    private String message;
    private Object data;
}
