-- 코드를 입력하세요
SELECT p.PRODUCT_ID, PRODUCT_NAME, sum(price * amount) as TOTAL_SALES
from food_product as p join food_order as o on p.product_id = o.product_id
where year(PRODUCE_DATE) = '2022' and month(PRODUCE_DATE) = '05'
group by p.PRODUCT_ID
order by total_sales desc, p.product_id asc