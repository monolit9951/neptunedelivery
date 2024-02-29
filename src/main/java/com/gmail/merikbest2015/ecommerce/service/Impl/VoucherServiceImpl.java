package com.gmail.merikbest2015.ecommerce.service.Impl;

import com.gmail.merikbest2015.ecommerce.domain.Voucher;
import com.gmail.merikbest2015.ecommerce.exception.ApiRequestException;
import com.gmail.merikbest2015.ecommerce.repository.VoucherRepository;
import com.gmail.merikbest2015.ecommerce.service.VoucherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.Instant;

import static com.gmail.merikbest2015.ecommerce.constants.ErrorMessage.VOUCHER_IS_EXPIRED;
import static com.gmail.merikbest2015.ecommerce.constants.ErrorMessage.VOUCHER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class VoucherServiceImpl implements VoucherService {

    private final VoucherRepository voucherRepository;

    @Override
    public Voucher validateVoucher(String voucherKey) {
        Voucher voucher = voucherRepository.findVoucherByCode(voucherKey).orElseThrow(() -> new ApiRequestException(VOUCHER_NOT_FOUND, HttpStatus.NOT_FOUND));
        if(voucher.getQuantityOfUse() == 0 || voucher.getDateUntilValid().isBefore(Instant.now())){
            voucherRepository.delete(voucher);
            throw new ApiRequestException(VOUCHER_IS_EXPIRED, HttpStatus.NOT_FOUND);
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
