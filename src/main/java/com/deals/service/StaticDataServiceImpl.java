package com.deals.service;

import com.deals.model.Category;
import com.deals.model.City;
import com.deals.repository.CategoryRepository;
import com.deals.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("staticDataService")
public class StaticDataServiceImpl implements StaticDataService{
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }
}
