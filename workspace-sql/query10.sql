-- 부서명이 지원팀인 직원의 사원번호, 사원명, 부서코드, 부서명을 출력하시오.
SELECT A.EMP_NO 
	, A.EMP_NM 
	, A.DEPT_CD 
	, B.DEPT_NM 
FROM HM.TB_EMP A
	, HM.TB_DEPT B
WHERE A.DEPT_CD = B.DEPT_CD 
 AND B.DEPT_NM = '지원팀'
;

-- 부서명이 지원팀인 직원의 사원번호, 사원명, 부서코드, 부서명, 보유자격증 코드를 출력하시오. 
-- 3개의 테이블을 조인하는데 조인 조건은 최소 2개가 들어감 
SELECT 
	A.EMP_NO 
	, A.EMP_NM 
	, A.DEPT_CD 
	, B.DEPT_NM 
	, C.CERTI_CD 
FROM HM.TB_EMP A
	, HM.TB_DEPT B
	, HM.TB_EMP_CERTI C
WHERE A.DEPT_CD = B.DEPT_CD 
 AND A.EMP_NO = C.EMP_NO 
 AND B.DEPT_NM = '지원팀'
;

-- 부서명이 지원팀인 직원의 사원번호, 사원명, 부서코드, 부서명, 보유자격증 코드 및 자격증명을 출력하시오.
SELECT 
	A.EMP_NO 
	, A.EMP_NM 
	, A.DEPT_CD 
	, B.DEPT_NM 
	, C.CERTI_CD 
	, D.CERTI_NM 
FROM HM.TB_EMP A
	, HM.TB_DEPT B
	, HM.TB_EMP_CERTI C
	, HM.TB_CERTI D 
WHERE A.DEPT_CD = B.DEPT_CD 
 AND A.EMP_NO = C.EMP_NO 
 AND B.DEPT_NM = '지원팀'
 AND C.CERTI_CD = D.CERTI_CD 
;

-- INNER JOIN
-- 주소가 수원인 직원의 사원번호, 사원명, 주소, 부서코드, 부서명을 출력하시오.
SELECT A.EMP_NO 
	, A.EMP_NM 
	, A.ADDR 
	, B.DEPT_CD 
	, B.DEPT_NM 
FROM HM.TB_EMP A, HM.TB_DEPT B
WHERE A.DEPT_CD = B.DEPT_CD 
 AND A.ADDR LIKE '%수원%'
ORDER BY A.EMP_NO 
;

-- NATURAL JOIN 
-- 주소가 수원인 직원의 사원번호, 사원명, 주소, 부서코드, 부서명을 출력하시오.
SELECT A.EMP_NO 
	, A.EMP_NM 
	, A.ADDR 
	, DEPT_CD 
	, B.DEPT_NM 
FROM TB_EMP A NATURAL JOIN TB_DEPT B 
WHERE  A.ADDR LIKE '%수원%'
;

-- USING 절 
-- USING 절에 두 테이블이 공통적으로 가지고 있는 DEPT_CD 컬럼을 기재함 
-- 주소가 수원인 직원의 사원번호, 사원명, 주소, 부서코드, 부서명을 출력하시오.
SELECT A.EMP_NO 
	, A.EMP_NM 
	, A.ADDR 
	, DEPT_CD 
	, B.DEPT_NM 
FROM TB_EMP A JOIN TB_DEPT B USING (DEPT_CD)
WHERE  A.ADDR LIKE '%수원%'
;

-- ON 조건절 
-- 주소가 수원인 직원의 사원번호, 사원명, 주소, 부서코드, 부서명을 출력하시오.
SELECT A.EMP_NO 
	, A.EMP_NM 
	, A.ADDR 
	, B.DEPT_CD 
	, B.DEPT_NM 
FROM TB_EMP A JOIN TB_DEPT B ON (A.DEPT_CD = B.DEPT_CD)
WHERE  A.ADDR LIKE '%수원%'
;

-- 주소가 수원인 직원의 사원번호, 사원명, 주소, 부서코드, 부서명, 자격증 코드를 출력하시오.
SELECT 
	A.EMP_NO 
	,A.EMP_NM 
	,A.ADDR 
	,B.DEPT_CD 
	,B.DEPT_NM 
	,C.CERTI_CD 
FROM TB_EMP A
	,TB_DEPT B
	,TB_EMP_CERTI C
WHERE A.DEPT_CD = B.DEPT_CD 
 AND A.ADDR LIKE '%수원%'
 AND A.EMP_NO = C.EMP_NO 
ORDER BY A.EMP_NO 
;

SELECT 
	A.EMP_NO 
	,A.EMP_NM 
	,A.ADDR 
	,B.DEPT_CD 
	,B.DEPT_NM 
	,C.CERTI_CD 
FROM TB_EMP A JOIN TB_DEPT B
ON (A.DEPT_CD = B.DEPT_CD)
JOIN TB_EMP_CERTI C 
ON (A.EMP_NO = C.EMP_NO)
WHERE A.ADDR LIKE '%수원%'
;








