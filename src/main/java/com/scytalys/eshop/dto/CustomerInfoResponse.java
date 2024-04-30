package com.scytalys.eshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerInfoResponse {

    private   long customerId;
    private String customerName;
    private String customerEmail;
    private long cartCount;
}
