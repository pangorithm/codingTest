-- 코드를 입력하세요
SELECT USER_ID, NICKNAME, sum(price) as TOTAL_SALES
from USED_GOODS_BOARD as b join USED_GOODS_USER as u on WRITER_ID = USER_ID
where status = 'DONE'
group by USER_ID
having sum(price) >= 700000 
order by sum(price) asc