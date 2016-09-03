package com.halalmeatdepot.domain.mm;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by vashishta on 9/3/16.
 */
public class Employee {

    private Long id;
    private String name;

    private Set<Project> projects = new HashSet<>();


    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
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
