package com.testtask.service;

import com.testtask.entity.Product;
import com.testtask.repository.FilterCriteria;
import com.testtask.repository.ProductRepository;
import com.testtask.repository.ProductSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> readAll() {
        return productRepository.findAll();
    }
    public List<Product> readAll(Map<String, String> args) {
        Specification<Product> productSpecifications = null;
        Sort sort = Sort.unsorted();
        for (String key : args.keySet()) {
            String[] keys = key.split("_");
            if (keys.length == 2) {
                switch (keys[1]){
                    case "asc":
                        sort = sort.and(Sort.by(Sort.Direction.ASC, keys[0]));
                        break;
                    case "desc":
                        sort = sort.and(Sort.by(Sort.Direction.DESC, keys[0]));
                        ;
                }
                continue;
            }
            FilterCriteria filterCriteria = new FilterCriteria();
            filterCriteria.setKey(TypeFilter.getEnum(keys[0]));

            filterCriteria.setOperation(keys.length == 1 ? ":":keys[1]);

            filterCriteria.setValue(args.get(key));
            if (productSpecifications == null){
                productSpecifications = Specification.where(new ProductSpecification(filterCriteria));
            } else {
                productSpecifications = productSpecifications.and(new ProductSpecification(filterCriteria));
            }
        }
        List<Product> products = productRepository.findAll(productSpecifications, sort);

        return products;
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
