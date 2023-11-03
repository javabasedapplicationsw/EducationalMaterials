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
					
-- 스칼라 서브 쿼리 (SELECT절 내에 사용하는 서브 쿼리)
-- 각 제품의 가격을 구하면서 해당 제품이 위치하는 있는 제품 카테고리의 평균 가격도 같이 출력하시오  

SELECT A.PRODUCT_NAME 
	, A.LIST_PRICE 
	, ROUND((SELECT AVG(B.LIST_PRICE) 
				FROM PRODUCTS B
				WHERE B.CATEGORY_ID = A.CATEGORY_ID 
			),2) AS AVG_LIST_PRICE 
FROM PRODUCTS A
ORDER BY A.PRODUCT_NAME 
;

-- 인라인 뷰 서브 쿼리 
-- 제품의 단위 가격과 수량을 곱합 값을 ORDER_VALUE라고 함 

SELECT ORDER_ID
	,SUM(QUANTITY * UNIT_PRICE) ORDER_VALUE 
FROM ORDER_ITEMS 
GROUP BY ORDER_ID
ORDER BY ORDER_VALUE DESC 
;

-- WHERE ROWNUM 조건으로 정렬된 값 중에서 상위 10건을 출력함
SELECT ORDER_ID 
	,ORDER_VALUE
FROM 
(
	SELECT ORDER_ID
		,SUM(QUANTITY * UNIT_PRICE) ORDER_VALUE 
	FROM ORDER_ITEMS 
	GROUP BY ORDER_ID
	ORDER BY ORDER_VALUE DESC 
)
WHERE ROWNUM <= 10
;

-- PRODUCTS 테이블에서 LIST_PRICE(가격)의 평균 가격보다 큰 행(집합)을 출력하시오.
-- PRODUCT_ID, PRODUCT_NAME, LIST_PRICE  컬럼을 출력하고  PRODUCT_NAME으로 정렬하시오.
/*
 * 풀이 단계
 * 	- 1) PRODUCTS 테이블에서 LIST_PRICE 컬럼값의 평균 구하기
 * 	  2) 1)번에서 구한 쿼리문을 WHERE 조건절에 서브 쿼리로 활용
 * 		- LIST_PRICE 컬럼의 값이 서브 쿼리의 값보다 큰 집합 구함
 *	  3) ORDER BY문을 이용하여 PRODUCT_NAME 컬럼의 값으로 정렬함   
 */

SELECT AVG(B.LIST_PRICE) 
FROM PRODUCTS B 
;

SELECT A.PRODUCT_ID 
	, A.PRODUCT_NAME 
	, A.LIST_PRICE 
FROM PRODUCTS A
WHERE A.LIST_PRICE > (
						SELECT AVG(B.LIST_PRICE) 
						FROM PRODUCTS B						
					 )
ORDER BY A.PRODUCT_NAME 
;

-- CUSTOMERS 테이블에서 CREDIT_LIMIT의 값이 가장 큰 10건의 행을 출력하시오.
-- 단, CUSTOMERS 테이블의 모든 컬럼 출력
-- CREDIT_LIMIT이 동일하다면 NAME 컬럼을 기준으로 오름차순 정렬 출력하시오.
/*
 * 풀이 단계
 * 	- 1)CUSTOMERS 테이블의 CREDIT_LIMIT 컬럼을 내림차순, NAME을 오름차순으로 정렬하여 조회
 * 	  2) 1)에서 작성한 SELECT문을 인라인 뷰로 감싸기
 * 	  3) WHERE ROWNUM 조건으로 10건만 출력 	 	
 */

SELECT *
FROM CUSTOMERS c 
ORDER BY CREDIT_LIMIT DESC, NAME ASC 
;

SELECT *
FROM (
		SELECT *
		FROM CUSTOMERS c 
		ORDER BY CREDIT_LIMIT DESC, NAME ASC 
	)
WHERE ROWNUM <= 10	
;



