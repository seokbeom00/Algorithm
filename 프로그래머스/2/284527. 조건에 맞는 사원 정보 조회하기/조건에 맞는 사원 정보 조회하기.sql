select sum(h3.SCORE) as SCORE, h2.EMP_NO, h2.EMP_NAME, h2.POSITION, h2.EMAIL
from HR_DEPARTMENT h1
join HR_EMPLOYEES h2 on h1.DEPT_ID = h2.DEPT_ID
join HR_GRADE h3 on h2.EMP_NO = h3.EMP_NO
group by h2.EMP_NO
order by SCORE desc
limit 1