package com.testtask.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTOSave extends ProductDTO {
    private Double price = 0.0;

    private Boolean available = false;

}
