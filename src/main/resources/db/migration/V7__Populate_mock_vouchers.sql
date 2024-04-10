INSERT INTO voucher (id, code, date_until_valid, quantity_of_use, discount_percentage)
VALUES  (1, 'test', '09.10.2023', 20, 0.05);
INSERT INTO voucher (id, code, date_until_valid, quantity_of_use, discount_percentage)
VALUES  (2, 'test2', '01.10.2025', 1, 0.1);
INSERT INTO voucher (id, code, date_until_valid, quantity_of_use, discount_percentage)
VALUES  (3, 'test3', '01.10.2034', 1, 0.5);
INSERT INTO voucher (id, code, date_until_valid, quantity_of_use, discount_percentage)
VALUES  (4, 'test4', '01.10.2019', 1, 0.5);
INSERT INTO voucher (id, code, date_until_valid, quantity_of_use, discount_percentage)
VALUES  (5, 'test5', '01.10.2025', 0, 0.5);
INSERT INTO voucher (id, code, date_until_valid, quantity_of_use, discount_percentage)
VALUES  (6, 'valid_50_voucher', '01.10.2025', 100000, 0.5);
INSERT INTO voucher (id, code, date_until_valid, quantity_of_use, discount_percentage)
VALUES  (7, 'valid_10_voucher', '01.10.2025', 100000, 0.1);
INSERT INTO voucher (id, code, date_until_valid, quantity_of_use, discount_percentage)
VALUES  (8, 'expired_voucher', '01.10.2025', 0, 0.5);