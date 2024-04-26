package com.scytalys.eshop.service;

import com.scytalys.eshop.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product getProduct(long id);
    List<Product> getProducts();
    Product updateProduct(long id, Product product);
    boolean deleteProduct(long id);
 }
