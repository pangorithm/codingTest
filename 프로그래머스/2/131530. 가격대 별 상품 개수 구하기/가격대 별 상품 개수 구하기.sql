-- 코드를 입력하세요
SELECT if(price < 10000, 0, truncate(price, -4)) as PRICE_GROUP, count(PRODUCT_ID) as PRODUCTS
from product
group by PRICE_GROUP
order by PRICE_GROUP