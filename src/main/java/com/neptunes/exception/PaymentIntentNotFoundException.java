package com.neptunes.exception;

public class PaymentIntentNotFoundException extends RuntimeException {
    public PaymentIntentNotFoundException(String message) {
        super(message);
    }
}
