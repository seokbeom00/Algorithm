select i.ITEM_ID, i.ITEM_NAME, i.RARITY
from ITEM_INFO i
where i.ITEM_ID in (
    select it.ITEM_ID
    from ITEM_TREE it
    where it.PARENT_ITEM_ID in (
        select ii.ITEM_ID
        from ITEM_INFO ii
        where ii.RARITY = 'RARE'))
order by i.ITEM_ID desc