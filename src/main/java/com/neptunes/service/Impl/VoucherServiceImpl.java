package com.neptunes.service.Impl;

import com.neptunes.domain.Voucher;
import com.neptunes.exception.ApiRequestException;
import com.neptunes.repository.VoucherRepository;
import com.neptunes.service.VoucherService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;

import static com.neptunes.constants.ErrorMessage.VOUCHER_IS_EXPIRED;
import static com.neptunes.constants.ErrorMessage.VOUCHER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class VoucherServiceImpl implements VoucherService {

    private final VoucherRepository voucherRepository;

    @Override
    public Voucher validateVoucher(String voucherKey) {
        Voucher voucher = voucherRepository.findVoucherByCode(voucherKey).orElseThrow(() -> new ApiRequestException(VOUCHER_NOT_FOUND, HttpStatus.NOT_FOUND));
        if(voucher.getQuantityOfUse() == 0 || voucher.getDateUntilValid().isBefore(Instant.now())){
            voucherRepository.delete(voucher);
            throw new ApiRequestException(VOUCHER_IS_EXPIRED, HttpStatus.GONE);
        }
        return voucher;
    }

    @Override
    public Voucher activateVoucher(String voucherKey) {
        Voucher voucher = voucherRepository.findVoucherByCode(voucherKey).orElseThrow(() -> new ApiRequestException(VOUCHER_NOT_FOUND, HttpStatus.NOT_FOUND));
        voucher.setQuantityOfUse(voucher.getQuantityOfUse() - 1);
        if(voucher.getQuantityOfUse() == 0) {
            voucherRepository.delete(voucher);
        } else {
            voucherRepository.save(voucher);
        }
        return voucher;
    }
}
