package com.ajay.wallet.rest.response;

import com.ajay.wallet.model.User;
import com.ajay.wallet.model.Wallet;

public class UserResponse {
    private User user;
    private Wallet wallet;

    public UserResponse(User user, Wallet wallet) {
        this.user = user;
        this.wallet = wallet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
