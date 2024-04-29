package com.scytalys.eshop.repository;

import com.scytalys.eshop.model.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartproductRepository extends JpaRepository<CartProduct, Long> {
}
