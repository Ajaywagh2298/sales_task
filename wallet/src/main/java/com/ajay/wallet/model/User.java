package com.ajay.wallet.model;

import com.ajay.wallet.common.Constants;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = Constants.USER_ID, unique = true, nullable = false)
    private String userId;

    @Column(name = Constants.FIRST_NAME, nullable = false)
    private String firstName;

    @Column(name = Constants.LAST_NAME, nullable = false)
    private String lastName;

    @Column(name = Constants.MOBILE, nullable = false)
    private String mobile;

    @Column(name = Constants.EMAIL, unique = true, nullable = false)
    private String email;

    @Column(name = Constants.PASSWORD, nullable = false)
    @JsonIgnore
    private String password;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Wallet wallet;

    public User() {
    }

    public User(String firstName, String lastName, String mobile, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.wallet = new Wallet();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}