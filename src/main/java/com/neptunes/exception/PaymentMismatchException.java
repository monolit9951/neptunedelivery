package com.neptunes.exception;

public class PaymentMismatchException extends RuntimeException {
    public PaymentMismatchException(String message) {
        super(message);
    }
}
