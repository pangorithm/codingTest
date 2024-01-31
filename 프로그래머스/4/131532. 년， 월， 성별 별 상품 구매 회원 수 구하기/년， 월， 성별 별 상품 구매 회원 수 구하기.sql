-- 코드를 입력하세요
SELECT YEAR, MONTH, GENDER, count(u.USER_ID) as USERS
from user_info as u join (
    select YEAR(SALES_DATE) as YEAR, MONTH(SALES_DATE) as MONTH, max(USER_ID) as user_id
    from online_sale
    group by YEAR, MONTH, USER_ID
) as o on u.user_id = o.user_id
where gender is not null
group by YEAR, MONTH, GENDER
order by YEAR, MONTH, GENDER