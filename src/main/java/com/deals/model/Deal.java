package com.deals.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "deal")
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dealid")
    private int dealid;
    @Column(name = "name")
    @NotEmpty(message = "*Please provide your title")
    private String name;
    @Column(name = "categoryid")
    @NotEmpty(message = "*Please provide your category")
    private int categoryid;
    @Column(name = "userid")
    @NotEmpty(message = "*Please provide your user")
    private int userid;
    @Column(name = "cityid")
    @NotEmpty(message = "*Please provide your city")
    private int cityid;
    @Column(name = "price")
    @NotEmpty(message = "*Please provide your price")
    private float price;

    public int getDealid() {
        return dealid;
    }

    public Deal setDealid(int dealid) {
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

    public int getCityid() {
        return cityid;
    }

    public Deal setCityid(int cityid) {
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
