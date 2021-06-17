package com.egen.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Customer {
    @Id
    @Column(columnDefinition = "varchar(36)")
    private String customerId;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private String phone_no;
    @OneToMany
    private List<Address> shippingAddress;
    @OneToMany
    private List<Address> billingAddress;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public List<Address> getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(List<Address> shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public List<Address> getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(List<Address> billingAddress) {
        this.billingAddress = billingAddress;
    }
}
