package com.egen.model.entity;

import javax.persistence.Id;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

public class payment {
    @Id
    private String paymentId;
    private ZonedDateTime payment_time;

    private enum paymentMethod{
        credit_card,debit_card,payPal,googlePay;
    }

    public payment()
    {
        this.paymentId= UUID.randomUUID().toString();
        this.payment_time=ZonedDateTime.now(ZoneId.of("UTC"));
    }



    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public ZonedDateTime getPayment_time() {
        return payment_time;
    }

    public void setPayment_time(ZonedDateTime payment_time) {
        this.payment_time = payment_time;
    }



}
