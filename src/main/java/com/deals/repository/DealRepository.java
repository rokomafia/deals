package com.deals.repository;

import com.deals.model.Deal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("dealRepository")
public interface DealRepository extends JpaRepository<Deal, Long> {
    Deal findByName(String name);
    List<Deal> findAll();
}
