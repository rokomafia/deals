package com.deals.service;

import com.deals.model.Deal;
import com.deals.repository.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dealService")
public class DealServiceImpl implements DealService {

    @Autowired
    private DealRepository dealRepository;

    @Override
    public Deal findDealByName(String name) {
        return dealRepository.findByName(name);
    }

    @Override
    public void saveDeal(Deal deal) {
        dealRepository.save(deal);
    }

}
