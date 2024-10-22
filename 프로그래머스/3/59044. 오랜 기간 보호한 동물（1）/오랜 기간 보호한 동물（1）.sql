select a1.name, a1.datetime
from animal_ins a1
where a1.animal_id not in(select a2.animal_id 
                           from animal_outs a2
                          )
order by a1.datetime
limit 3