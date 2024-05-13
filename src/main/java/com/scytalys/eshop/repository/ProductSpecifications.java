package com.scytalys.eshop.repository;

import com.scytalys.eshop.model.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecifications {
    public static Specification<Product> nameContains(String keyword) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + keyword + "%");
    }

    public static Specification<Product> descriptionContains(String keyword) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("description"), "%" + keyword + "%");
    }

    public static Specification<Product> minPriceCalculation(Double minPrice) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.greaterThanOrEqualTo(root.get("price"),  minPrice );
    }

    public static Specification<Product> maxPriceCalculation(Double maxPrice) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.lessThanOrEqualTo(root.get("price"),  maxPrice );
    }
}
