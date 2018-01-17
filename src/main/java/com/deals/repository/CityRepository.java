package com.deals.repository;

import com.deals.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("cityRepository")
public interface CityRepository extends JpaRepository<City, Long> {
    List<City> findAll();
}
