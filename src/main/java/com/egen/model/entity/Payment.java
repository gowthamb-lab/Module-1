package com.egen.model.entity;


import com.egen.model.statics.PaymentType;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Payment {
    @Id
    private String paymentId;

    private double paidAmount;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @OneToOne
    private Address billingAddress;

    public Payment()
    {

        paymentId= UUID.randomUUID().toString();
    }


    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }
}
