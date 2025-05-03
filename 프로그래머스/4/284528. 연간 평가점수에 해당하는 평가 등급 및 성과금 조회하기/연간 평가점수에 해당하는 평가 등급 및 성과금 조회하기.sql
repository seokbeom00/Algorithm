with GRADE_TABLE as (select h1.EMP_NO, h1.EMP_NAME, (case
    when avg(h2.SCORE) >= 96 then 'S'
    when avg(h2.SCORE) < 96 and avg(h2.SCORE) >= 90 then 'A'
    when avg(h2.SCORE) < 90 and avg(h2.SCORE) >= 80 then 'B'
    else 'C' end) as GRADE
from HR_EMPLOYEES h1
join HR_GRADE h2 on h1.EMP_NO = h2.EMP_NO
group by h1.EMP_NO)

select h.EMP_NO, h.EMP_NAME, g.GRADE, (case
    when g.GRADE = 'S' then h.SAL * 0.2
    when g.GRADE = 'A' then h.SAL * 0.15
    when g.GRADE = 'B' then h.SAL * 0.1
    when g.GRADE = 'C' then h.SAL * 0 end) as BONUS
from HR_EMPLOYEES h
join GRADE_TABLE g on h.EMP_NO = g.EMP_NO
order by h.EMP_NO