package com.scytalys.eshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class CartProduct extends BaseModel{

    private int quantity;
    private BigDecimal price;

    @ManyToOne
    private Product product;
    @ManyToOne
    private Cart cart;
 }
