package com.gmail.merikbest2015.ecommerce.mapper;

import com.gmail.merikbest2015.ecommerce.dto.voucher.response.VoucherResponseDTO;
import com.gmail.merikbest2015.ecommerce.service.VoucherService;
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
