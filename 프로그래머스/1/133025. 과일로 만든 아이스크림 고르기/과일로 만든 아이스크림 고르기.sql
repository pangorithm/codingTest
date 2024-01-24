-- 코드를 입력하세요
SELECT f.flavor
from first_half as f join icecream_info as i on f.flavor = i.flavor
where total_order >= 3000 and ingredient_type = "fruit_based"
order by total_order desc;