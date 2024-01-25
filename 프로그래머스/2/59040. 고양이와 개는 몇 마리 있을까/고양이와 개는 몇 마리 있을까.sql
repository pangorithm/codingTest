-- 코드를 입력하세요
SELECT ANIMAL_TYPE, count(ANIMAL_TYPE) as count
from animal_ins
where ANIMAL_TYPE in ('Cat', 'Dog')
group by ANIMAL_TYPE
order by animal_type;