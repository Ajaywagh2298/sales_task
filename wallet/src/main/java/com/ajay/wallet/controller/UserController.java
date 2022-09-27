package com.ajay.wallet.controller;

import com.ajay.wallet.exception.InvalidCredentialsException;
import com.ajay.wallet.exception.UserAlreadyRegisteredException;
import com.ajay.wallet.exception.UserNotRegisteredException;
import com.ajay.wallet.exception.WalletNotEmptyException;
import com.ajay.wallet.model.User;
import com.ajay.wallet.rest.request.CreateUserRequest;
import com.ajay.wallet.rest.request.LoginRequest;
import com.ajay.wallet.service.TransactionService;
import com.ajay.wallet.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
public class UserController implements BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    private final TransactionService transactionService;

    @Autowired
    public UserController(UserService userService, TransactionService transactionService) {
        this.userService = userService;
        this.transactionService = transactionService;
    }

    @PostMapping("/users")
    public ResponseEntity<User> create(@Valid @RequestBody CreateUserRequest user) throws UserAlreadyRegisteredException {
        User createdUser = userService.create(new User(user.getFirstName(), user.getLastName(), user.getMobile(), user.getEmail(), user.getPassword()));

        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> list() {
        return ResponseEntity.ok(userService.list());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId) throws UserNotRegisteredException {
        return ResponseEntity.ok(userService.getById(userId));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@Valid @RequestBody LoginRequest request) throws InvalidCredentialsException, UserNotRegisteredException {
        return ResponseEntity.ok(userService.login(request.getEmail(), request.getPassword()));
    }

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId) throws UserNotRegisteredException, WalletNotEmptyException {
        User user = userService.getById(userId);
        if( user.getWallet().getBalance() > 0) {
            throw new WalletNotEmptyException();
        } else {
            transactionService.deleteTransactionsByWalletId(user.getWallet());
            userService.delete(userId);
            return ResponseEntity.noContent().build();
        }
    }
}
