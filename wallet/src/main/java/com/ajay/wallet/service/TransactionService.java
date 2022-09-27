package com.ajay.wallet.service;

import com.ajay.wallet.model.Transaction;
import com.ajay.wallet.model.Wallet;
import com.ajay.wallet.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private TransactionRepository repository;

    @Autowired
    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public Transaction create(Transaction transaction) {
        return repository.save(transaction);
    }

    public Iterable<Transaction> listTransactionsByWalletId(Long walletId) {
        return repository.listTransactionsByWalletId(walletId);
    }

    public void deleteTransactionsByWalletId(Wallet wallet) {
        repository.deleteTransactionsByWalletId(wallet);
    }
}
