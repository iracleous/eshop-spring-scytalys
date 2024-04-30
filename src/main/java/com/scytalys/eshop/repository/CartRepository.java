package com.scytalys.eshop.repository;

import com.scytalys.eshop.dto.CustomerInfoResponse;
import com.scytalys.eshop.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query("select new java.lang.Double( sum(cp.quantity*coalesce(cp.price,0)*1.) ) sd  from CartProduct cp where cp.cart.id = :cartId")
    Double calculateTotal(long cartId);

    @Query("""
            select new java.lang.Long( count(c) ) 
            from Cart c 
            where c.customer.id = :customerId
            """ )
     Long getCartCount(long customerId);


    @Query("""
            select new com.scytalys.eshop.dto.CustomerInfoResponse( 
            c.customer.id, c.customer.name, c.customer.email, count(c) ) 
            from Cart c 
            where c.customer.id = :customerId
            group by c.customer.id, c.customer.name, c.customer.email
            """ )
    CustomerInfoResponse getCustomerCartCount(long customerId);

}

/*

  select
            cu.id, cu.name, cu.email, count(0)
            from Cart c
            inner join customer cu on c.customer_id = cu.id
            where cu.id = :customerId
            group by cu.id, cu.name, cu.email



 */