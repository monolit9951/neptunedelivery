package com.gmail.merikbest2015.ecommerce.controller;

import javax.validation.constraints.NotEmpty;

import lombok.Data;


@Data
public class VoucherRequest {

    @NotEmpty
    private String voucherKey;
}
