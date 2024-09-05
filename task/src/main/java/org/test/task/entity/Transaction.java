package org.test.task.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
public class Transaction {
    @Id
    @UuidGenerator
    private String id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Customer customer;

    @Column
    private Long amount;

    @Column
    private Long cashbackAmount;

    @ManyToMany
    private List<Product> products;


    public Transaction(User user,Customer customer, Long amount, Long cashbackAmount, List<Product> products) {
        this.user = user;
        this.customer = customer;
        this.amount = amount;
        this.cashbackAmount = cashbackAmount;
        this.products = products;
    }

    public Transaction() {

    }

    public String getId() {
        return id;
    }


    public User getUser() {
        return user;
    }

    public Long getAmount() {
        return amount;
    }

    public Long getCashbackAmount() {
        return cashbackAmount;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
