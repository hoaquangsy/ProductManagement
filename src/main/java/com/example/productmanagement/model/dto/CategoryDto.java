package com.example.productmanagement.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private Integer id;
    @NotBlank(message = "Khong de trong ten category")
    @Length(max = 100,message = "tên không quá 100 kí tự")
    private String name;
    private String code;
    private Integer status;
    private String description;
}
