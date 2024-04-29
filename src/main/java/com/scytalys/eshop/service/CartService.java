package com.scytalys.eshop.service;

import com.scytalys.eshop.model.Cart;
import com.scytalys.eshop.model.CartProduct;
import com.scytalys.eshop.model.Customer;

import java.util.List;

public interface CartService {
    // customer management

    Customer createCustomer(Customer customer);
    Customer getCustomer(long id);
    List<Customer> getCustomers();
    Customer updateCustomer(long id, Customer customer);
    boolean deleteCustomer(long id);
    
        // cart management
    Cart createCart(long customerId);
    Cart getCartById(long cartId);
    List<Cart> getCarts(long customerId);
    CartProduct addProduct(long productId, long cartId, int quantity);
    Cart clearCart(long cartId);
    boolean removeProduct(long productId, long cartId);
    boolean deleteCart(long cartId);
    
}