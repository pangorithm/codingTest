-- 코드를 입력하세요
SELECT 
    USER_ID, NICKNAME
    , concat(CITY, ' ', STREET_ADDRESS1, ' ', STREET_ADDRESS2) as 전체주소
    , concat(substr(TLNO, 1, 3), '-', substr(TLNO, 4, 4), '-', substr(TLNO, 8, 4)) as 전화번호
from USED_GOODS_BOARD as b join USED_GOODS_USER as u on WRITER_ID = USER_ID
group by user_id
having count(*) >= 3
order by user_id desc