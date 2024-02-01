-- 코드를 입력하세요
SELECT HISTORY_ID, ((days + 1) * DAILY_FEE * (100 - if(DISCOUNT_RATE is null, 0, DISCOUNT_RATE)) div 100) as FEE
from (
    select CAR_ID, CAR_TYPE, DAILY_FEE from CAR_RENTAL_COMPANY_CAR 
    where car_type = "트럭"
) as c
join (
    select 
    HISTORY_ID
    , CAR_ID
    , days
    , (
        case
        when days >= 90 then '90일 이상'
        when days >= 30 then '30일 이상'
        when days >= 7 then '7일 이상'
        end
      ) as DURATION_TYPE 
    from (select HISTORY_ID, CAR_ID, datediff(end_date, start_date) as days from CAR_RENTAL_COMPANY_RENTAL_HISTORY) as t
) as h on c.car_id = h.car_id
left join (
    select CAR_TYPE, DURATION_TYPE, DISCOUNT_RATE from CAR_RENTAL_COMPANY_DISCOUNT_PLAN 
    where car_type = "트럭"
) as p on h.DURATION_TYPE = p.DURATION_TYPE
order by fee desc, history_id desc;