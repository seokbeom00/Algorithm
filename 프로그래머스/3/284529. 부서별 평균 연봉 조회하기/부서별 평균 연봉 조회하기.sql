select h1.DEPT_ID, h1.DEPT_NAME_EN, round(avg(h2.SAL), 0) as AVG_SAL
from HR_DEPARTMENT h1
join HR_EMPLOYEES h2 on h1.DEPT_ID = h2.DEPT_ID
group by h1.DEPT_ID
order by AVG_SAL desc