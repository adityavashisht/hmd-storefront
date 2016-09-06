package com.halalmeatdepot.dto;

/**
 * Created by vashishta on 9/6/16.
 */
public class OrderDTO {

    private Long id;
    private String firstName;
    private String lastName;



    public Long getId() {
        return id;
    }

    public OrderDTO(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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
}
