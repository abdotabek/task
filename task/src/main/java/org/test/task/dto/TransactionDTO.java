package org.test.task.dto;

import jakarta.validation.constraints.NotNull;

import java.util.Collections;
import java.util.List;

public class TransactionDTO {
    @NotNull
    private Long userId;

    @NotNull
    private List<Integer> productIds;
    @NotNull
    private Long customerId;

    public @NotNull List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(@NotNull List<Integer> productIds) {
        this.productIds = productIds;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public @NotNull Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

}
