package com.example.productmanagement.model.response;

import com.example.productmanagement.model.entities.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
@AllArgsConstructor
public class PaginationResponse {
    private String succsses;
    private String message;
    private Object data;
    private PageResponse pagination;
}
