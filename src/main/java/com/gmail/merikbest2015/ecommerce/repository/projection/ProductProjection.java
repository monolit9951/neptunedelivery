package com.gmail.merikbest2015.ecommerce.repository.projection;

public interface ProductProjection {
    Long getId();
    String getName();
    String getNameRu();
    String getNameEn();
    String getNameUa();
    Integer getPrice();
    Long getCategoryId();
    Integer getAllergensId();
    Double getWeight();
    String getUrl();
    String getImg();
    Integer getStatus();
    String getDescription();
    String getDescriptionRu();
    String getDescriptionEn();
    String getDescriptionUa();
    Integer getSize();
    Integer getSale();
    Integer getCartCount();
    Integer getSort();
    Integer getBox();
}
