package com.gmail.merikbest2015.ecommerce.service;

import com.gmail.merikbest2015.ecommerce.domain.Voucher;

public interface VoucherService {
    Voucher validateVoucher(String voucherKey);

    Voucher activateVoucher(String voucherKey);
}
