create sequence product_id_seq start 10 increment 1;

CREATE TABLE product (
    id                     int8 not null,
    name                   varchar(255),
    name_ru                varchar(255),
    name_en                varchar(255),
    name_ua                varchar(255),
    price                  int4,
    category_id            int4,
    allergens_id           int4,
    weight                 float8,
    url                    varchar(255),
    img                    varchar(255),
    status                 int4,
    description            varchar(255),
    description_ru         varchar(255),
    description_en         varchar(255),
    description_ua         varchar(255),
    city_id                int4,
    size                   int4,
    sale                   int4,
    iiko_id                uuid,
    cart_count             int4,
    sort                   int4,
    box                    int4,
    removal_date           TIMESTAMP WITHOUT TIME ZONE,
    primary key (id)
);