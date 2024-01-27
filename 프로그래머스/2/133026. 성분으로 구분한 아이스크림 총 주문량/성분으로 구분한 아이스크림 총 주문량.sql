-- 코드를 입력하세요
SELECT INGREDIENT_TYPE, sum(total_order) as TOTAL_ORDER
from first_half as f join icecream_info as i on f.flavor = i.flavor
group by INGREDIENT_TYPE
order by total_order;