-- 코드를 입력하세요
SELECT i.ANIMAL_ID, i.ANIMAL_TYPE, i.NAME
from (
    select * from animal_ins where SEX_UPON_INTAKE regexp 'Intact'
) as i join (
    select * from animal_outs where SEX_UPON_OUTCOME regexp 'Spayed|Neutered'
) as o on i.animal_id = o.animal_id
order by i.animal_id