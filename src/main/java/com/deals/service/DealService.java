package com.deals.service;

import com.deals.model.Deal;

import java.util.List;

public interface DealService {
    public Deal findDealByName(String name);
    public void saveDeal(Deal deal);
    public List<Deal> getAll();
}
