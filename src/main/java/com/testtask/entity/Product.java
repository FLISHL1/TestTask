package com.testtask.entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    private long id;
    @NotBlank
    @Size(max = 255, message = "{validation.name.size.too_long}")
    private String name;
    @Size(max = 4096, message = "{validation.name.size.too_long}")
    private String description;
    @Min(0)
    private Double price = 0.0;
    private Boolean available = false;

    public Product(String name){
        this.name = name;
    }
}
