select e1.ID, count(e2.ID) as CHILD_COUNT
from ECOLI_DATA e1
left join ECOLI_DATA e2 on e1.ID = e2.PARENT_ID
group by e1.ID
order by e1.ID