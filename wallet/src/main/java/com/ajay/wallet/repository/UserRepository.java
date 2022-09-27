package com.ajay.wallet.repository;

import com.ajay.wallet.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    @Query("SELECT U FROM User U where U.email = :email")
    public User getUserByEmail(String email);
}
