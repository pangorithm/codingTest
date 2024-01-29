-- 코드를 입력하세요
SELECT FOOD_TYPE, REST_ID, REST_NAME, FAVORITES
from rest_info
where (food_type, favorites) IN (SELECT food_type, max(favorites)
                           FROM REST_INFO
                           GROUP BY FOOD_TYPE)
order by FOOD_TYPE desc, FAVORITES desc