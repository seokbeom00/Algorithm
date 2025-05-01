select e.ID, 
    (case 
    when e.TILE = 1 then 'CRITICAL'
    when e.TILE = 2 then 'HIGH'
    when e.TILE = 3 then 'MEDIUM'
    when e.TILE = 4 then 'LOW'
    end) as COLONY_NAME
from (select ID, NTILE(4) OVER (order by SIZE_OF_COLONY desc) as TILE
      from ECOLI_DATA
      ) as e
order by e.ID