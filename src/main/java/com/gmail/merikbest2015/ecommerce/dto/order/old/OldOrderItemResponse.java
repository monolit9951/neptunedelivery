package com.gmail.merikbest2015.ecommerce.dto.order.old;

import com.gmail.merikbest2015.ecommerce.dto.perfume.PerfumeResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OldOrderItemResponse {
    private Long id;
    private Long amount;
    private Long quantity;
    private PerfumeResponse perfume;
}
