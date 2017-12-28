package com.deals.service;

import com.deals.model.Deal;
import com.deals.repository.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Deal> getAll(){
        return dealRepository.findAll();
    }

    @Override
    public Deal findDealById(Long id){
        return dealRepository.findOne(id);
    }

}
