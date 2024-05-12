package com.scytalys.eshop.service.impl;

import com.fasterxml.jackson.databind.util.ArrayBuilders;
import com.scytalys.eshop.dto.ProductUpdateRequest;
import com.scytalys.eshop.model.Product;
import com.scytalys.eshop.repository.ProductRepository;
import com.scytalys.eshop.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    @Transactional
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProduct(long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    @Transactional
    public Product updateProduct(long id, Product productRequest) {
        Product productDb = productRepository.findById(id).orElse(null);
        if (productDb == null) { return null;}
        // Apply updates
        if (productRequest.getName() != null) {
            productDb.setName(productRequest.getName());
        }
        if (productRequest.getDescription() != null) {
            productDb.setDescription(productRequest.getDescription());
        }
        if (productRequest.getPrice() != null) {
            productDb.setPrice(productRequest.getPrice());
        }
        productRepository.save(productDb);
        return productDb;
    }


    @Override
    @Transactional
    public boolean deleteProduct(long id) {
        Product productDb = productRepository.findById(id).orElse(null);
        if (productDb == null) { return false;}
        productRepository.delete(productDb);
        return true;
    }

    @Override
    @Transactional
    public boolean increasePrices(double increasePercentage) {
        if (increasePercentage <= 0 ||increasePercentage>.40) { return false; }
        productRepository.increasePrice(1+increasePercentage);
        return true;
    }

    @Override
    public List<Product> getProductsByQuantity(int quantity) {
        return productRepository.getByQuantity(quantity);
    }

    @Override
    public List<Product> search(Specification<Product> spec) {
        return productRepository.findAll(spec);
    }
}
