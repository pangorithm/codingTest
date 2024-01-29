-- 코드를 입력하세요
SELECT o.ANIMAL_ID, o.NAME
from animal_ins as i right join animal_outs as o on i.animal_id = o.animal_id
where i.datetime is null
order by o.animal_id, o.name