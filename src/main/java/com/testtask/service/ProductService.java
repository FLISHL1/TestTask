package com.testtask.service;

import com.testtask.entity.Product;
import com.testtask.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> readAll() {
        return productRepository.findAll();
    }

    public Product readById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public boolean delete(Long productId) {
        if (productRepository.findById(productId).isPresent()) {
            productRepository.deleteById(productId);
            return true;
        }
        return false;
    }
}
