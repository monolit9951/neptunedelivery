package com.neptunes.dto.payment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.stripe.model.PaymentIntent;
import lombok.Data;

@Data
public class StripeEventData {
    @JsonProperty("id")
    private String id;

    @JsonProperty("object")
    private String object;

    @JsonProperty("api_version")
    private String apiVersion;

    @JsonProperty("created")
    private Long created;

    @JsonProperty("data")
    private PaymentIntent paymentIntent;
}
