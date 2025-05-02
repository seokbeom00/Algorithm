SELECT *
FROM (
    SELECT 
        YEAR(DIFFERENTIATION_DATE) AS YEAR,
        (max_info.max_val - e.SIZE_OF_COLONY) AS YEAR_DEV,
        e.ID
    FROM 
        ECOLI_DATA e
    JOIN (
        SELECT 
            YEAR(DIFFERENTIATION_DATE) AS YEAR, 
            MAX(SIZE_OF_COLONY) AS max_val
        FROM 
            ECOLI_DATA
        GROUP BY 
            YEAR(DIFFERENTIATION_DATE)
    ) max_info 
    ON YEAR(DIFFERENTIATION_DATE) = max_info.YEAR
) AS sub
ORDER BY YEAR ASC, YEAR_DEV ASC;