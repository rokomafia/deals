package com.deals.repository;

import com.deals.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findAll();
}
