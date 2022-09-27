package com.ajay.wallet.controller;

import com.ajay.wallet.exception.InvalidCredentialsException;
import com.ajay.wallet.exception.UserAlreadyRegisteredException;
import com.ajay.wallet.exception.UserNotRegisteredException;
import com.ajay.wallet.exception.WalletNotEmptyException;
import com.ajay.wallet.rest.error.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashSet;
import java.util.Set;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler implements BaseController {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Set<String> errors = new HashSet<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.add(error.getField() + ": " + error.getDefaultMessage());
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
        }

        ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "validation error", errors);

        return badRequest(error);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorResponse> handleInvalidCredentials(Exception ex, WebRequest request) {
        ErrorResponse errors = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(), "unauthorized", ex.getMessage());
        return unauthorized(errors);
    }

    @ExceptionHandler(UserNotRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleUserNotRegistered(Exception ex, WebRequest request) {
        ErrorResponse errors = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "not found", ex.getMessage());
        return notFound(errors);
    }

    @ExceptionHandler(UserAlreadyRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleUserAlreadyRegistered(Exception ex, WebRequest request) {
        ErrorResponse errors = new ErrorResponse(HttpStatus.CONFLICT.value(), "duplicate user", ex.getMessage());
        return conflict(errors);
    }

    @ExceptionHandler(WalletNotEmptyException.class)
    public ResponseEntity<ErrorResponse> handleWalletNotEmptyException(Exception ex, WebRequest request) {
        ErrorResponse errors = new ErrorResponse(HttpStatus.OK.value(), "not allowed", ex.getMessage());
        return conflict(errors);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleInternalServerError(Exception ex, WebRequest request) {
        ErrorResponse errors = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "internal error", ex.getMessage());
        return internalServerError(errors);
    }

}