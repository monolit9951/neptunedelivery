package com.neptunes.dto.perfume;

import com.neptunes.enums.SearchPerfume;

import lombok.Data;

@Data
public class SearchTypeRequest {
    private SearchPerfume searchType;
    private String text;
}
