package com.neptunes.dto.perfume;

import lombok.Data;

import java.util.List;

@Data
public class PerfumeSearchRequest {
    private List<String> perfumers;
    private List<String> genders;
    private List<Integer> prices;
    private Boolean sortByPrice;
    private String perfumer;
    private String perfumeGender;
}
