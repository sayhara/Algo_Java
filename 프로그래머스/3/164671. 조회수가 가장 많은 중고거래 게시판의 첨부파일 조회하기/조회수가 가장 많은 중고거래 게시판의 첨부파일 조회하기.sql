SELECT '/home/grep/src' || '/' || T2.BOARD_ID 
        || '/' || T2.FILE_ID || T2.FILE_NAME 
        || T2.FILE_EXT AS FILE_PATH
FROM 
(
SELECT *
FROM (SELECT *
        FROM USED_GOODS_BOARD
        ORDER BY VIEWS DESC) 
WHERE ROWNUM =1
    ) T1
 , USED_GOODS_FILE  T2
WHERE T1.BOARD_ID = T2.BOARD_ID
ORDER BY FILE_ID DESC;
