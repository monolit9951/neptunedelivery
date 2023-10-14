create
    sequence product_id_seq start
    21 increment 1;

CREATE TABLE product
(
    id             int8 not null,
    name           varchar(255),
    name_ru        varchar(255),
    name_en        varchar(255),
    name_ua        varchar(255),
    price          int4,
    category_id    int4,
    allergens_id   int4,
    weight         float8,
    url            varchar(255),
    img            varchar(255),
    status         int4,
    description    varchar(255),
    description_ru varchar(255),
    description_en varchar(255),
    description_ua varchar(255),
    size           int4,
    sale           int4,
    cart_count     int4,
    sort           int4,
    box            int4,
    removal_date   TIMESTAMP WITHOUT TIME ZONE,
    primary key (id)
);

create sequence order_id_seq start 6 increment 1;
CREATE TABLE orders
(
    id                 int8         not null,
    to_date_time       TIMESTAMP WITHOUT TIME ZONE,
    client_info        json,
    delivery_address   json,
    comment            varchar(255),
    people_count       int4,
    cart_items         json,
    sticks_count       int4,
    study_sticks_count int4,
    delivery_type      varchar(255),
    payment_type       varchar(255),
    status_type        varchar(255) not null,
    removal_date       TIMESTAMP WITHOUT TIME ZONE,
    primary key (id)
);

create sequence category_id_seq start 20 increment 1;
CREATE TABLE category
(
    id         int8 not null,
    name       varchar(255),
    name_ua    varchar(255),
    name_ru    varchar(255),
    name_en    varchar(255),
    url        varchar(255),
    img        varchar(255)
);
