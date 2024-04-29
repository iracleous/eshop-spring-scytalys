package com.scytalys.eshop.repository;

import com.scytalys.eshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Transactional
    @Modifying
    @Query("update Product p set p.price = p.price* :increase")
    void increasePrice(@Param("increase") double increase);

    List<Product> findProductByQuantityIs(int quantity);

    @Query("select  p from Product p where p.quantity = :quantity")
    List<Product> getByQuantity(@Param("quantity") int quantity);

}
