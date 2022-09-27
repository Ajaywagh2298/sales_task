package com.ajay.wallet.service;

import com.ajay.wallet.exception.InvalidCredentialsException;
import com.ajay.wallet.exception.UserAlreadyRegisteredException;
import com.ajay.wallet.exception.UserNotRegisteredException;
import com.ajay.wallet.model.User;
import com.ajay.wallet.repository.UserRepository;
import com.ajay.wallet.utils.PasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    public User create(User user) throws UserAlreadyRegisteredException {
        Optional<User> dbUser = repository.findById(user.getEmail());
        if (dbUser.isPresent()) {
            throw new UserAlreadyRegisteredException(String.format("user with email %s is already registered", user.getEmail()));
        }

        String encoded = passwordEncoder.encoder().encode(user.getPassword());
        user.setPassword(encoded);
        return repository.save(user);
    }

    public User login(String email, String password) throws InvalidCredentialsException, UserNotRegisteredException {
        Optional<User> user = Optional.ofNullable(repository.getUserByEmail(email));
        if (user.isPresent()) {
            if (passwordEncoder.encoder().matches(password, user.get().getPassword())) {
                return user.get();
            } else {
                throw new InvalidCredentialsException();
            }
        } else {
            throw new UserNotRegisteredException();
        }
    }

    public Iterable<User> list() {
        return repository.findAll();
    }

    public User getById(String userId) throws UserNotRegisteredException {
        Optional<User> user = repository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotRegisteredException();
        }
    }

    public void delete(String userId) {
        Optional<User> user = repository.findById(userId);
        user.ifPresent(repository::delete);
    }
}
