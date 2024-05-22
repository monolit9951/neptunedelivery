package com.neptunes.dto.order.old;

import com.neptunes.dto.perfume.PerfumeResponse;
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
