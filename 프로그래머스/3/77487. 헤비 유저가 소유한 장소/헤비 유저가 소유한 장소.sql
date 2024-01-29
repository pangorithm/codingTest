-- 코드를 입력하세요
SELECT ID, NAME, HOST_ID
from places
where host_id in (
    select host_id
    from places
    group by HOST_ID
    having count(HOST_ID) >= 2
                 )
order by id