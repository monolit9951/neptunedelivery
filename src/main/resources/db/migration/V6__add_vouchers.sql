create sequence voucher_id_seq start 12 increment 1;
CREATE TABLE voucher
(
    id                      int8 not null,
    code                    varchar(255) UNIQUE,
    date_until_valid        TIMESTAMP WITHOUT TIME ZONE,
    quantity_of_use         int,
    discount_percentage     numeric(19, 2),
    removal_date            TIMESTAMP WITHOUT TIME ZONE,
    primary key (id)
);
