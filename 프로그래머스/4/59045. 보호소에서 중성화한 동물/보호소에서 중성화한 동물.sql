-- 코드를 입력하세요
SELECT i.ANIMAL_ID, i.ANIMAL_TYPE, i.NAME
from animal_ins as i join animal_outs as o on i.animal_id = o.animal_id
where i.SEX_UPON_INTAKE regexp 'Intact' and o.SEX_UPON_OUTCOME regexp 'Spayed|Neutered'
order by i.animal_id