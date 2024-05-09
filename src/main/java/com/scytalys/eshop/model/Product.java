package com.scytalys.eshop.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Product extends BaseModel {
    private String name;
    private BigDecimal price;
    private int quantity;
    private ProductCategory category;
}
