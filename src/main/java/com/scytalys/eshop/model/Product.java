package com.scytalys.eshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Product extends BaseModel {
    private double price;
    private int quantity;
    private ProductCategory category;
}
