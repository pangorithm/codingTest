-- 코드를 입력하세요
SELECT CART_ID
from CART_PRODUCTS 
where name = "Milk" and cart_id in (select cart_id from CART_PRODUCTS where name = "Yogurt")
order by CART_ID