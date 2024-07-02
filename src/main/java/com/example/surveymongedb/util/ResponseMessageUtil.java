package com.example.surveymongedb.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseMessageUtil {

    public static ResponseEntity<String> createSuccessMessage(String message) {
        return ResponseEntity.ok(message);
    }

    public static ResponseEntity<String> createFailureMessage(String message) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
    }

    public static ResponseEntity<String> createNotFoundMessage(String message) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    public static ResponseEntity<?> createSuccessResponse(Object body) {
        return ResponseEntity.ok(body);
    }

    public static ResponseEntity<String> createCustomMessage(HttpStatus status, String message) {
        return ResponseEntity.status(status).body(message);
    }
}