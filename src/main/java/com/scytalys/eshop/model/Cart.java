package com.scytalys.eshop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Cart extends BaseModel {

    private LocalDateTime orderDate;
    private LocalDateTime deliverDate;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    @NotNull
    private Customer customer;
}
