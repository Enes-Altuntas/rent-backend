INSERT INTO APARTMENTS (ID, APARTMENT_NAME, APARTMENT_NUMBER, STREET_NAME, NEIGHBORHOOD, CITY, STATE, CREATED_AT)
VALUES (99990, 'Barış', 6, 'Başak', 'Yeşilyurt', 'Istanbul', 'Bakırköy', NOW()),
       (99991, 'Şerifoğlu', 65, 'Esenlik', 'Ünalan', 'Istanbul', 'Üsküdar', NOW()),
       (99992, 'Arzu', 7, 'Sipahioğlu', 'Hasan Paşa', 'Istanbul', 'Küçükçekmece', NOW());

INSERT INTO CURRENCIES (ID, CURRENCY_VALUE, CURRENCY_VALUE_LONG)
VALUES (99990, 'TL', 'Türk Lirası'),
       (99991, 'EUR', 'Euro'),
       (99992, 'USD', 'Amerikan Doları');

INSERT INTO FLAT_TYPES (ID, FLAT_TYPE_VALUE)
VALUES (99990, '1+1'),
       (99991, '2+1'),
       (99992, '3+1'),
       (99993, '4+1');

INSERT INTO FLAT_USAGE_TYPE(ID, USAGE_VALUE)
VALUES (99990, 'Ofis'),
       (99991, 'Mesken'),
       (99992, 'AirBNB');

INSERT INTO FLAT_STATUSES(ID, FLAT_STATUS_VALUE)
VALUES (99990, 'Kiralık'),
       (99991, 'Satılık');

INSERT INTO EMPLOYEES (ID, NAMESURNAME)
VALUES (99990, 'Mehmet Selek'),
       (99991, 'Sena Selek');

INSERT INTO FLAT_CONTRACTS (ID, START_DATE, END_DATE, PAYMENT_DUE)
VALUES (99990, '2022-12-1 12:00:00', '2023-12-1 12:00:00', 10),
       (99991, '2022-12-1 12:00:00', '2023-12-1 12:00:00', 10),
       (99992, '2022-12-1 12:00:00', '2023-12-1 12:00:00', 30),
       (99993, '2022-12-1 12:00:00', '2023-12-1 12:00:00', 10);

INSERT INTO OWNERS (ID, NAMESURNAME, EMAIL, TC_NO, BANK, BRANCH, ACCOUNT_NUMBER, IBAN, PHONE_NUMBER, ADDRESS)
VALUES (99990, 'Sinan Meriç', 'johnydepp@gmail.com', '32728806152', 'Garanti Bankası', 'Bakırköy Şube', 11111111,
        'TR650001001231575410625001', '+905536739260',
        'Osmanağa, Bahariye Cad. Kadıköy Pasajı No:25, 34714 Kadıköy/İstanbul'),
       (99991, 'Ahmet Meriç', 'bradpitt@gmail.com', '32728806153', 'ING Bank', 'Yeşilköy Şube', 22222222,
        'TR650001001231575410625002', '+905536739261',
        'Acıbadem Mah. Çeçen Sok. Akasya Kule No:25 B2 Blok Kat:6 Daire:71 Üsküdar / İstanbul'),
       (99992, 'Mehmet Meriç', 'thorodinson@gmail.com', '32728806154', 'Akbank', 'Kadıköy Şube', 33333333,
        'TR650001001231575410625003', '+905536739262', 'Barbaros, Mor Sumbul Sokagi No:7/3, 34746 Ataşehir/İstanbul'),
       (99993, 'Murat Meriç', 'lokiodinson@gmail.com', '32728806155', 'Yapı Kredi', 'Üsküdar Şube', 44444444,
        'TR650001001231575410625004', '+905536739263', 'Osmanağa, Halitağa Cd. No:19, 34714 Kadıköy/İstanbul'),
       (99994, 'Bülent Meriç', 'odinallfather@gmail.com', '32728806156', 'ING Bank', 'Florya Şube', 55555555,
        'TR650001001231575410625005', '+905536739264',
        'Ziya Gökalp, Turgut Özal Cd/Bolap Sok İkitelli Sanayi Sitesi, 34306 İkitelli/Başakşehir/İstanbul');

