from db_conn import *
import pandas as pd

conn, cur = open_db()
df = pd.read_csv("top_movies.csv")

insert_sql = """insert into top_movies(id, movie_name, release_year, watch_time, movie_rating, metascore, gross, votes, description)
VALUES(%s, %s, %s, %s, %s, %s, %s, %s, %s)
"""

for _, row in df.iterrows():
    id = row["id"]
    movie_name = row["Movie Name"]
    release_year = row["Year of Release"].replace("I", "")
    watch_time = row["Watch Time"]
    movie_rating = row["Movie Rating"]
    if pd.isnull(row["Metascore of movie"]):
        metascore = None
    else:
        metascore = row["Metascore of movie"]
    if pd.isnull(row["Gross"]):
        gross = None
    else:
        gross = float(row["Gross"].replace("#", ""))
    votes = row["Votes"].replace(",", "")
    description = row["Description"]
    cur.execute(
        insert_sql,
        (
            id,
            movie_name,
            release_year,
            watch_time,
            movie_rating,
            metascore,
            gross,
            votes,
            description,
        ),
    )
conn.commit()
close_db(conn, cur)
