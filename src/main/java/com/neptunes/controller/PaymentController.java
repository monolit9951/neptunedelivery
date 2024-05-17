package com.neptunes.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.neptunes.service.PaymentService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.checkout.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/{id}")
    public PaymentIntent retrievePaymentIntent(@PathVariable String id) throws StripeException {
        return paymentService.retrievePaymentIntent(id);
    }

    @PostMapping("/webhook")
    public ResponseEntity<String> handleStripeWebhook(@RequestBody String payload, @RequestHeader("Stripe-Signature") String sigHeader) throws StripeException, JsonMappingException {
        paymentService.processStripeWebhook(payload, sigHeader);
        return ResponseEntity.ok().build();
    }
}