INSERT INTO RENTERS (ID, TC_NO, IBAN, NAMESURNAME, PHONE_NUMBER, CREATED_AT, RENTER_CODE, EMAIL, ACTIVE)
VALUES (99990, '11111111111', 'TR650001001231575410625001', 'Enes Altuntaş', '+905536739260', NOW(), 'DENEME1',
        'enesaltuntas@gmail.com', true),
       (99991, '22222222222', 'TR650001001231575410625002', 'Ali Bingöl', '+905536739261', NOW(), 'DENEME2',
        'alibingol@gmail.com', true),
       (99992, '33333333333', 'TR650001001231575410625003', 'Mertcan Nar', '+905536739262', NOW(), 'DENEME3',
        'mertcannar@gmail.com', true),
       (99993, '44444444444', 'TR650001001231575410625004', 'Furkan Koçhan', '+905536739263', NOW(), 'DENEME4',
        'furkankochan@gmail.com', true),
       (99994, '55555555555', 'TR650001001231575410625005', 'Ahmet Altan', '+905536739264', NOW(), 'DENEME5',
        'yuriboyka@gmail.com', false);

INSERT INTO FLATS (ID, FLAT_NUMBER, FLAT_PRICE, FLAT_AREA, CREATED_AT, FLATTYPE_ID, CURRENCY_ID, APARTMENT_ID,
                   EMPLOYEE_ID, FLAT_CONTRACT_ID, RENTER_ID, FLAT_USAGE_ID, FLAT_STATUS_ID)
VALUES (99990, 1, 1500, '100', NOW(), 99990, 99990, 99990, 99990, 99990, 99990, 99991, 99990),
       (99991, 2, 2500, '120', NOW(), 99991, 99991, 99990, 99990, 99991, 99990, 99991, 99990),
       (99992, 1, 3500, '150', NOW(), 99992, 99992, 99991, 99991, 99992, 99991, 99991, 99990),
       (99993, 1, 7500, '240', NOW(), 99993, 99992, 99992, 99991, 99993, 99992, 99990, 99991),
       (99994, 2, 5500, '160', NOW(), 99990, 99990, 99992, 99991, NULL, NULL, 99990, 99991);

INSERT INTO FLATS_AND_OWNERS(FLAT_ID, OWNER_ID)
VALUES (99990, 99990),
       (99991, 99991),
       (99992, 99992),
       (99993, 99993),
       (99993, 99994),
       (99994, 99993),
       (99994, 99994);

INSERT INTO LANDS (ID, CREATED_AT, ADA_NO, NEIGHBOURHOOD, PARSEL_NO, PRICE, PROVINCE, STATE)
VALUES (99990, NOW(), 75, 'Yeşilyurt', 1452, 7500000, 'Bakırköy', 'İstanbul'),
       (99991, NOW(), 75, 'Ünalan', 1452, 7500000, 'Üsküdar', 'İstanbul'),
       (99992, NOW(), 75, 'Atatürk', 1452, 7500000, 'Büyükçekmece', 'İstanbul');

INSERT INTO LANDS_OWNERS (owner_id, land_id)
VALUES (99990, 99990),
       (99990, 99991),
       (99990, 99992),
       (99991, 99992),
       (99992, 99991),
       (99990, 99992);

INSERT INTO PAYMENTS (ID, CREATED_AT, PAYMENT_DATE, FILE_ID, FLAT_ID, RENTER_ID)
VALUES (99990, NOW(), '2022-11-21 17:14:27.467008', NULL, 99990, 99990),
       (99991, NOW(), '2022-12-21 17:14:27.467008', NULL, 99990, 99990),
       (99992, NOW(), '2022-12-21 17:14:27.467008', NULL, 99991, 99990),
       (99993, NOW(), '2022-11-21 17:14:27.467008', NULL, 99992, 99991),
       (99994, NOW(), '2022-11-21 17:14:27.467008', NULL, 99993, 99992);