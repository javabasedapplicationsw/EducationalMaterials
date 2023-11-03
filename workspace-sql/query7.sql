-- 단일 행 서브 쿼리 
-- EMP_NO가 1000000005가 속한 팀의 팀원을 출력하시오.

SELECT DEPT_CD 
FROM TB_EMP 
WHERE EMP_NO = '1000000005'
;

SELECT A.EMP_NO , A.EMP_NM , A.DEPT_CD 
FROM TB_EMP A
WHERE A.DEPT_CD = 
				(
					SELECT DEPT_CD 
					FROM TB_EMP 
					WHERE EMP_NO = '1000000005'				
				)
;

-- 2020년 5월 기준 평균 이상의 급여(20200525)를 받고 있는 직원들의 리스트를 출력하시오.
-- EMP_NO, EMP_NM, PAY_DE, PAY_AMT

SELECT AVG(C.PAY_AMT) 
FROM HM.TB_SAL_HIS C
WHERE C.PAY_DE = '20200525'
;

-- 비 연관 서브 쿼리 
SELECT A.EMP_NO, A.EMP_NM , B.PAY_DE , B.PAY_AMT 
FROM HM.TB_EMP A, HM.TB_SAL_HIS B
WHERE B.PAY_DE =  '20200525'
AND B.PAY_AMT >= (
					SELECT AVG(C.PAY_AMT) 
					FROM HM.TB_SAL_HIS C
					WHERE C.PAY_DE = '20200525'
				 )
AND A.EMP_NO  = B.EMP_NO 
;

-- 다중 행 서브 쿼리
-- 한국데이터베이스진흥원에서 발급한 자격증을 가지고 있는 
-- 사원 번호 및 보유 자격 개수를 출력하시오.
SELECT B.CERTI_CD 
FROM HM.TB_CERTI B
WHERE B.ISSUE_INSTI_NM ='한국데이터베이스진흥원'
;

-- 비 연관 서브 쿼리 
SELECT A.EMP_NO, COUNT(*) 
FROM TB_EMP_CERTI A
WHERE A.CERTI_CD 
IN
(
	SELECT B.CERTI_CD 
	FROM HM.TB_CERTI B
	WHERE B.ISSUE_INSTI_NM ='한국데이터베이스진흥원'
)
GROUP BY A.EMP_NO 
ORDER BY A.EMP_NO 
;



-- 에러 발생
-- 다중 행 서브 쿼리에 = 연산자를 사용했음 
SELECT A.EMP_NO, COUNT(*) 
FROM TB_EMP_CERTI A
WHERE A.CERTI_CD 
=
(
	SELECT B.CERTI_CD 
	FROM HM.TB_CERTI B
	WHERE B.ISSUE_INSTI_NM ='한국데이터베이스진흥원'
)
GROUP BY A.EMP_NO 
ORDER BY A.EMP_NO 
;

-- 다중 컬럼 서브 쿼리
-- 비 연관 서브 쿼리
-- 한 부서에 2명 이상 있는 부서 중에서 각 부서의 생일 기준 가장 나이가 많은 사원을 출력하시오.
-- EMP_NO, EMP_NM, DEPT_CD, DEPT_NM, BIRTH_DE
SELECT C.DEPT_CD, MIN(C.BIRTH_DE) AS MIN_BIRTH_DE  
FROM TB_EMP C
GROUP BY DEPT_CD 
HAVING COUNT(*) > 1 			-- 한 부서에 2명 이상 있는 부서
;

SELECT A.EMP_NO 
	, A.EMP_NM 
	, A.DEPT_CD 
	, B.DEPT_NM 
	, A.BIRTH_DE 
FROM TB_EMP A, TB_DEPT B
WHERE (A.DEPT_CD, A.BIRTH_DE) IN 
(
		SELECT C.DEPT_CD, MIN(C.BIRTH_DE) AS MIN_BIRTH_DE  
		FROM TB_EMP C
		GROUP BY DEPT_CD 
		HAVING COUNT(*) > 1 			-- 한 부서에 2명 이상 있는 부서
)
AND A.DEPT_CD = B.DEPT_CD 
ORDER BY A.EMP_NO
;

-- 연관 서브 쿼리 (서브 쿼리가 메인 쿼리의 값을 가지고 있는 형태의 서브쿼리)
-- EXISTS 서브 쿼리 
-- 예) 직원들 중 주소가 강남인 직원이 소속된 부서코드와 부서명을 출력하시오.
SELECT A.DEPT_CD, A.DEPT_NM 
FROM TB_DEPT A
WHERE EXISTS (
				SELECT 1
				FROM TB_EMP B
				WHERE A.DEPT_CD = B.DEPT_CD 
				AND B.ADDR LIKE '%강남%'
			 )
