package com.testtask.repository;

import com.testtask.entity.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@AllArgsConstructor
@NoArgsConstructor
public class ProductSpecification  implements Specification<Product> {
    @Override
    public Specification<Product> and(Specification<Product> other) {
        return Specification.super.and(other);
    }

    private FilterCriteria filterCriteria;
    @Override
    public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (filterCriteria != null) {
            if (filterCriteria.getOperation().equalsIgnoreCase(":")) {
                switch (filterCriteria.getKey()) {
                    case Name:
                        return builder.like(root.<String>get(filterCriteria.getKey().toString()), (filterCriteria.getValue() + "%"));
                    case Price:
                        return builder.equal(root.<String>get(filterCriteria.getKey().toString()), Double.valueOf(filterCriteria.getValue()));
                    case Available:
                        return builder.equal(root.<Boolean>get(filterCriteria.getKey().toString()), Boolean.valueOf(filterCriteria.getValue()));
                }
            } else if (filterCriteria.getOperation().equalsIgnoreCase("gr")) {
                return builder.greaterThan(root.<String>get(filterCriteria.getKey().toString()), filterCriteria.getDoubleValue());
            } else if (filterCriteria.getOperation().equalsIgnoreCase("ls")) {
                return builder.lessThan(root.<String>get(filterCriteria.getKey().toString()), filterCriteria.getDoubleValue());
            } else if (filterCriteria.getOperation().equalsIgnoreCase("ge")) {
                return builder.greaterThanOrEqualTo(root.<String>get(filterCriteria.getKey().toString()), filterCriteria.getDoubleValue());
            } else if (filterCriteria.getOperation().equalsIgnoreCase("le")) {
                return builder.lessThanOrEqualTo(root.<String>get(filterCriteria.getKey().toString()), filterCriteria.getDoubleValue());
            }
        }
        return null;
    }
}
