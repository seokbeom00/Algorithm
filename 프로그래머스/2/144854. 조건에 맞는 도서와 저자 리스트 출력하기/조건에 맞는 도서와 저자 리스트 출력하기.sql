select b.book_id, a.AUTHOR_NAME, date_format(b.PUBLISHED_DATE, '%Y-%m-%d')
from book b, author a
where b.author_id = a.author_id and b.category = "경제"
order by b.PUBLISHED_DATE