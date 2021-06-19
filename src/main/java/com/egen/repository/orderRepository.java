package com.egen.repository;

import com.egen.model.entity.Order;

import java.time.ZonedDateTime;
import java.util.List;

public interface orderRepository {
    List<Order> getAllOrders();
    List<Order> getOrderById(String id);
    List<Order> getAllOrdersWithInInterval(ZonedDateTime startTime, ZonedDateTime endTime);
    List<Order> top10OrdersWithHighestDollarAmountInZip(String zip);
    Order placeOrder(Order order);
    Order cancelOrder(Order order);
    Order updateOrder(Order order);
}
