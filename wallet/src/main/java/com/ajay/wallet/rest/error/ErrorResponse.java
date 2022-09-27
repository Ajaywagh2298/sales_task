package com.ajay.wallet.rest.error;

import java.util.Set;
import java.util.stream.Collectors;

public class ErrorResponse {
    private int code;
    private String message;
    private String description;

    public ErrorResponse() {
    }

    public ErrorResponse(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }

    public ErrorResponse(int code, String message, Set<String> description) {
        this.code = code;
        this.message = message;
        this.description = description.stream().map(Object::toString).collect(Collectors.joining(", "));
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
