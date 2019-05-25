package com.example.vedantuBackend.service;


import com.example.vedantuBackend.models.Orders;

public interface Service {

    boolean placeOrder(Orders payload);
}
