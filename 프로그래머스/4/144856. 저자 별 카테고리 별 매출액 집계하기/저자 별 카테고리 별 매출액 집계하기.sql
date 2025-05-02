select b.AUTHOR_ID, a.AUTHOR_NAME, b.CATEGORY, sum(bs.SALES * b.PRICE) as TOTAL_SALES
from BOOK b
join AUTHOR a on b.AUTHOR_ID = a.AUTHOR_ID
join BOOK_SALES bs on b.BOOK_ID = bs.BOOK_ID
where DATE_FORMAT(bs.SALES_DATE, '%Y-%m') = '2022-01'
group by b.AUTHOR_ID, b.CATEGORY
order by b.AUTHOR_ID asc, b.CATEGORY desc