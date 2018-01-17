package com.deals.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cityid")
    private Long id;
    @Column(name = "name")

    @NotEmpty(message = "*Please provide an city")
    private String name;

    public Long getId() {
        return id;
    }

    public City setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public City setName(String name) {
        this.name = name;
        return this;
    }
}
