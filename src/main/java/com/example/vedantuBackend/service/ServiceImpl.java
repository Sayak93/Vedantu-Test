package com.example.vedantuBackend.service;

import com.example.vedantuBackend.models.Orders;
import com.example.vedantuBackend.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;


@org.springframework.stereotype.Service("Service")
public class ServiceImpl implements Service {

    @Autowired
    private Repo repo;

    @Override
    public boolean placeOrder(Orders payload){
        return repo.placeOrder(payload);
    }

}
