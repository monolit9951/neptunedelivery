package com.gmail.merikbest2015.ecommerce.dto.products.response;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FullProductResponse extends ProductResponse{
    private String description;
    private String descriptionRu;
    private String descriptionEn;
    private String descriptionUa;
}
