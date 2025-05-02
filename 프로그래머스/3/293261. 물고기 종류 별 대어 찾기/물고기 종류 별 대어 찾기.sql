select fi.ID, fni.FISH_NAME, fi.LENGTH
from FISH_INFO fi
join (select fi2.FISH_TYPE, max(fi2.LENGTH) as MAX_VAL
    from FISH_INFO fi2
    group by fi2.FISH_TYPE) max_info on fi.FISH_TYPE = max_info.FISH_TYPE
join FISH_NAME_INFO fni on fi.FISH_TYPE = fni.FISH_TYPE
where fi.LENGTH = max_info.MAX_VAL and fi.FISH_TYPE = max_info.FISH_TYPE
order by fi.ID