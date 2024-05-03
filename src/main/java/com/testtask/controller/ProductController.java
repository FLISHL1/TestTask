package com.testtask.controller;

import com.testtask.entity.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
public class ProductController implements ApiController<Product> {

    private ArrayList<Product> productList;

    public ProductController() {
        productList = new ArrayList<>();
        productList.add(Product.builder()
                .id(1)
                .name("Товар1")
                .description("Описание1")
                .price(150.0)
                .available(true)
                .build());
    }

    @GetMapping()
    public ResponseEntity<ArrayList<Product>> getAll() {
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Product> create(@Valid @RequestBody  Product entity) {
        productList.add(entity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getEntity(@PathVariable Long productId) {
        Product product = null;
        for (Product item: productList){
            if (productId.equals(item.getId())){
                product = item;
                break;
            }
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> updateEntity(Product entity, Long entityId) {
        return null;
    }

    @Override
    public ResponseEntity<Product> patchEntity(Map<String, ?> args, Long entityId) {
        return null;
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteEntity(Long productId) {
        for (int i = 0; i < productList.size(); i++){
            if (productId.equals(productList.get(i).getId())){
                productList.remove(i);
                break;
            }
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
