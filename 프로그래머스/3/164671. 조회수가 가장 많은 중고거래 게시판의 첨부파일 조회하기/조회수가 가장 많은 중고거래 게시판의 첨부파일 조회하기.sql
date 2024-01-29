-- 코드를 입력하세요
SELECT concat('/home/grep/src/', b.board_id, '/', file_id, file_name, file_ext) as FILE_PATH
from USED_GOODS_BOARD as b join USED_GOODS_FILE as f on b.BOARD_ID = f.BOARD_ID	
where views = (select max(views) from USED_GOODS_BOARD)
order by file_id desc