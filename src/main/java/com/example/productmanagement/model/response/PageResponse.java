package com.example.productmanagement.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageResponse {
    private Integer page;
    private Integer pageSize;
    private Long total;
}
