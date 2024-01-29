-- 코드를 입력하세요
SELECT 
    CAR_ID, 
    if (car_id in (
        select car_id
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where '20221016' between START_DATE and END_DATE
    ), '대여중', '대여 가능') as AVAILABILITY
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by car_id
order by car_id desc