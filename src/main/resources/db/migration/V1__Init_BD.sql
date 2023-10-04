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
    city_id        int8,
    size           int4,
    sale           int4,
    iiko_id uuid,
    cart_count     int4,
    sort           int4,
    box            int4,
    removal_date   TIMESTAMP WITHOUT TIME ZONE,
    primary key (id)
);

create sequence order_id_seq start 6 increment 1;
CREATE TABLE orders
(
    id               int8 not null,
    to_date          TIMESTAMP WITHOUT TIME ZONE,
    to_time          TIMESTAMP WITHOUT TIME ZONE,
    first_name       varchar(255),
    phone_number     varchar(255),
    city_id          int8,
    street           varchar(255),
    house_number     varchar(255),
    house_entrance   varchar(255),
    house_floor      varchar(255),
    apartment_number varchar(255),
    post_index       int4,
    comment          varchar(255),
    people_quantity  int4,
    cart_items       json,
    study_quantity   int4,
    simple_quantity  int4,
    delivery_type    varchar(255),
    payment_type     varchar(255),
    removal_date     TIMESTAMP WITHOUT TIME ZONE,
    primary key (id)
);
