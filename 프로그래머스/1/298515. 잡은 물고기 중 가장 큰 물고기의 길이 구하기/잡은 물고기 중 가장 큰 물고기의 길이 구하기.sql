select concat(LENGTH, 'cm') as MAX_LENGTH
from FISH_INFO
order by LENGTH desc
limit 1