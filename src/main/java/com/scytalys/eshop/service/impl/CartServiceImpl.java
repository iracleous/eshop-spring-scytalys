package com.scytalys.eshop.service.impl;

import com.scytalys.eshop.dto.CartProductDto;
import com.scytalys.eshop.dto.CustomerInfoResponse;
import com.scytalys.eshop.dto.ResponseApi;
import com.scytalys.eshop.model.Cart;
import com.scytalys.eshop.model.CartProduct;
import com.scytalys.eshop.model.Customer;
import com.scytalys.eshop.model.Product;
import com.scytalys.eshop.repository.CartRepository;
import com.scytalys.eshop.repository.CartProductRepository;
import com.scytalys.eshop.repository.CustomerRepository;
import com.scytalys.eshop.repository.ProductRepository;
import com.scytalys.eshop.service.CartService;
import com.scytalys.eshop.service.CustomerValidator;
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
    private final CartProductRepository cartproductRepository;
    private final CustomerValidator customerValidator;

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
    public ResponseApi<Customer> createCustomer(Customer customer) {
        ResponseApi<Customer> validation = customerValidator.validate(customer);
        if (validation.getCode() != 0) return validation;
        customerRepository.save(customer);
        return new ResponseApi<Customer>(0,"the customer was saved", customer);
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
    public CartProduct addProduct(CartProductDto cartProductDto) {
        Cart cart = getCartById(cartProductDto.cartId());
        Product product = productRepository.findById(cartProductDto.productId()).orElse(null);
        CartProduct cartproduct = new CartProduct();
        cartproduct.setProduct(product);
        cartproduct.setCart(cart);
        cartproduct.setQuantity(cartProductDto.quantity());
        cartproduct.setPrice(cartProductDto.price());
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

    @Override
    public double getTotalPrice(long cartId) {
        return cartRepository.calculateTotal(cartId);
    }

    @Override
    public CustomerInfoResponse getCartCount(long customerId) {
        return  cartRepository.getCustomerCartCount(customerId);

    }
}
