package com.neptunes.configuration;

import com.stripe.Stripe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class StripeConfig {

    @Value("${stripe.secretKey}")
    private String apiKey;
    @Value("${stripe.webhook}")
    private String webhookKey;

    @PostConstruct
    public void init() {
        Stripe.apiKey = apiKey;
    }

    public String getWebhookKey() {
        return webhookKey;
    }
}
