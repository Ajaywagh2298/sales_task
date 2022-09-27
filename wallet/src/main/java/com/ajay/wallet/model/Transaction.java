package com.ajay.wallet.model;

import com.ajay.wallet.common.Constants;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constants.TRANSACTION_ID, unique = true, nullable = false)
    private Long transactionId;

    @Column(name = Constants.TRANSACTION_TYPE, nullable = false)
    private TransactionType transactionType;

    @Column(name = Constants.TIMESTAMP)
    private Instant timestamp;

    @Column(name = Constants.AMOUNT)
    private Double amount;

    @Column(name = Constants.POST_BALANCE)
    private Double postBalance;

    @Column(name = Constants.DESCRIPTION)
    private String description;

    @ManyToOne
    @JsonIgnore
    private Wallet wallet;

    public Transaction() {
    }

    public Transaction(TransactionType transactionType, Double amount, Double postBalance, String description, Wallet wallet) {
        this.transactionType = transactionType;
        this.timestamp = Instant.now();
        this.amount = amount;
        this.postBalance = postBalance;
        this.description = description;
        this.wallet = wallet;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPostBalance() {
        return postBalance;
    }

    public void setPostBalance(Double postBalance) {
        this.postBalance = postBalance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
