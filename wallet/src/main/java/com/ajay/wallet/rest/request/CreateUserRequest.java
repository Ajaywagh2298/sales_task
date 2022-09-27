package com.ajay.wallet.rest.request;

import javax.validation.constraints.*;
import java.io.Serializable;

public class CreateUserRequest implements Serializable {

    @NotBlank(message = "first name is required")
    @NotNull(message = "first name is required")
    private String firstName;

    @NotBlank(message = "last name is required")
    @NotNull(message = "last name is required")
    private String lastName;

    @NotBlank(message = "mobile is required")
    @NotNull(message = "mobile is required")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "mobile number must have 10 digits")
    private String mobile;

    @Email(message = "invalid email format")
    @NotNull(message = "email is required")
    private String email;

    @NotBlank(message = "password is required")
    @NotNull(message = "password is required")
    @Size(min = 8, message = "password must have at least 8 characters")
    private String password;

    public CreateUserRequest() {
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
}
