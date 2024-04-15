INSERT INTO product (id, name, name_ru, name_en, name_ua, price, category_id, allergens_id, weight, url, img, status, description, description_ru, description_en, description_ua, size, sale, cart_count, sort, box, removal_date, discount_id )
VALUES (22, 'Sushi5 z krewetkami', 'MockedLocalizeRu', 'MockedLocalizeEn' , 'MockedLocalizeUa', 60, 1, 9, 0.27, 'Sushi_with_shrimp', 'uploads/2023/mock-files-1683805117204.jpg', 1, '<p>Papier ryżowy</p><p>Liscie salaty</p><p>Ser philadelphia</p><p>Ogórek</p><p>Tobiko</p><p>Krewetka</p><p>Sos Teriyaki</p>', '<p>Рисовая бумага</p><p>Листья салата</p><p>Сыр Филадельфия</p><p>Огурец</p><p>Тобико</p><p>Креветка</p><p>Соус терияки</p>', '<p>Rice paper</p><p>Salata leaves</p><p>Philadelphia cheese</p><p>Cucumber</p><p>Tobiko</p><p>Prawn</p><p>Teriyaki sauce</p>', '<p>Рисовий папір</p><p>Листя салату</p><p>Сир Філадельфія</p><p>Огірок</p><p>Тобіко</p><p>Креветка</p><p>Соус Теріякі</p>', 4, 0, 4, 2, 1, null, 1);
INSERT INTO category (id, name, name_ua, name_ru, name_en, url, img, discount_id)
VALUES (11, 'Napój', 'Напиток', 'Напиток', 'Drink', 'http://koktajle-drinki.pl/drink/tropical-bay', 'https://www.mojegotowanie.pl/media/cache/default_view/uploads/media/recipe/0002/48/blue-lagoon-drink_147548.webp', 2);


INSERT INTO discount (id, discount_per_quantity, discount_type, relation_id)
VALUES  (1, '{"1":"0.1", "5":"0.3", "10":"0.5"}', 'PRODUCT', 1);
INSERT INTO discount (id, discount_per_quantity, discount_type, relation_id)
VALUES  (2, '{"1":"0.3", "5":"0.3", "10":"0.5"}', 'CATEGORY', 1);
INSERT INTO discount (id, discount_per_quantity, discount_type, relation_id)
VALUES  (3, '{"1":"0.3"}', 'PRODUCT', 2);
INSERT INTO discount (id, discount_per_quantity, discount_type, relation_id)
VALUES  (4, '{"1":"0.1", "5":"0.3", "10":"0.5"}', 'CATEGORY', 2);
INSERT INTO discount (id, discount_per_quantity, discount_type, relation_id)
VALUES  (5, '{"1":"0.3", "5":"0.5"', 'PRODUCT', 3);
INSERT INTO discount (id, discount_per_quantity, discount_type, relation_id)
VALUES  (6, '{"1":"0.1", "5":"0.3", "10":"0.5"}', 'CATEGORY', 3);

UPDATE product SET discount_id=1 where id=1;
UPDATE product SET discount_id=3 where id=2;
