package com.neptunes.mapper;

import com.neptunes.dto.voucher.response.VoucherResponseDTO;
import com.neptunes.service.VoucherService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VoucherMapper {

    private final CommonMapper commonMapper;

    private final VoucherService voucherService;

    public VoucherResponseDTO validateVoucher(String voucherKey) {
        return commonMapper.convertToResponse(voucherService.validateVoucher(voucherKey), VoucherResponseDTO.class);
    }

    public VoucherResponseDTO activateVoucher(String voucherKey) {
        return commonMapper.convertToResponse(voucherService.activateVoucher(voucherKey), VoucherResponseDTO.class);
    }
}
