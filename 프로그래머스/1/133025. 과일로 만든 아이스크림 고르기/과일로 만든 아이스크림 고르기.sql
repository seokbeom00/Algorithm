SELECT ii.FLAVOR
FROM FIRST_HALF fh, ICECREAM_INFO ii
WHERE fh.FLAVOR = ii.FLAVOR AND fh.TOTAL_ORDER > 3000 AND ii.INGREDIENT_TYPE = 'fruit_based'