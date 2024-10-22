select p.PRODUCT_ID, p.PRODUCT_NAME, sum(p.PRICE * o.AMOUNT) as TOTAL_SALES
from FOOD_PRODUCT p, FOOD_ORDER o
where p.PRODUCT_ID = o.PRODUCT_ID 
and date_format(o.PRODUCE_DATE, '%Y-%m') = '2022-05'
group by p.PRODUCT_ID
order by sum(p.PRICE * o.AMOUNT) desc, p.PRODUCT_ID;