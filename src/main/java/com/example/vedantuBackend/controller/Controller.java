package com.example.vedantuBackend.controller;


import com.example.vedantuBackend.models.Orders;
import com.example.vedantuBackend.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class Controller {
    @Autowired
    private Service service;
    //add the source of your http call to cors origin
    @CrossOrigin(origins = "add origin url here")
    //default route
    @GetMapping("/")
    public String defaultGetEndpoint(){
        return "hello";
    }

    //add the source of your http call to cors origin
    @CrossOrigin(origins = "add origin url here")
    //api call binding
    @PostMapping("/placeOrder")

    //data model for incoming request is com.example.vedantuBackend.models.Orders
    public ResponseEntity<String> createOrder(@RequestBody Orders payload){

        if(service.placeOrder(payload)){
            //calling the service to execute the operations
            //success response
            return new ResponseEntity("{Response : Order placed",HttpStatus.OK);
        }else{
            //error response
            return new ResponseEntity("{Response : Order failed",HttpStatus.NO_CONTENT);
        }
    }
}
