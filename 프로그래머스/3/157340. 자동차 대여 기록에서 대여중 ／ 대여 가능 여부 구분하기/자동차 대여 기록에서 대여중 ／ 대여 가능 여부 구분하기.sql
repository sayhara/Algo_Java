-- 코드를 입력하세요
SELECT DISTINCT A.CAR_ID
    , CASE WHEN EXISTS (SELECT 1
                        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY B
                        WHERE A.CAR_ID = B.CAR_ID
                        AND TO_DATE('2022-10-16', 'YYYY-MM-DD') BETWEEN B.START_DATE AND B.END_DATE)
                        THEN '대여중' ELSE '대여 가능'
                        END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY A
ORDER BY A.CAR_ID DESC
                        