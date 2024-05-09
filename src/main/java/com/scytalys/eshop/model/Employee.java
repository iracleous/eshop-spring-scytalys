package com.scytalys.eshop.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Employee extends BaseModel{
    private String firstName;
    @Column(unique=true)
    private String lastName;
}
