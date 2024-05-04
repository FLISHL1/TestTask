package com.testtask.controller;

import com.testtask.entity.Product;
import com.testtask.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController implements ApiController<Product> {

    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productService.readAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Product> create(@RequestBody @Validated(Product.Save.class)  Product product) {
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getEntity(@PathVariable Long productId) {
        return new ResponseEntity<>(productService.readById(productId), HttpStatus.OK);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateEntity(@RequestBody @Validated(Product.Update.class) Product product, @PathVariable Long productId) {
        Product productEdit = productService.readById(productId);
        if (product.getPrice() != null) productEdit.setPrice(product.getPrice());
        if (product.getAvailable() != null) productEdit.setAvailable(product.getAvailable());
        if (product.getDescription() != null) productEdit.setDescription(product.getDescription());
        if (product.getName() != null) productEdit.setName(product.getName());
        productService.save(productEdit);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteEntity(Long productId) {
        if (productService.delete(productId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
