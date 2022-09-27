package com.ajay.wallet.exception;

public class WalletNotEmptyException extends Exception{
    public WalletNotEmptyException() {
        super("wallet not empty, withdraw amount from the wallet");
    }
}
