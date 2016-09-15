package com.halalmeatdepot.domain;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by vashishta on 8/30/16.
 */
public class Customer {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime birthDate;



    private CustomerProfile customerProfile;


    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public void addAddress(Address address) {
        address.setCustomer(this);
        getAddressSet().add(address);
    }

    private Set<Address> addressSet = new HashSet<>();

    public Set<Address> getAddressSet() {
        return addressSet;
    }

    public void setAddressSet(Set<Address> addressSet) {
        this.addressSet = addressSet;
    }

    public CustomerProfile getCustomerProfile() {
        return customerProfile;
    }

    public void setCustomerProfile(CustomerProfile customerProfile) {
        this.customerProfile = customerProfile;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
