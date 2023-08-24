package com.gmail.merikbest2015.ecommerce.dto.products.response;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String name;
    private String nameRu;
    private String nameEn;
    private String nameUa;
    private Integer price;
    private Integer categoryId;
    private Integer allergensId;
    private Double weight;
    private String url;
    private String img;
    private Integer status;
    private Integer cityId;
    private Integer size;
    private Integer sale;
    private UUID iikoId;
    private Integer cartCount;
    private Integer sort;
    private Integer box;
}
