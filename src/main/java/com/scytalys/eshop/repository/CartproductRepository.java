package com.scytalys.eshop.repository;

import com.scytalys.eshop.model.Cartproduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartproductRepository extends JpaRepository<Cartproduct, Long> {
}
