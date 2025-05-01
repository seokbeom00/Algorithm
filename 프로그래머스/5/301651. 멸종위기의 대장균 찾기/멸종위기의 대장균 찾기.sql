WITH RECURSIVE ecoli_tree AS (
    -- 최초 개체 (1세대)
    SELECT
        ID,
        PARENT_ID,
        1 AS GENERATION
    FROM 
        ECOLI_DATA
    WHERE 
        PARENT_ID IS NULL

    UNION ALL

    -- 자식으로 내려가며 세대 증가
    SELECT
        e.ID,
        e.PARENT_ID,
        t.GENERATION + 1
    FROM 
        ECOLI_DATA e
    JOIN 
        ecoli_tree t ON e.PARENT_ID = t.ID
)

-- 자식이 없는 leaf 노드만 카운트
SELECT 
    COUNT(*) AS COUNT,
    t.GENERATION
FROM 
    ecoli_tree t
LEFT JOIN 
    ECOLI_DATA c ON t.ID = c.PARENT_ID
WHERE 
    c.ID IS NULL -- 자식이 없는 경우
GROUP BY 
    t.GENERATION
ORDER BY 
    t.GENERATION;