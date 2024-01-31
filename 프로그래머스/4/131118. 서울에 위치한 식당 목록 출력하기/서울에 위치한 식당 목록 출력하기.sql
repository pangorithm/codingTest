-- 코드를 입력하세요
SELECT i.REST_ID, REST_NAME, FOOD_TYPE, FAVORITES, ADDRESS, round(avg(REVIEW_SCORE), 2) as SCORE
from REST_INFO as i join REST_REVIEW as r on i.rest_id = r.rest_id
where ADDRESS like "서울%"
group by i.rest_id
order by score desc, favorites desc