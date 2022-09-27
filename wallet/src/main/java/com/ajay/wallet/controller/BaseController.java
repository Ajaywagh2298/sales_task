package com.ajay.wallet.controller;

import com.ajay.wallet.rest.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface BaseController {
    default ResponseEntity<ErrorResponse> internalServerError(ErrorResponse e) {
        return ResponseEntity.internalServerError().body(e);
    }

    default ResponseEntity<ErrorResponse> notFound(ErrorResponse message) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    default ResponseEntity<ErrorResponse> unauthorized(ErrorResponse message) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(message);
    }

    default ResponseEntity<Object> badRequest(ErrorResponse response) {
        return ResponseEntity.badRequest().body(response);
    }

    default ResponseEntity<ErrorResponse> conflict(ErrorResponse message) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
    }
}
