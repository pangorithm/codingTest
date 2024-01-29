-- 코드를 입력하세요
SELECT month(START_DATE) as MONTH, CAR_ID, count(*) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
where START_DATE between '20220801' and '20221031' and CAR_ID in (
    select CAR_ID
    from CAR_RENTAL_COMPANY_RENTAL_HISTORY
    where START_DATE between '20220801' and '20221031'
    group by CAR_ID
    having count(CAR_ID) >= 5
)
group by month, car_id
order by month asc, car_id desc