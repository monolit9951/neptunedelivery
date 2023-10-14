package com.gmail.merikbest2015.ecommerce.dto.products.response;

import com.gmail.merikbest2015.ecommerce.dto.order.request.ClientInfo;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FullProductResponse {

    private Long id;
    private ClientInfo clientInfo;
    private String nameRu;
    private String nameEn;
    private String nameUa;
    private Integer price;
    private String description;
    private String descriptionRu;
    private String descriptionEn;
    private String descriptionUa;
    private Integer categoryId;
    private Integer allergensId;
    private Double weight;
    private String url;
    private String img;
    private Integer status;
    private Integer size;
    private Integer sale;
    private Integer cartCount;
    private Integer sort;
    private Integer box;
}
