
INSERT INTO TBL_PRODUCT_GROUP (ID, CREATED, CREATED_BY, MODIFIED, MODIFIED_BY, CODE, TITLE) VALUES (1, TO_TIMESTAMP('2019-04-24 15:19:42.874000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', TO_TIMESTAMP('2019-05-01 16:54:21.680000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', 'PRODUCTS', 'Products');
INSERT INTO TBL_PRODUCT (ID, CREATED, CREATED_BY, MODIFIED, MODIFIED_BY, CODE, TITLE, AMOUNT, PRODUCT_GROUP_ID) VALUES (1, TO_TIMESTAMP('2019-05-01 16:54:53.170000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', TO_TIMESTAMP('2019-05-01 16:54:53.170000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', 'VS5', 'Vegemite Scroll', 3, 1);
INSERT INTO TBL_PRODUCT (ID, CREATED, CREATED_BY, MODIFIED, MODIFIED_BY, CODE, TITLE, AMOUNT, PRODUCT_GROUP_ID) VALUES (2, TO_TIMESTAMP('2019-05-01 16:55:31.857000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', TO_TIMESTAMP('2019-05-01 16:55:31.857000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', 'MB11', 'Blueberry Muffin', 5, 1);
INSERT INTO TBL_PRODUCT (ID, CREATED, CREATED_BY, MODIFIED, MODIFIED_BY, CODE, TITLE, AMOUNT, PRODUCT_GROUP_ID) VALUES (3, TO_TIMESTAMP('2019-05-01 16:55:31.857000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', TO_TIMESTAMP('2019-05-01 16:55:31.857000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', 'CF', 'Croissant', 2, 1);
INSERT INTO TBL_PACKS (ID, CREATED, CREATED_BY, MODIFIED, MODIFIED_BY, PACK_COUNT, AMOUNT, PRODUCT_ID) VALUES (1, TO_TIMESTAMP('2019-05-01 16:55:31.857000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', TO_TIMESTAMP('2019-05-01 16:55:31.857000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', 3, 6.99, 1);
INSERT INTO TBL_PACKS (ID, CREATED, CREATED_BY, MODIFIED, MODIFIED_BY, PACK_COUNT, AMOUNT, PRODUCT_ID) VALUES (2, TO_TIMESTAMP('2019-05-01 16:55:31.857000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', TO_TIMESTAMP('2019-05-01 16:55:31.857000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', 5, 8.99, 1);
INSERT INTO TBL_PACKS (ID, CREATED, CREATED_BY, MODIFIED, MODIFIED_BY, PACK_COUNT, AMOUNT, PRODUCT_ID) VALUES (3, TO_TIMESTAMP('2019-05-01 16:55:31.857000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', TO_TIMESTAMP('2019-05-01 16:55:31.857000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', 2, 9.95, 2);
INSERT INTO TBL_PACKS (ID, CREATED, CREATED_BY, MODIFIED, MODIFIED_BY, PACK_COUNT, AMOUNT, PRODUCT_ID) VALUES (4, TO_TIMESTAMP('2019-05-01 16:55:31.857000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', TO_TIMESTAMP('2019-05-01 16:55:31.857000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', 5, 16.95, 2);
INSERT INTO TBL_PACKS (ID, CREATED, CREATED_BY, MODIFIED, MODIFIED_BY, PACK_COUNT, AMOUNT, PRODUCT_ID) VALUES (5, TO_TIMESTAMP('2019-05-01 16:55:31.857000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', TO_TIMESTAMP('2019-05-01 16:55:31.857000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', 8, 24.95, 2);
INSERT INTO TBL_PACKS (ID, CREATED, CREATED_BY, MODIFIED, MODIFIED_BY, PACK_COUNT, AMOUNT, PRODUCT_ID) VALUES (6, TO_TIMESTAMP('2019-05-01 16:55:31.857000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', TO_TIMESTAMP('2019-05-01 16:55:31.857000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', 3, 5.95, 3);
INSERT INTO TBL_PACKS (ID, CREATED, CREATED_BY, MODIFIED, MODIFIED_BY, PACK_COUNT, AMOUNT, PRODUCT_ID) VALUES (7, TO_TIMESTAMP('2019-05-01 16:55:31.857000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', TO_TIMESTAMP('2019-05-01 16:55:31.857000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', 5, 9.95, 3);
INSERT INTO TBL_PACKS (ID, CREATED, CREATED_BY, MODIFIED, MODIFIED_BY, PACK_COUNT, AMOUNT, PRODUCT_ID) VALUES (8, TO_TIMESTAMP('2019-05-01 16:55:31.857000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', TO_TIMESTAMP('2019-05-01 16:55:31.857000', 'YYYY-MM-DD HH24:MI:SS.FF6'), 'admin', 9, 16.99, 3);