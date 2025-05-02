select CAR_TYPE, COUNT(*)
from CAR_RENTAL_COMPANY_CAR
where OPTIONS LIKE '%가죽시트%' 
or OPTIONS LIKE '%열선시트%'
or OPTIONS LIKE '%통풍시트%'
group by CAR_TYPE
order by CAR_TYPE