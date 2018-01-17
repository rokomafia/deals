package com.deals.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "categoryid")
    private int id;
    @Column(name = "name")

    @NotEmpty(message = "*Please provide an category")
    private String name;

    public int getId() {
        return id;
    }

    public Category setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Category setName(String name) {
        this.name = name;
        return this;
    }
}
