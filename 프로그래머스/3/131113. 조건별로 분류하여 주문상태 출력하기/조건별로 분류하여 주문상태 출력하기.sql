-- 코드를 입력하세요
SELECT ORDER_ID 주문ID
     , PRODUCT_ID 제품ID
     , TO_CHAR(OUT_DATE, 'YYYY-MM-DD') 출고일자
     , CASE WHEN TO_CHAR(OUT_DATE, 'YYYYMMDD') <= '20220501' THEN '출고완료'
            WHEN TO_CHAR(OUT_DATE, 'YYYYMMDD') > '20220501' THEN '출고대기'
            ELSE '출고미정'
            END AS 출고여부
FROM FOOD_ORDER
ORDER BY ORDER_ID;