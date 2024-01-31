-- 코드를 입력하세요
SELECT APNT_NO, PT_NAME, a.PT_NO, MCDP_CD, DR_NAME, APNT_YMD
from (
    select APNT_YMD, APNT_NO, PT_NO, MCDP_CD, MDDR_ID
    from APPOINTMENT 
    where date_format(APNT_YMD, '%y%m%d') = '220413' and APNT_CNCL_YN = 'N'
) as a join (
    select dr_name, dr_id
    from doctor
) as d on a.MDDR_ID = d.DR_ID join (
    select PT_NAME, PT_NO
    from patient
) as p on a.PT_NO = p.PT_NO
order by APNT_YMD asc