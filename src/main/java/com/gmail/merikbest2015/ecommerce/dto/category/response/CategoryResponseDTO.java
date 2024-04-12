package com.gmail.merikbest2015.ecommerce.dto.category.response;

import com.gmail.merikbest2015.ecommerce.domain.Discount;
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