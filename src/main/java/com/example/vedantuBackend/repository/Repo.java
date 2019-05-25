package com.example.vedantuBackend.repository;


import com.example.vedantuBackend.models.Orders;

public interface Repo {

    boolean placeOrder(Orders payload);

}
