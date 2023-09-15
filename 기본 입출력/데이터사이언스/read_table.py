from db_conn import *

conn, cur = open_db()
sql = "select * from student;"
cur.execute(sql)

row = cur.fetchone()
while row:
    print(row)
    row = cur.fetchone()
close_db(conn, cur)
