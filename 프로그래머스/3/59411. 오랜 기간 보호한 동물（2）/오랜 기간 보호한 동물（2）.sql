-- 코드를 입력하세요
SELECT i.ANIMAL_ID, i.NAME
from animal_ins as i join animal_outs as o on i.animal_id = o.animal_id
order by datediff(o.datetime, i.datetime) desc
limit 2