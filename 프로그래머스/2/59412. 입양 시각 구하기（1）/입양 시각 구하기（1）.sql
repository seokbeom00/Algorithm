select hour(DATETIME) as HOUR, count(*) as COUNT
from ANIMAL_OUTS
where hour(DATETIME) >= 9 and hour(DATETIME) < 20
group by hour(DATETIME)
order by hour(DATETIME)