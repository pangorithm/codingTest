-- 코드를 입력하세요
SELECT PRODUCT_CODE, (price * sum(sales_amount)) as SALES
from product as p join offline_sale as o on p.product_id = o.product_id
group by product_code
order by sales desc, product_code asc;