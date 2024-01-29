-- 코드를 입력하세요
SELECT month(START_DATE) as MONTH, CAR_ID, count(CAR_ID) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where START_DATE >= '20220801' and START_DATE < '20221101' and CAR_ID in (
    select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where START_DATE >= '20220801' and START_DATE < '20221101'
    group by CAR_ID
    having count(CAR_ID) >= 5
)
group by month, car_id
having count(car_id) > 0
order by month asc, car_id desc