WITH RECURSIVE hours AS (
    SELECT 0 AS hour
    UNION ALL
    SELECT hour + 1
    FROM hours
    WHERE hour < 23
)

SELECT 
    h.hour AS HOUR, 
    COUNT(a.ANIMAL_ID) AS COUNT
FROM 
    hours h
LEFT JOIN (
    SELECT HOUR(DATETIME) AS hour, ANIMAL_ID
    FROM ANIMAL_OUTS
) a ON h.hour = a.hour
GROUP BY h.hour
ORDER BY h.hour;