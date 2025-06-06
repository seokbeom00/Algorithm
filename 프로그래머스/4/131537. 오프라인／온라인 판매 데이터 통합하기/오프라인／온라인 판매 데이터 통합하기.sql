-- 코드를 입력하세요
SELECT DATE_FORMAT(ons.SALES_DATE, '%Y-%m-%d') AS SALES_DATE, ons.PRODUCT_ID, ons.USER_ID, ons.SALES_AMOUNT
FROM ONLINE_SALE ons
WHERE DATE_FORMAT(ons.SALES_DATE, '%Y-%m') = '2022-03'

UNION ALL

SELECT DATE_FORMAT(ofs.SALES_DATE, '%Y-%m-%d') AS SALES_DATE, ofs.PRODUCT_ID, NULL AS USER_ID, ofs.SALES_AMOUNT
FROM OFFLINE_SALE ofs
WHERE DATE_FORMAT(ofs.SALES_DATE, '%Y-%m') = '2022-03'

ORDER BY SALES_DATE, PRODUCT_ID, USER_ID