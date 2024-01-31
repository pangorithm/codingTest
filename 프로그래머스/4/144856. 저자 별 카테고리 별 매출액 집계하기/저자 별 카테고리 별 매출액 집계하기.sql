-- 코드를 입력하세요
SELECT a.AUTHOR_ID, AUTHOR_NAME, CATEGORY, sum(SALES * PRICE) as TOTAL_SALES
from book as b 
join author as a on b.AUTHOR_ID = a.AUTHOR_ID 
join (select * from book_sales where date_format(SALES_DATE, '%y%m') = '2201') as s on b.BOOK_ID = s.BOOK_ID
group by AUTHOR_ID, CATEGORY
order by AUTHOR_ID asc, CATEGORY desc