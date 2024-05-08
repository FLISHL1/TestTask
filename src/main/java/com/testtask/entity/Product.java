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
    private Long id;
    @NotNull(groups = {Save.class})
    @Size(min=1, max = 255, message = "{validation.name.size.too_long}", groups = {Save.class, Update.class})
    private String name;

    @Size(max = 4096, message = "{validation.name.size.too_long}", groups = {Save.class, Update.class})
    private String description;

    @Min(value = 0, groups = { Save.class, Update.class})
    private Double price;

    private Boolean available;

    public Product(Long id, String name, String description, Double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = false;
    }

    public Product(Long id, String name, String description, boolean available) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = 0.0;
        this.available = available;
    }

    public Product(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = 0.0;
        this.available = false;
    }

    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
        this.price = 0.0;
        this.available = false;
    }

    public interface Save{ }

    public interface Update{ }
}
