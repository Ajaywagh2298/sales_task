package com.ajay.wallet.rest.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class LoginRequest implements Serializable {
    @Email(message = "invalid email format")
    @NotNull(message = "email is required")
    private String email;

    @NotBlank(message = "password is required")
    @NotNull(message = "password is required")
    @Size(min = 8, message = "password must have at least 8 characters")
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
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
}
