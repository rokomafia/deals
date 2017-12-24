package com.deals.service;

import com.deals.model.Deal;

public interface DealService {
    public Deal findDealByName(String name);
    public void saveDeal(Deal deal);
}
