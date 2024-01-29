-- 코드를 입력하세요
SELECT c.CAR_ID
from CAR_RENTAL_COMPANY_CAR as c join CAR_RENTAL_COMPANY_RENTAL_HISTORY as h on c.car_id = h.car_id
where CAR_TYPE = '세단' and month(START_DATE) = '10'
group by c.car_id
order by c.car_id desc