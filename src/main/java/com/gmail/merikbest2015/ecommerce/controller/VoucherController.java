package com.gmail.merikbest2015.ecommerce.controller;


import com.gmail.merikbest2015.ecommerce.dto.voucher.response.VoucherResponseDTO;
import com.gmail.merikbest2015.ecommerce.mapper.VoucherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vouchers")
public class VoucherController {

    private final VoucherMapper voucherMapper;

    @GetMapping("/validate")
    public ResponseEntity validateVoucher(@RequestParam(name = "voucher_key") String voucherKey){
        VoucherResponseDTO response = voucherMapper.validateVoucher(voucherKey);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/activate")
    public ResponseEntity<VoucherResponseDTO> activateVoucher(@RequestParam(name = "voucher_key") String voucherKey){
        VoucherResponseDTO response = voucherMapper.activateVoucher(voucherKey);
        return ResponseEntity.ok(response);
    }
}
