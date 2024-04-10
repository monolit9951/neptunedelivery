package com.gmail.merikbest2015.ecommerce.controller;


import com.gmail.merikbest2015.ecommerce.dto.voucher.response.VoucherResponseDTO;
import com.gmail.merikbest2015.ecommerce.mapper.VoucherMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping( "/api/vouchers" )
public class VoucherController {

    private final VoucherMapper voucherMapper;


    @PostMapping( "/validate" )
    public ResponseEntity<VoucherResponseDTO> validateVoucher( @RequestBody @Valid VoucherRequest voucherRequest ) {
        VoucherResponseDTO response = voucherMapper.validateVoucher( voucherRequest.getVoucherKey() );
        return ResponseEntity.ok( response );
    }


    @PostMapping( "/activate" )
    public ResponseEntity<VoucherResponseDTO> activateVoucher( @RequestBody @Valid VoucherRequest voucherRequest ) {
        VoucherResponseDTO response = voucherMapper.activateVoucher( voucherRequest.getVoucherKey() );
        return ResponseEntity.ok( response );
    }
}
