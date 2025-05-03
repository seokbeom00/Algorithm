select count(*) as FISH_COUNT, MONTH(TIME) as MONTH
from FISH_INFO
group by MONTH(TIME)
having count(*) > 0
order by MONTH(TIME)