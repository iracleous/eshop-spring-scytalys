package com.scytalys.eshop.controller;

import com.scytalys.eshop.dto.CartDto;
import com.scytalys.eshop.dto.CartProductDto;
import com.scytalys.eshop.model.Cart;
import com.scytalys.eshop.model.CartProduct;
import com.scytalys.eshop.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {
    private final CartService cartService;

@PostMapping
    public Cart addCart(@RequestBody CartDto cartDto) {
        return cartService.createCart(cartDto.customerId());
}
@GetMapping("/{cartId}")
    public Cart getCart(@PathVariable("cartId")  long cartId ) {
    return cartService.getCartById(cartId);
}

@PostMapping("/product")
    public CartProduct addProductToCart(@RequestBody CartProductDto cartProductDto) {
        return cartService.addProduct(cartProductDto);
    }
    @GetMapping("/{cartId}/cost")
    public double getCartCost(@PathVariable("cartId")  long cartId ) {
        return cartService.getTotalPrice(cartId);
    }

}
