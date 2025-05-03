select count(*) as FISH_COUNT, f2.FISH_NAME
from FISH_INFO f1
join FISH_NAME_INFO f2 on f1.FISH_TYPE = f2.FISH_TYPE
group by f1.FISH_TYPE, f2.FISH_NAME
order by count(*) desc