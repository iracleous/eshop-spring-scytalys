package com.scytalys.eshop.repository;

import com.scytalys.eshop.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query("select new java.lang.Double( sum(cp.quantity*coalesce(cp.price,0)*1.) ) sd  from CartProduct cp where cp.cart.id = :cartId")
    Double calculateTotal(long cartId);
}
