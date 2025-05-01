select count(*) as FISH_COUNT
from FISH_INFO
where FISH_TYPE in (select FISH_TYPE 
                    from FISH_NAME_INFO 
                    where FISH_NAME = 'BASS' or FISH_NAME = 'SNAPPER')