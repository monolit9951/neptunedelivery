package com.neptunes.dto.products.response;

import com.neptunes.domain.Discount;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductResponseDTO {

    private Long id;
    private String name;
    private String nameRu;
    private String nameEn;
    private String nameUa;
    private Integer price;
    private Long categoryId;
    private Integer allergensId;
    private Double weight;
    private String url;
    private String img;
    private Integer status;
    private String description;
    private String descriptionRu;
    private String descriptionEn;
    private String descriptionUa;
    private Integer size;
    private Integer sale;
    private Integer cartCount;
    private Integer sort;
    private Integer box;
    private Discount discount;
}
