with fish_length as(
select (case when LENGTH is null then 10
       else LENGTH end) as len, ID
from FISH_INFO
)

select count(*) as FISH_COUNT, max(f2.len) as MAX_LENGTH, FISH_TYPE
from FISH_INFO f1
join fish_length f2 on f1.ID = f2.ID
group by f1.FISH_TYPE
having avg(f2.len) >= 33
order by f1.FISH_TYPE