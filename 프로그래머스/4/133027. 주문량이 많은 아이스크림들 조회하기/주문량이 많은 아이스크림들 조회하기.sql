select flavor
from(select *
from FIRST_HALF
union
select *
from JULY) febjul
group by flavor
order by sum(total_order) desc
limit 3