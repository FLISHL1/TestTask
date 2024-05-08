package com.testtask.controller;

import com.testtask.entity.Product;
import com.testtask.entity.ProductDTO;
import com.testtask.entity.ProductDTOSave;
import com.testtask.entity.ProductDTOUpdate;
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
    public ResponseEntity<Product> create(@RequestBody @Validated(ProductDTO.Save.class) ProductDTOSave productDTO) {
        Product productSave = Product.builder()
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .available(productDTO.getAvailable())
                .build();

        productService.save(productSave);
        return new ResponseEntity<>(productSave, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getEntity(@PathVariable Long productId) {
        return new ResponseEntity<>(productService.readById(productId), HttpStatus.OK);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateEntity(@RequestBody @Validated(ProductDTO.Update.class) ProductDTOUpdate productDTO, @PathVariable Long productId) {
        Product product = productService.readById(productId);
        if (productDTO.getPrice() != null) product.setPrice(productDTO.getPrice());
        if (productDTO.getAvailable() != null) product.setAvailable(productDTO.getAvailable());
        if (productDTO.getDescription() != null) product.setDescription(productDTO.getDescription());
        if (productDTO.getName() != null) product.setName(productDTO.getName());

        productService.save(product);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteEntity(@PathVariable Long productId) {
        System.out.println(productId);
        if (productService.delete(productId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
