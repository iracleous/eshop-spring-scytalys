package com.scytalys.eshop.model;


import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Employee extends BaseModel{
    private String firstName;
    private String lastName;
}
