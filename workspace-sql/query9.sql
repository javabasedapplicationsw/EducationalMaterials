-- 사원들 중 가장 생일이 늦은 사원과 빠른 사원 그리고 총 사원수를 구하시오.
SELECT MAX(BIRTH_DE)		-- 나이가 가장 어린 사원
	, MIN(BIRTH_DE)			-- 나이가 가장 많은 사원 
	, COUNT(*) 
FROM TB_EMP
;

-- 사원들 중 부서 코드 별 가장 늦은 생일, 가장 빠른 생일, 직원 수를 출력하시오.
-- 부서 코드, 부서 명, 부서별 가장 늦은 생일, 부서별 가장 빠른 생일, 부서별 직원수
SELECT A.DEPT_CD 
FROM TB_EMP A
GROUP BY A.DEPT_CD 
;

SELECT A.DEPT_CD
	, MAX(A.BIRTH_DE) AS "가장 늦은 생년월일" 
FROM TB_EMP A
GROUP BY A.DEPT_CD 
;


SELECT A.DEPT_CD
	, MAX(A.BIRTH_DE) AS "가장 늦은 생년월일"
	, MIN(A.BIRTH_DE) AS "가장 빠른 생년월일" 
FROM TB_EMP A
GROUP BY A.DEPT_CD 
;


SELECT A.DEPT_CD
	, MAX(A.BIRTH_DE) AS "가장 늦은 생년월일"
	, MIN(A.BIRTH_DE) AS "가장 빠른 생년월일" 
	, COUNT(*) AS "직원수" 
FROM TB_EMP A
GROUP BY A.DEPT_CD 
;

SELECT A.DEPT_CD
	, (SELECT B.DEPT_NM FROM TB_DEPT B WHERE B.DEPT_CD = A.DEPT_CD) AS DEPT_NM  -- 스칼라 서브쿼리
	, MAX(A.BIRTH_DE) AS "가장 늦은 생년월일"
	, MIN(A.BIRTH_DE) AS "가장 빠른 생년월일" 
	, COUNT(*) AS "직원수" 
FROM TB_EMP A
GROUP BY A.DEPT_CD 
ORDER BY A.DEPT_CD 
;


-- DEPT_CD컬럼을 SELECT절에 기재하면서 집계 함수를 쓰면 그룹핑 대상이 없기 때문에 SQL 에러 발생함  
SELECT A.DEPT_CD
	, (SELECT B.DEPT_NM FROM TB_DEPT B WHERE B.DEPT_CD = A.DEPT_CD) AS DEPT_NM  -- 스칼라 서브쿼리
	, MAX(A.BIRTH_DE) AS "가장 늦은 생년월일"
	, MIN(A.BIRTH_DE) AS "가장 빠른 생년월일" 
	, COUNT(*) AS "직원수" 
FROM TB_EMP A
--GROUP BY A.DEPT_CD 
ORDER BY A.DEPT_CD 
;


SELECT /*A.DEPT_CD
	, (SELECT B.DEPT_NM FROM TB_DEPT B WHERE B.DEPT_CD = A.DEPT_CD) AS DEPT_NM  -- 스칼라 서브쿼리
	,*/ MAX(A.BIRTH_DE) AS "가장 늦은 생년월일"
	, MIN(A.BIRTH_DE) AS "가장 빠른 생년월일" 
	, COUNT(*) AS "직원수" 
FROM TB_EMP A
--GROUP BY A.DEPT_CD 
ORDER BY A.DEPT_CD 
;


/*
 * 그룹핑 한 결과에서 COUNT(*)가 1보다 큰 집합만 출력하시오.
 * 즉 부서의 직원수가 1명을 초과하는 부서의 집계 데이터를 출력하시오.
 */
SELECT A.DEPT_CD
	, (SELECT B.DEPT_NM FROM TB_DEPT B WHERE B.DEPT_CD = A.DEPT_CD) AS DEPT_NM  -- 스칼라 서브쿼리
	, MAX(A.BIRTH_DE) AS "가장 늦은 생년월일"
	, MIN(A.BIRTH_DE) AS "가장 빠른 생년월일" 
	, COUNT(*) AS "직원수" 
FROM TB_EMP A
GROUP BY A.DEPT_CD 
HAVING (COUNT(*)) > 1
ORDER BY A.DEPT_CD 
;

-- 부서의 직원수가 1명인 부서의 집계 데이터를 출력하시오.
SELECT A.DEPT_CD
	, (SELECT B.DEPT_NM FROM TB_DEPT B WHERE B.DEPT_CD = A.DEPT_CD) AS DEPT_NM  -- 스칼라 서브쿼리
	, MAX(A.BIRTH_DE) AS "가장 늦은 생년월일"
	, MIN(A.BIRTH_DE) AS "가장 빠른 생년월일" 
	, COUNT(*) AS "직원수" 
FROM TB_EMP A
GROUP BY A.DEPT_CD 
HAVING (COUNT(*)) = 1
ORDER BY A.DEPT_CD 
;










