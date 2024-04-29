package com.scytalys.eshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Cartproduct extends BaseModel{

    public int quantity;
    private BigDecimal price;

    @ManyToOne
    private Product product;
    @ManyToOne
    private Cart cart;

 }
