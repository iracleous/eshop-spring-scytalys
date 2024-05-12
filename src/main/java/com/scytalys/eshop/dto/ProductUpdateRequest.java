package com.scytalys.eshop.dto;

import lombok.Data;

@Data
public class ProductUpdateRequest {
    private String name;
    private String description;
    private Double price;
}
