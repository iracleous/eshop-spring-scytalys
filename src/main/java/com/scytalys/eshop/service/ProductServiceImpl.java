package com.scytalys.eshop.service;

import com.scytalys.eshop.model.Product;
import com.scytalys.eshop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
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
    public Product updateProduct(long id, Product product) {
        Product productDb = productRepository.findById(id).orElse(null);
        if (productDb == null) { return null;}
        productDb.setName(product.getName());
        productDb.setPrice(product.getPrice());
        productRepository.save(productDb);
        return productDb;
    }

    @Override
    public boolean deleteProduct(long id) {
        Product productDb = productRepository.findById(id).orElse(null);
        if (productDb == null) { return false;}
        productRepository.delete(productDb);
        return true;
    }

    @Override
    public boolean increasePrices(double increasePercentage) {
        if (increasePercentage <= 0 ||increasePercentage>.40) { return false; }
        productRepository.increasePrice(1+increasePercentage);
        return true;
    }

    @Override
    public List<Product> getProductsByQuantity(int quantity) {
        return productRepository.getByQuantity(quantity);
    }
}
