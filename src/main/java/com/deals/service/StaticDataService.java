package com.deals.service;

import com.deals.model.Category;
import com.deals.model.City;

import java.util.List;

public interface StaticDataService {
    public List<City> getAllCities();
    public List<Category>getAllCategories();
}
