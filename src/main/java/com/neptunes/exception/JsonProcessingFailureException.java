package com.neptunes.exception;

public class JsonProcessingFailureException extends RuntimeException {
    public JsonProcessingFailureException(String message, Throwable cause) {
        super(message, cause);
    }
    public JsonProcessingFailureException(String message) {
        super(message);
    }
}
