package com.egen.repository;

import com.egen.model.entity.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;
@Repository
@Transactional
public class orderRepositoryImpl implements orderRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public List<Order> getAllOrders()
    {
        TypedQuery q1=entityManager.createNamedQuery("Order.getAll",Order.class);
        return q1.getResultList();
    }

    public List<Order> getOrderById(String id)
    {
        return (List<Order>) entityManager.find(Order.class,id);

    }
    public List<Order> getAllOrdersWithInInterval(ZonedDateTime startTime, ZonedDateTime endTime)
    {
        TypedQuery q1=entityManager.createNamedQuery("Order.getAllOrdersWithInInterval",Order.class);
        q1.setParameter("paramStart",startTime);
        q1.setParameter("paramEnd",endTime);
        return q1.getResultList();
    }
    public List<Order> top10OrdersWithHighestDollarAmountInZip(String zip)
    {
        Query q1=entityManager.createQuery("select ord from Order ord inner join Address adr on ord.shippingAddress=adr.AddressId group by adr.zipcode having adr.zipcode=:param1 order by ord.totalAmount desc").setParameter("param1",zip);
        List<Order> l1= q1.getResultList();
        if(l1.size()<=10){
            return l1;
        }
        else{
            LinkedList<Order> l2=new LinkedList<>();
            for(int i=0;i<10;i++){
                l2.add(l1.get(i));
            }
            return l2;
        }
    }
    public Order placeOrder(Order order)
    {
        entityManager.persist(order);
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
