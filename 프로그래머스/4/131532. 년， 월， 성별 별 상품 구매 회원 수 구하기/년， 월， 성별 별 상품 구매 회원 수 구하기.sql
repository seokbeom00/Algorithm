select db.YEAR, db.MONTH, db.GENDER, count(*) as USERS
from (select YEAR(os.SALES_DATE) as YEAR, MONTH(os.SALES_DATE) as MONTH, ui.GENDER
from USER_INFO ui
join ONLINE_SALE os on ui.USER_ID = os.USER_ID
where ui.GENDER = 0 or ui.GENDER = 1
group by YEAR(os.SALES_DATE), MONTH(os.SALES_DATE), ui.GENDER, ui.USER_ID) db
group by db.YEAR, db.MONTH, db.GENDER
order by db.YEAR, db.MONTH, db.GENDER