package com.egen.model.entity;

import com.egen.model.statics.DeliveryType;
import com.egen.model.statics.OrderStatus;

import javax.persistence.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;
@Entity
@NamedQueries({
        @NamedQuery(name="Order.getAll",query="select ord from Order ord"),
        @NamedQuery(name="Order.getAllOrdersWithInInterval",query="select ord from Order ord where ord.ordered_time>:paramStart and ord.ordered_time<:paramEnd"),
})
public class Order {
    @Id
    @Column(columnDefinition = "varchar36")
    private  String id;

    private String order_id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private String customerId;

    private double subTotal;

    private double tax;

    private double totalAmount;

    @OneToOne
    private Address shippingAddress;

    @Enumerated(EnumType.STRING)
    private DeliveryType deliveryType;

    @OneToMany
    private Set<Payment> paymentDetails;

    private ZonedDateTime ordered_time;

    @OneToOne
    private Customer Cust;

    public Order() {
        this.id = UUID.randomUUID().toString();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Set<Payment> getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(Set<Payment> paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public ZonedDateTime getOrdered_time() {
        return ordered_time;
    }

    public void setOrdered_time(ZonedDateTime ordered_time) {
        this.ordered_time = ordered_time;
    }

    public Customer getCust() {
        return Cust;
    }

    public void setCust(Customer cust) {
        Cust = cust;
    }
}
