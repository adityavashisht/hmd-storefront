package com.halalmeatdepot.domain.mm;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vashishta on 9/3/16.
 */
public class Project {
    private Long id;
    private String name;

    private Set<Employee> employees = new HashSet<>();

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
