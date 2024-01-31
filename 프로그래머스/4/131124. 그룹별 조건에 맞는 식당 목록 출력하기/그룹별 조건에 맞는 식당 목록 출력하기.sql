-- 코드를 입력하세요
SELECT m.MEMBER_NAME, REVIEW_TEXT, date_format(REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
from MEMBER_PROFILE as m join REST_REVIEW as r on m.member_id = r.member_id
where m.MEMBER_ID = (
    select member_id
    from REST_REVIEW 
    group by member_id
    order by count(*) desc
    limit 1
)
order by REVIEW_DATE, REVIEW_TEXT