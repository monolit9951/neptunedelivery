package com.neptunes.service;

import com.neptunes.domain.Voucher;


public interface VoucherService {
    Voucher validateVoucher(String voucherKey);

    Voucher activateVoucher(String voucherKey);
}
