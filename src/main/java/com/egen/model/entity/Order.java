package com.egen.model.entity;

import javax.persistence.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;
@Entity
@NamedQueries({
        @NamedQuery(name = "Order.getAllOrders", query = "Select ord from Order ord"),
        @NamedQuery(name="Order.getAllOrdersWithInterval",query ="select ord from Order ord where ord.ordered_time >:param1 and ord.ordered_time <:param2")


})
public class Order {
    @Id
    @Column(columnDefinition = "varchar36")
    private  String id;
    @ManyToOne
    private Customer Cust;
    @OneToOne
    private payment pay;
    private ZonedDateTime ordered_time;

    public Order(String id) {
        this.id = UUID.randomUUID().toString();
        this.ordered_time=ZonedDateTime.now(ZoneId.of("UTC"));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCust() {
        return Cust;
    }

    public void setCust(Customer cust) {
        Cust = cust;
    }

    public payment getPay() {
        return pay;
    }

    public void setPay(payment pay) {
        this.pay = pay;
    }

    public ZonedDateTime getOrdered_time() {
        return ordered_time;
    }

    public void setOrdered_time(ZonedDateTime ordered_time) {
        this.ordered_time = ordered_time;
    }
}
