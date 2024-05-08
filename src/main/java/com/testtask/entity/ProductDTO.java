package com.testtask.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotNull(groups = {Save.class}, message = "The name cannot be null")
    @Size(min=1, max = 255, message = "Incorrect length name", groups = {Save.class, Update.class})
    private String name;

    @Size(max = 4096, message = "Incorrect length name", groups = {Save.class, Update.class})
    private String description;

    @Min(value = 0, message = "The price cannot be lower than 0", groups = {Save.class, Update.class})
    private Double price;

    private Boolean available;

    public interface Save{ }

    public interface Update{ }

}
