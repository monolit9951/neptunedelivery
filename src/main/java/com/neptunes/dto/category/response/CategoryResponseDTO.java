package com.neptunes.dto.category.response;

import com.neptunes.domain.Discount;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryResponseDTO {
    private Long id;
    private String name;
    private String nameUa;
    private String nameRu;
    private String nameEn;
    private String url;
    private String img;
    private Discount discount;
}