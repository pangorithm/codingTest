-- 코드를 입력하세요
SELECT CATEGORY, sum(sales) as TOTAL_SALES
from book as b join book_sales as s on b.book_id = s.book_id
where year(SALES_DATE) = '2022' and month(SALES_DATE) = '01'
group by category
order by category;