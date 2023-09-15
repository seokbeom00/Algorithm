from db_conn import *
import pandas as pd

conn, cur = open_db()
df = pd.read_excel("score.xlsx")

insert_sql = """insert into score(sno, attendance, homework, discussion, midterm, final, score, grade)
VALUES(%s, %s, %s, %s, %s, %s, %s, %s)
"""

for _, row in df.iterrows():
    sno = row["sno"]
    attendance = row["attendance"]
    homework = row["homework"]
    discussion = row["discussion"]
    midterm = row["midterm"]
    final = row["final"]
    score = row["score"]
    grade = row["grade"]
    cur.execute(
        insert_sql,
        (sno, attendance, homework, discussion, midterm, final, score, grade),
    )
conn.commit()
close_db(conn, cur)
