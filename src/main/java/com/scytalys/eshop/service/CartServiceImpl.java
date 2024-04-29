package com.scytalys.eshop.service;

import com.scytalys.eshop.model.Cart;
import com.scytalys.eshop.model.Cartproduct;
import com.scytalys.eshop.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartServiceImpl implements CartService {
    @Override
    public Customer createCart(Customer customer) {
        return null;
    }

    @Override
    public Customer getCustomer(long id) {
        return null;
    }

    @Override
    public List<Customer> getCustomers() {
        return List.of();
    }

    @Override
    public Customer updateCustomer(long id, Customer customer) {
        return null;
    }

    @Override
    public boolean deleteCustomer(long id) {
        return false;
    }

    @Override
    public Cart createCart(long customerId) {
        return null;
    }

    @Override
    public Cart getCartById(long cartId) {
        return null;
    }

    @Override
    public List<Cart> getCarts(long customerId) {
        return List.of();
    }

    @Override
    public Cartproduct addProduct(long productId, long cartId) {
        return null;
    }

    @Override
    public Cart clearCart(long cartId) {
        return null;
    }

    @Override
    public boolean removeProduct(long productId, long cartId) {
        return false;
    }

    @Override
    public boolean deleteCart(long cartId) {
        return false;
    }
}
