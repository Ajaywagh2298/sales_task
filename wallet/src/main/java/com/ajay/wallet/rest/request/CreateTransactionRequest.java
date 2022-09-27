package com.ajay.wallet.rest.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

public class CreateTransactionRequest implements Serializable {

    @NotNull(message = "amount is required")
    @Positive
    private double amount;

    private String description;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
