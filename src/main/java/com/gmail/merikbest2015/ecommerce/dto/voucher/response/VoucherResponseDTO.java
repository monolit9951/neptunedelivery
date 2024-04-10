package com.gmail.merikbest2015.ecommerce.dto.voucher.response;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Data
public class VoucherResponseDTO {

    private String code;
    private Instant dateUntilValid;
    private Integer quantityOfUse;
    private BigDecimal discountPercentage = BigDecimal.ZERO;

}
