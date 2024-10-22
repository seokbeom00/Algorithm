-- 코드를 입력하세요
SELECT distinct p.product_code, p.price*(sum(o.sales_amount))
FROM PRODUCT p, OFFLINE_SALE o
WHERE p.PRODUCT_ID = o.PRODUCT_ID
group by p.product_code
order by p.price*(sum(o.sales_amount)) desc, p.product_code