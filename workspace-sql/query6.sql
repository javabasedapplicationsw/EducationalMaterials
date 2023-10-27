-- PRODUCTS 테이블의 LIST_PRICE의 최대값을 구하시오.
SELECT 
	MAX(LIST_PRICE) 
FROM PRODUCTS p 
;

-- LIST_PRICE가 8867.99인 행을 출력하시오.
SELECT 
	PRODUCT_ID 
	, PRODUCT_NAME 
	, LIST_PRICE 
FROM PRODUCTS p 
WHERE LIST_PRICE = 8867.99
;

-- 서브 쿼리를 이용하여 단 한 개의 SQL문으로 출력을 완료함 
SELECT 
	P.PRODUCT_ID 
	, P.PRODUCT_NAME 
	, P.LIST_PRICE 
FROM PRODUCTS p 
WHERE LIST_PRICE = (
						SELECT 
							MAX(LIST_PRICE) 
						FROM PRODUCTS p 
					)
;
					












