-- 코드를 입력하세요
SELECT
a.APNT_NO,
p.PT_NAME,
p.PT_NO,
a.MCDP_CD,
d.DR_NAME,
a.APNT_YMD
FROM
PATIENT p
JOIN APPOINTMENT a
ON p.PT_NO = a.PT_NO
JOIN DOCTOR d
ON d.DR_ID = a.MDDR_ID
WHERE DATE_FORMAT(a.APNT_YMD, "%Y-%m-%d") = "2022-04-13" AND a.MCDP_CD = "CS" AND a.APNT_CNCL_YN != "Y"
ORDER BY APNT_YMD;


# select a.apnt_no, p.pt_name, p.pt_no, a.mcdp_cd, a.mddr_id, a.apnt_ymd
#      from appointment a join patient p
#      on a.pt_no = p.pt_no 
#      where a.apnt_ymd like '%2022-04-13%' and a.apnt_cncl_yn like '%N%';

# select a.apnt_no, d.dr_name, d.dr_id
# from appointment a join doctor d
# on a.mddr_id = d.dr_id;