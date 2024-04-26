package com.scytalys.eshop.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity@Data
public class Customer  extends BaseModel{
    private String address;
    private String phone;
    private String email;
    private String city;
    private String state;
    private String zip;

}
