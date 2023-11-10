/*
 * member 테이블 정의 
 * 
 * 컬럼명			데이터 타입			null 허용		기본값		설명
 * ---------------------------------------------------------
 * id			varchar2(10)	  N					아이디
 * pass			varchar2(10)	  N 				패스워드
 * name			varchar2(30)	  N 				이름
 * regidate		date			  N		  sysdate	가입 날짜
 * ---------------------------------------------------------	
 * 
 * */

CREATE TABLE MEMBER 
(
	id	varchar2(10) NOT NULL 
	,pass varchar2(10) NOT NULL
	,name varchar2(30) NOT NULL
	,regidate DATE DEFAULT sysdate NOT NULL
	,PRIMARY key(id)
)
;

INSERT INTO MEMBER VALUES ('himedia', '0305', '하이미디어', sysdate);
SELECT * FROM MEMBER;
ROLLBACK;
SELECT * FROM MEMBER;

SELECT ID, PASS, NAME, REGIDATE FROM MEMBER;






















