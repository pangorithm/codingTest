-- 코드를 입력하세요
SELECT CAR_ID, c.CAR_TYPE, (DAILY_FEE * 30 * (100 - DISCOUNT_RATE) div 100) as FEE
from (
    select * from CAR_RENTAL_COMPANY_CAR
    where CAR_TYPE regexp('세단|SUV')
    ) as c 
    join (
    select * from CAR_RENTAL_COMPANY_DISCOUNT_PLAN
    where DURATION_TYPE = '30일 이상'
    ) as p on c.CAR_TYPE = p.CAR_TYPE
where car_id not in (
    select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where (START_DATE < 20221130) and (END_DATE > 20221101)
)
group by c.car_id
having fee between 500000 and 1999999
order by fee desc, c.car_type asc, car_id desc