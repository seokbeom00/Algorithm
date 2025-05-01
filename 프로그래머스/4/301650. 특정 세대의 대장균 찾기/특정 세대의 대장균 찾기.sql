select e1.ID
from ECOLI_DATA e1
join ECOLI_DATA e2 on e1.PARENT_ID = e2.ID
join ECOLI_DATA e3 on e2.PARENT_ID = e3.ID
where e3.PARENT_ID is null
order by e1.ID