package com.neptunes.service;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.stripe.model.checkout.Session;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.http.ResponseEntity;

public interface PaymentService {
//        Session createPaymentSession(String OrderId) throws StripeException;

        PaymentIntent retrievePaymentIntent(String id);

        void processStripeWebhook(String payload, String sigHeader);
}
