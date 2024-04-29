package com.scytalys.eshop.dto;

import java.math.BigDecimal;

public record CartProductDto (long cartId, long productId, BigDecimal price, int quantity){

}
