SELECT SYSDATE, SYSTIMESTAMP FROM dual;

-- 사용자 테이블 
DROP TABLE t_user;
CREATE TABLE t_user 
(
	id 		varchar(30)		NOT NULL PRIMARY KEY
	, pwd	varchar(50)
	, name	varchar(30)
	, email varchar(30)
	, birth	DATE
	, sns 	varchar(30)
	, reg_date DATE 
);

SELECT * FROM T_USER;



INSERT INTO HM.T_USER
(ID, PWD, NAME, EMAIL, BIRTH, SNS, REG_DATE)
VALUES('cheonho', '0305', 'cheonho', 'cheonho@gmail.com', '2000-12-22', 'youtube', sysdate);

INSERT INTO HM.T_USER
(ID, PWD, NAME, EMAIL, BIRTH, SNS, REG_DATE)
VALUES('cheonho2', '0305', 'cheonho2', 'cheonho2@gmail.com', '2000-11-22', 'fb', sysdate);

DELETE FROM T_USER
;

SELECT * FROM t_user WHERE ID = 'cheonHo';


DELETE FROM t_user WHERE id = 'cheonHo3';

UPDATE T_USER
SET PWD='', NAME='', EMAIL='', BIRTH='', SNS='', REG_DATE=''
WHERE ID='';

DROP TABLE TEMP ;
CREATE TABLE TEMP 
( KEY NUMBER NOT NULL PRIMARY KEY
, VALUE NUMBER)
;

SELECT * FROM TEMP;
COMMIT;

INSERT INTO TEMP("KEY", VALUE)
VALUES(1, 100);

COMMIT;

INSERT INTO HM.TEMP("KEY", VALUE)
VALUES(2, 200);

COMMIT;

DELETE FROM TEMP;

-- 테이블 생성, 데이터도 복사, PK는 복사안됨
DROP TABLE temp2;
CREATE TABLE temp2 AS SELECT * FROM TEMP;

-- 테이블만 생성
CREATE TABLE temp2 AS SELECT * FROM TEMP WHERE 1=2;

-- 게시판 테이블 및 시퀀스 생성
DROP SEQUENCE seq_board_num;
CREATE SEQUENCE seq_board_num
    INCREMENT by 1          -- 1씩 증가
    START WITH 1            -- 시작값 1
    MINVALUE 1              -- 최솟값 1
    NOMAXVALUE              -- 최댓값은 무한대 
    NOCYCLE                 -- 순환되지 않음
    NOCACHE                 -- 캐시 안함 (메모리에 시퀀스 값을 미리 할당하지 않음)
	;

DROP TABLE t_board CASCADE constraints;
CREATE TABLE t_board
(
	bno 		NUMBER(10)		PRIMARY KEY 
	,title		varchar2(200)	NOT NULL
	,content	varchar2(4000)	NOT NULL
	,writer		varchar2(30)	NOT NULL
	,view_cnt	number(6)		DEFAULT 0
	,comment_cnt	number(6)	DEFAULT 0
	,reg_date		DATE		DEFAULT sysdate NOT NULL 
	,up_date		DATE		DEFAULT sysdate
);

SELECT BNO , TITLE , CONTENT , WRITER , VIEW_CNT , COMMENT_CNT , REG_DATE 
FROM T_BOARD
;

delete FROM T_BOARD;

INSERT INTO T_BOARD
VALUES(seq_board_num.nextval, '오늘은 1월 2째주', 'ML 첫번째 프로젝트 진행중입니다. 중략...', 'gangdong02', 1, 3, sysdate , sysdate)
;

SELECT BNO , TITLE , CONTENT , WRITER , VIEW_CNT , COMMENT_CNT , REG_DATE 
FROM T_BOARD WHERE bno = 1
;

INSERT INTO T_BOARD 
	(bno, title, CONTENT, WRITER)
VALUES 
	(seq_board_num.nextval, '타이틀', '타이틀 내용', 'cheonho')
;	



--alter SEQUENCE seq_board_num increment by -2;		-- 현재값만큼 빼기
--select seq_board_num.nextval from dual;
--alter SEQUENCE seq_board_num increment by 1;	



SELECT * FROM user_sequences;

SELECT BNO , TITLE , CONTENT , WRITER , VIEW_CNT , COMMENT_CNT , REG_DATE 
FROM T_BOARD
ORDER BY REG_DATE DESC, BNO DESC 
;

SELECT COUNT(*) FROM T_BOARD; 

UPDATE T_BOARD 
SET VIEW_CNT = VIEW_CNT + 1
WHERE bno = 250
;


DELETE FROM T_BOARD
WHERE bno = '245' AND WRITER = 'cheonho'
;












