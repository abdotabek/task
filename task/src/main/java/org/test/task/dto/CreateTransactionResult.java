package org.test.task.dto;

import org.test.task.entity.Customer;
import org.test.task.entity.Product;

import java.util.List;

public class CreateTransactionResult {
    private String transactionId;
    private Long amount;
    private Long cashbackAmount;
    private List<Product> products;
    private Long userId;
    private Long customerId;

    public CreateTransactionResult(String transactionId, Long amount,
                                   Long cashbackAmount, List<Product> products, Long userId,Long customerId) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.cashbackAmount = cashbackAmount;
        this.products = products;
        this.userId = userId;
        this.customerId = customerId;
    }


    public String getTransactionId() {
        return transactionId;
    }

    public Long getAmount() {
        return amount;
    }

    public Long getCashbackAmount() {
        return cashbackAmount;
    }


    public Long getUserId() {
        return userId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
