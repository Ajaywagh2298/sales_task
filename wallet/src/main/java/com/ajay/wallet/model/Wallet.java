package com.ajay.wallet.model;

import com.ajay.wallet.common.Constants;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Wallet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constants.WALLET_ID, unique = true, nullable = false)
    private Long walletId;

    @Column(name = Constants.BALANCE, nullable = false)
    private double balance;

    public Wallet() {
        this.balance = 0.0;
    }

    public Long getWalletId() {
        return walletId;
    }

    public void setWalletId(Long walletId) {
        this.walletId = walletId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
