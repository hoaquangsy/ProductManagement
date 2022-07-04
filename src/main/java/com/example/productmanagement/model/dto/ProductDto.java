package com.example.productmanagement.model.dto;

import com.example.productmanagement.model.entities.CategoryEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Integer id;

    @NotBlank(message = "Không để trống tên product")
    @Length(max = 100,message = "tên không quá 100 kí tự")
    private String name;

    @DecimalMin(value = "0",message = "giá >0")
    private BigDecimal price;

    private String sku;
    private Integer status;
    private String description;
    private String code;
    private Date createAt;
    private Date modifiedAt;
    private CategoryEntity categoryEntity;
}
