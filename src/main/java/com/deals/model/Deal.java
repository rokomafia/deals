package com.deals.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "deal")
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dealid")
    private Long dealid;
    @Column(name = "name")
    @Length(max = 45, message = "*Deal Summary must have not more than 45 characters")
    @NotEmpty(message = "*Please provide your title")
    private String name;
    @Column(name = "categoryid")
    @NotNull(message = "*Please provide your category")
    private int categoryid;
    @Column(name = "userid")
    @NotNull(message = "*Please provide your user")
    private int userid;
    @Column(name = "cityid")
    @NotNull(message = "*Please provide your city")
    private Long cityid;
    @Column(name = "price")
    @NotNull(message = "*Please provide your price")
    private float price;
    @Column(name = "description")
    @Length(max = 200, message = "*Deal description must have not more than 200 characters")
    private String description;

    public String getDescription() {
        return description;
    }

    public Deal setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getDealid() {
        return dealid;
    }

    public Deal setDealid(Long dealid) {
        this.dealid = dealid;
        return this;
    }

    public String getName() {
        return name;
    }

    public Deal setName(String name) {
        this.name = name;
        return this;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public Deal setCategoryid(int categoryid) {
        this.categoryid = categoryid;
        return this;
    }

    public int getUserid() {
        return userid;
    }

    public Deal setUserid(int userid) {
        this.userid = userid;
        return this;
    }

    public Long getCityid() {
        return cityid;
    }

    public Deal setCityid(Long cityid) {
        this.cityid = cityid;
        return this;
    }

    public float getPrice() {
        return price;
    }

    public Deal setPrice(float price) {
        this.price = price;
        return this;
    }
}
