package com.egen.service;

import com.egen.exceptions.OrderNotFoundException;
import com.egen.model.entity.Order;
import com.egen.repository.orderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class orderServiceImpl implements orderService{

    @Autowired
    private orderRepository orderRepo;

    @Override
    public List<Order> getAllOrders() {
        List<Order> l1= orderRepo.getAllOrders();
        if(l1.size()==0){
            throw new OrderNotFoundException("No order is available");
        }
        else {
            return l1;
        }
    }

    @Override
    public List<Order> getOrderById(String id) {
        List<Order> l1= orderRepo.getOrderById(id);
        if(l1.size()==0){
            throw new OrderNotFoundException("No order is available");
        }
        else {
            return l1;
        }
    }

    @Override
    public List<Order> getAllOrdersWithInInterval(ZonedDateTime startTime, ZonedDateTime endTime) {
        List<Order> l1= orderRepo.getAllOrdersWithInInterval(startTime,endTime);
        if(l1.size()==0){
            throw new OrderNotFoundException("No order is available");
        }
        else {
            return l1;
        }
    }

    @Override
    public List<Order> top10OrdersWithHighestDollarAmountInZip(String zip) {
        return null;
    }

    @Override
    public Order placeOrder(Order order) {
        return orderRepo.placeOrder(order);
    }

    @Override
    public Order cancelOrder(Order order) {
        return orderRepo.cancelOrder(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepo.updateOrder(order);
    }
}
