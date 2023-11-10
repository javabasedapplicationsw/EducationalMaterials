-- TCL (TRANSACTION CONTROL LANGUAG)

INSERT INTO HM.TB_CERTI T (T.CERTI_CD, T.CERTI_NM, T.ISSUE_INSTI_NM)
VALUES ('100022', 'SQL지식보유자', '하이미디어');

SELECT *
FROM HM.TB_CERTI A
WHERE A.CERTI_CD = '100022'
;

COMMIT;

--------------------------------------------------------
UPDATE HM.TB_CERTI 
 SET CERTI_NM = 'SQL경험보유자'
 WHERE CERTI_CD = '100022'
 ;

COMMIT;

--------------------------------------------------------
DELETE FROM HM.TB_CERTI 
WHERE CERTI_CD = '100022'
;

COMMIT;

--------------------------------------------------------
INSERT INTO HM.TB_CERTI T (T.CERTI_CD, T.CERTI_NM, T.ISSUE_INSTI_NM)
VALUES ('100022', 'SQL지식보유자', '하이미디어');

ROLLBACK;

--------------------------------------------------------
SAVEPOINT SVPT1;		-- 여기가 세이브 포인트 지점 

INSERT INTO HM.TB_CERTI T (T.CERTI_CD, T.CERTI_NM, T.ISSUE_INSTI_NM)
VALUES ('100022', 'SQL지식보유자', '하이미디어');

UPDATE HM.TB_CERTI 
 SET CERTI_NM = 'SQL경험보유자'
 WHERE CERTI_CD = '100022'
 ;

ROLLBACK TO SVPT1;		-- 세이브 포인트 지점으로 롤백, INSERT및 UPDATE는 모두 롤백 됨 

SELECT *						-- 공집합이 나오게 됨
FROM HM.TB_CERTI A
WHERE A.CERTI_CD = '100022'
;

DELETE FROM HM.TB_CERTI 		-- 삭제 실패(데이터가 존재하지 않음)
WHERE CERTI_CD = '100022'
;

--------------------------------------------------------
SAVEPOINT SVPT1;   -- INSERT(저장) 직전에 세이브 포인트 

INSERT INTO HM.TB_CERTI T (T.CERTI_CD, T.CERTI_NM, T.ISSUE_INSTI_NM)
VALUES ('100022', 'SQL지식보유자', '하이미디어');

SAVEPOINT SVPT2;	-- 수정 직전에 세이브 포인트 

UPDATE HM.TB_CERTI 
 SET CERTI_NM = 'SQL경험보유자'
 WHERE CERTI_CD = '100022'
 ;

SAVEPOINT SVPT3;	-- 삭제하기 바로 직전에 세이브 포인트 

DELETE FROM HM.TB_CERTI 		
WHERE CERTI_CD = '100022'
;

ROLLBACK TO SVPT3;
SELECT * FROM HM.TB_CERTI A WHERE A.CERTI_CD = '100022'			-- SQL경험보유자
;

ROLLBACK TO SVPT2;
SELECT * FROM HM.TB_CERTI A WHERE A.CERTI_CD = '100022';		-- SQL지식보유자

ROLLBACK TO SVPT1;		-- 데이터 없음
SELECT * FROM HM.TB_CERTI A WHERE A.CERTI_CD = '100022';		-- 공집합
