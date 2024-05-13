package com.scytalys.eshop.service;

import com.scytalys.eshop.dto.ProductSearchDto;
import com.scytalys.eshop.dto.ProductUpdateRequest;
import com.scytalys.eshop.model.Product;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);
    Product getProduct(long id);
    List<Product> getProducts();
    Product updateProduct(long id, ProductUpdateRequest product);
    boolean deleteProduct(long id);

    boolean increasePrices(double increasePercentage);
    List<Product> getProductsByQuantity(int quantity);
    List<Product> search(Specification<Product> spec);
    List<Product> search(ProductSearchDto productSearchDto);
 }
