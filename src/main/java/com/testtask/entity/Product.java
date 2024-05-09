package com.testtask.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "Products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(length = 4096)
    private String description;

    @Column(columnDefinition = "DOUBLE PRECISION CHECK (price >= 0) DEFAULT 0 ")
    private Double price;

    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean available;


}
