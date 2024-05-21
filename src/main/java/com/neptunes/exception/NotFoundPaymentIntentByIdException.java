package com.neptunes.exception;

public class NotFoundPaymentIntentByIdException extends RuntimeException {
    public NotFoundPaymentIntentByIdException(String message) {
        super(message);
    }
}
