-- 코드를 입력하세요
SELECT m.MEMBER_NAME, REVIEW_TEXT, date_format(REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
from MEMBER_PROFILE as m 
    join (
        select MEMBER_ID
        from REST_REVIEW 
        group by member_id
        order by count(*) desc
        limit 1
    ) as l on m.member_id = l.member_id
    join REST_REVIEW as r on r.member_id = l.member_id
order by REVIEW_DATE, REVIEW_TEXT