package com.scytalys.eshop.service;

import com.scytalys.eshop.model.Cart;
import com.scytalys.eshop.model.CartProduct;
import com.scytalys.eshop.model.Customer;
import com.scytalys.eshop.model.Product;
import com.scytalys.eshop.repository.CartRepository;
import com.scytalys.eshop.repository.CartproductRepository;
import com.scytalys.eshop.repository.CustomerRepository;
import com.scytalys.eshop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final CartproductRepository cartproductRepository;

    @Override
    public Customer getCustomer(long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCustomer(long id) {
        return false;
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
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    ////////////////////////////////////////////////////////////////

    @Override
    @Transactional
    public Cart createCart(long customerId) {
        Customer customer = getCustomer(customerId);
        Cart cart = new Cart();
        cart.setCustomer(customer);
        cart.setOrderDate(LocalDateTime.now());
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public Cart getCartById(long cartId) {
        return cartRepository.findById(cartId).orElse(null);
    }

    @Override
    public List<Cart> getCarts(long customerId) {
        return List.of();
    }

    @Override
    @Transactional
    public CartProduct addProduct(long productId, long cartId, int quantity) {
        Cart cart = getCartById(cartId);
        Product product = productRepository.findById(productId).orElse(null);
        CartProduct cartproduct = new CartProduct();
        cartproduct.setProduct(product);
        cartproduct.setCart(cart);
        cartproduct.setQuantity(quantity);
        cartproductRepository.save(cartproduct);
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