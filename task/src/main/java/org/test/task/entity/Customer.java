package org.test.task.entity;

import jakarta.persistence.*;
import org.test.task.enums.MarketType;

@Entity
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private MarketType marketType;

    public Customer(String name, MarketType marketType) {
        this.name = name;
        this.marketType = marketType;
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(Long customerId) {
        this.id = customerId;
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MarketType getMarketType() {
        return marketType;
    }

    public void setMarketType(MarketType marketType) {
        this.marketType = marketType;
    }
}
