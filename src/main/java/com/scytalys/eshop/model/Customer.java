package com.scytalys.eshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity@Data
public class Customer  extends BaseModel{
    private String name;
    private String address;
    private String phone;
    @Email
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