;

SELECT *
FROM TB_EMP
WHERE DEPT_CD = '100009'
;

SELECT *
FROM TB_EMP
WHERE DEPT_CD = '100010'
;

-- 스칼라 서브 쿼리
-- '한국데이터베이스진흥원'에서 발급한 자격증을 가지고 있는 사원의 사원번호,사원명,
--  자격증 코드, 자격증명을 출력하시오.
SELECT A.EMP_NO 
	, A.CERTI_CD 
FROM TB_EMP_CERTI A
WHERE A.CERTI_CD  IN (
						SELECT B.CERTI_CD 
						FROM HM.TB_CERTI B
						WHERE B.ISSUE_INSTI_NM ='한국데이터베이스진흥원'
					 )
;



SELECT A.EMP_NO
	, (SELECT C.EMP_NM FROM TB_EMP C WHERE C.EMP_NO = A.EMP_NO) AS EMP_NM
	, A.CERTI_CD 
FROM TB_EMP_CERTI A
WHERE A.CERTI_CD  IN (
						SELECT B.CERTI_CD 
						FROM HM.TB_CERTI B
						WHERE B.ISSUE_INSTI_NM ='한국데이터베이스진흥원'
					 )
;

-- 스칼라 서브 쿼리
SELECT A.EMP_NO
	, (SELECT C.EMP_NM FROM TB_EMP C WHERE C.EMP_NO = A.EMP_NO) AS EMP_NM
	, A.CERTI_CD
	, (SELECT D.CERTI_NM FROM TB_CERTI D WHERE D.CERTI_CD = A.CERTI_CD) AS CERTI_NM
FROM TB_EMP_CERTI A
WHERE A.CERTI_CD  IN (
						SELECT B.CERTI_CD 
						FROM HM.TB_CERTI B
						WHERE B.ISSUE_INSTI_NM ='한국데이터베이스진흥원'
					 )
ORDER BY CERTI_NM 					 
;


-- 인라인 뷰 서브 쿼리
SELECT A.EMP_NO
	, (SELECT C.EMP_NM FROM TB_EMP C WHERE C.EMP_NO = A.EMP_NO) AS EMP_NM
	, A.CERTI_CD
	, (SELECT D.CERTI_NM FROM TB_CERTI D WHERE D.CERTI_CD = A.CERTI_CD) AS CERTI_NM
FROM  
	(
		SELECT B.CERTI_CD 
		FROM HM.TB_CERTI B
		WHERE B.ISSUE_INSTI_NM ='한국데이터베이스진흥원'	
	) E
	, TB_EMP_CERTI A
WHERE A.CERTI_CD = E.CERTI_CD  
ORDER BY CERTI_NM 					 
;

-- HAVING절에서의 서브 쿼리
-- 2020년 5월의 100004(디자인팀) 부서의 평균 급여보다 평균급여가 높은 부서의 
-- 부서코드와 부서명과 평균급여를 출력하시오.

-- 2020년 5월의 100004(디자인팀) 부서의 평균 급여 (3462500)
SELECT AVG(A.PAY_AMT) 
FROM HM.TB_SAL_HIS A, HM.TB_EMP B
WHERE A.EMP_NO = B.EMP_NO 
 AND A.PAY_DE = '20200525'
 AND B.DEPT_CD = '100004'
 ;

SELECT B.DEPT_CD
	, (
		SELECT L.DEPT_NM 
		FROM TB_DEPT L 
		WHERE L.DEPT_CD = B.DEPT_CD 
	  ) "부서명"
	, AVG(A.PAY_AMT) "평균급여"  
FROM HM.TB_SAL_HIS A, TB_EMP B
WHERE A.PAY_DE = '20200525'
 AND A.EMP_NO = B.EMP_NO 
GROUP BY B.DEPT_CD 
;




SELECT B.DEPT_CD
	, (
		SELECT L.DEPT_NM 
		FROM TB_DEPT L 
		WHERE L.DEPT_CD = B.DEPT_CD 
	  ) "부서명"
	, AVG(A.PAY_AMT) "평균급여"  
FROM HM.TB_SAL_HIS A, TB_EMP B
WHERE A.PAY_DE = '20200525'
 AND A.EMP_NO = B.EMP_NO 
GROUP BY B.DEPT_CD 
HAVING AVG(A.PAY_AMT) > 
(
	SELECT AVG(A.PAY_AMT) 
	FROM HM.TB_SAL_HIS A, HM.TB_EMP B
	WHERE A.EMP_NO = B.EMP_NO 
	 AND A.PAY_DE = '20200525'
	 AND B.DEPT_CD = '100004'
)
ORDER BY "평균급여" DESC 
;




				
				
				
				