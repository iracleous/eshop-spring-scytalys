package com.scytalys.eshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity@Data
public class Customer  extends BaseModel{
    private String address;
    private String phone;
    private String email;
    private String city;
    private String state;
    private String zip;
    private int age;
    private LocalDate birthday;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Cart> carts = new ArrayList<>();
}
