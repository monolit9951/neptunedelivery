create sequence discount_id_seq start 54 increment 1;
CREATE TABLE discount
(
    id                      int8 not null,
    discount_per_quantity   text,
    discount_type           varchar(255),
    relation_id             int8 not null,
    primary key (id)
);

ALTER TABLE product
    ADD COLUMN discount_id int8;

ALTER TABLE category
    ADD COLUMN discount_id int8;