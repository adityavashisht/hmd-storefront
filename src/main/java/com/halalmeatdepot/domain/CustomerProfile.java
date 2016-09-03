package com.halalmeatdepot.domain;

/**
 * Created by vashishta on 9/3/16.
 */
public class CustomerProfile {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // One to one on customer
    private Customer customer;

    private Address address;
    private Phone phone;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CustomerProfile{" +
                "id=" + id +
                ", customer=" + customer +
                ", address=" + address +
                ", phone=" + phone +
                '}';
    }
}
