-- 코드를 입력하세요
SELECT 
    YEAR
    , MONTH
    , count(*) as PUCHASED_USERS
    , round(count(*) / (select count(*) from USER_INFO where year(joined) = '2021'), 1) as PUCHASED_RATIO
from (
    select user_id from USER_INFO
    where year(joined) = '2021'
) as i join (
    select year(SALES_DATE) as year, month(SALES_DATE) as month, user_id from ONLINE_SALE group by user_id, month, year
) as s on i.user_id = s.user_id
group by year, month
order by year, month