package com.neptunes.controller;

import javax.validation.constraints.NotEmpty;

import lombok.Data;


@Data
public class VoucherRequest {

    @NotEmpty
    private String voucherKey;
}
