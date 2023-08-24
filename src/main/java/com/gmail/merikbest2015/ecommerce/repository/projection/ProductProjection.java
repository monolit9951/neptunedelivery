package com.gmail.merikbest2015.ecommerce.repository.projection;

import java.util.UUID;


public interface ProductProjection {
    Long getId();
    String getName();
    String getNameRu();
    String getNameEn();
    String getNameUa();
    Integer getPrice();
    Integer getCategoryId();
    Integer getAllergensId();
    Double getWeight();
    String getUrl();
    String getImg();
    Integer getStatus();
    String getDescription();
    String getDescriptionRu();
    String getDescriptionEn();
    String getDescriptionUa();
    Integer getCityId();
    Integer getSize();
    Integer getSale();
    UUID getIikoId();
    Integer getCartCount();
    Integer getSort();
    Integer getBox();
}
