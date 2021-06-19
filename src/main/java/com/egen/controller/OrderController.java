package com.egen.controller;

import com.egen.model.entity.Order;
import com.egen.service.orderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")

public class OrderController {
    /**
     * implement the following endpoints
     */
    @Autowired
    public orderService ordService;

    public ResponseEntity<List<Order>> getAllOrders(){
        //TODO
        List<Order> ord=ordService.getAllOrders();
        return ResponseEntity.ok(ord);
    }

    public ResponseEntity<List<Order>> getOrderById(String id){
        List<Order> ord=ordService.getOrderById(id);
        return ResponseEntity.ok(ord);
    }

    public ResponseEntity<List<Order>> getAllOrdersWithInInterval(ZonedDateTime startTime, ZonedDateTime endTime){
        //TODO
        List<Order> ord=ordService.getAllOrdersWithInInterval(startTime,endTime);
        return ResponseEntity.ok(ord);
    }

    public ResponseEntity<List<Order>> top10OrdersWithHighestDollarAmountInZip(String zip){
        //TODO
        List<Order> ord=ordService.top10OrdersWithHighestDollarAmountInZip(zip);
        return ResponseEntity.ok(ord);
    }

    public ResponseEntity<Order> placeOrder(Order order){

        return ResponseEntity.ok(ordService.placeOrder(order));
    }

    public ResponseEntity<Order> cancelOrder(Order order){
        return ResponseEntity.ok(ordService.cancelOrder(order));
    }

    public ResponseEntity<Order> updateOrder(Order order){
        return ResponseEntity.ok(ordService.updateOrder(order));
    }
}
