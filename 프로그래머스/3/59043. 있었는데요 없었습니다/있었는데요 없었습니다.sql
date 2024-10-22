-- 코드를 입력하세요
select a1.animal_id, a1.name
from animal_ins a1, animal_outs a2
where a1.animal_id = a2.animal_id and a1.datetime > a2.datetime
order by a1.datetime