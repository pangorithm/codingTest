-- 코드를 입력하세요
SELECT hour(DATETIME) as HOUR, count(*) COUNT
from animal_outs
where hour(DATETIME) between '09' and '19'
group by hour(DATETIME)
order by hour(DATETIME);