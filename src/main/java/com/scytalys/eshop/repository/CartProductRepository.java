package com.scytalys.eshop.repository;

import com.scytalys.eshop.model.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
}
