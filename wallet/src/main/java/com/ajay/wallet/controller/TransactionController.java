package com.ajay.wallet.controller;

import com.ajay.wallet.exception.UserNotRegisteredException;
import com.ajay.wallet.model.Transaction;
import com.ajay.wallet.model.TransactionType;
import com.ajay.wallet.model.User;
import com.ajay.wallet.model.Wallet;
import com.ajay.wallet.rest.request.CreateTransactionRequest;
import com.ajay.wallet.service.TransactionService;
import com.ajay.wallet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
public class TransactionController implements BaseController {
    private final UserService userService;
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(UserService userService, TransactionService transactionService) {
        this.userService = userService;
        this.transactionService = transactionService;
    }

    @PostMapping("/users/{userId}/transactions/credit")
    public Transaction addAmount(@Valid @RequestBody CreateTransactionRequest request, @PathVariable String userId) throws UserNotRegisteredException {
        User user = userService.getById(userId);
        Wallet wallet = user.getWallet();
        Double postBalance = wallet.getBalance() + request.getAmount();
        wallet.setBalance(postBalance);
        Transaction transaction = new Transaction(TransactionType.CREDIT, request.getAmount(), postBalance, request.getDescription(), wallet);

        return transactionService.create(transaction);
    }

    @PostMapping("/users/{userId}/transactions/debit")
    public Transaction withdrawAmount(@Valid @RequestBody CreateTransactionRequest request, @PathVariable String userId) throws UserNotRegisteredException {
        User user = userService.getById(userId);
        Wallet wallet = user.getWallet();
        Double postBalance = wallet.getBalance() - request.getAmount();
        wallet.setBalance(postBalance);
        Transaction transaction = new Transaction(TransactionType.DEBIT, request.getAmount(), postBalance, request.getDescription(), wallet);

        return transactionService.create(transaction);
    }

    @GetMapping("/users/{userId}/transactions")
    public Iterable<Transaction> listTransactions(@PathVariable String userId) throws UserNotRegisteredException {
        User user = userService.getById(userId);
        return transactionService.listTransactionsByWalletId(user.getWallet().getWalletId());
    }
}
