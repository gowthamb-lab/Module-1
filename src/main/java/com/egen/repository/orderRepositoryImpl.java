package com.egen.repository;

import com.egen.model.entity.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.time.ZonedDateTime;
import java.util.List;
@Repository
public class orderRepositoryImpl implements orderRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public List<Order> getAllOrders()
    {
        TypedQuery<Order> query;
        query = entityManager.createQuery("Order.getAllOrders",Order.class);
        return query.getResultList();
    }

    public List<Order> getOrderById(String id)
    {
        return (List<Order>) entityManager.find(Order.class,id);
    }
    public List<Order> getAllOrdersWithInterval(ZonedDateTime startTime, ZonedDateTime endTime)
    {
        TypedQuery<Order> query=entityManager.createQuery("Order.getAllOrdersWithInterval",Order.class);
        //query.setParameter(param1,startTime);
        //query.setParameter(param2, endTime);
        return null;
    }
    public List<Order> top100OrdersWithHighestDollarAmountInZip(String zip)
    {
    return null;
    }
    public Order placeOrder(Order order)
    {   entityManager.persist(order);
        return order;
    }

    public Order cancelOrder(Order order)
    {
        entityManager.remove(order);
        return order;
    }

    public Order updateOrder(Order order)
    {
        entityManager.merge(order);
        return order;
    }

}
