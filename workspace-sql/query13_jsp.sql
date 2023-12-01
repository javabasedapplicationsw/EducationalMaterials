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

SELECT * FROM MEMBER WHERE ID = 'hm' AND PASS = '0305'; 



/*
 * 1. board 테이블 정의 
 * 
 * 컬럼명			데이터 타입			null 허용		 키		기본값		설명
 * --------------------------------------------------------------------------------------
	num			number			    N		기본키 			기본키
	title		varchar2(200)		N						제목
	content		varchar2(2000)		N						내용
	id			varchar2(10)		N		외래키				작성자 아이디
															member 테이블의 id를 참조하는 외래키
	postdate	date				N				sysdate	작성일
	visitCount	number(6)									조회수 															
 * --------------------------------------------------------------------------------------
 * 
 * 	number : 전체 자릿수를 지정하지 않은 상태로 컬럼을 생성하면, 입력한 값만큼 공간이 자동으로 할당됨
 *  number(6) : 소수점을 포함한 전체 자릿수를 6으로 지정함
 *  id 컬럼 : member 테이블에서 기본키로 사용 중인 id 컬럼을 외래키로 지정
 * 			=> 각각의 게시글을 특정 회원과 연결지음 
 * 			=> 회원이 아닌 사람은 글을 게시할 수 없도록 DBMS가 보장해줌 
 * 
 * 2. 시퀀스 
 * 	- 일련번호용 객체 
 * 	- 순차적으로 증가하는 순번을 생성해 중복되지 않응 정수값을 반환하는 데이터베이스 객체임.
 * */

CREATE TABLE board 
(
	num NUMBER 	PRIMARY KEY
	,title varchar2(200) NOT NULL
	,content varchar2(2000) NOT NULL 
	,id varchar2(10) NOT NULL 
	,postdate DATE DEFAULT sysdate NOT NULL 
	,visitCount number(6)
);

ALTER TABLE BOARD 
	ADD CONSTRAINT fk_board_mem FOREIGN key(id)
	REFERENCES member(id);

CREATE SEQUENCE seq_board_num
    INCREMENT by 1          -- 1씩 증가
    START WITH 1            -- 시작값 1
    MINVALUE 1              -- 최솟값 1
    NOMAXVALUE              -- 최댓값은 무한대 
    NOCYCLE                 -- 순환되지 않음
    NOCACHE                 -- 캐시 안함 (메모리에 시퀀스 값을 미리 할당하지 않음)
	;

SELECT COUNT(*) FROM BOARD WHERE TITLE LIKE '%2024%'
;

SELECT COUNT(*) 
FROM BOARD 
WHERE title LIKE '%2024%'
;


-- dummy data 
INSERT INTO HM.BOARD
(NUM, TITLE, CONTENT, ID, POSTDATE, VISITCOUNT)
VALUES(seq_board_num.nextval, '아듀 2023년', '다사다난한 한해였습니다.', 'hm', sysdate , 0);

INSERT INTO HM.BOARD
(NUM, TITLE, CONTENT, ID, POSTDATE, VISITCOUNT)
VALUES(seq_board_num.nextval, '웰컴 2024년', '희망찬 한해를 맞이합니다', 'hm', sysdate , 0);

INSERT INTO HM.BOARD
(NUM, TITLE, CONTENT, ID, POSTDATE, VISITCOUNT)
VALUES(seq_board_num.nextval, '아듀 2024년', '다사다난한 한해였습니다2.', 'hm', sysdate , 0);

INSERT INTO HM.BOARD
(NUM, TITLE, CONTENT, ID, POSTDATE, VISITCOUNT)
VALUES(seq_board_num.nextval, '웰컴 2025년', '희망찬 한해를 맞이합니다2.', 'hm', sysdate , 0);


SELECT * FROM BOARD WHERE title LIKE '%2024%' ORDER BY num desc
;

SELECT * 
FROM BOARD 
WHERE title LIKE '%2024%'
ORDER BY num desc
;


INSERT INTO BOARD (NUM, TITLE, CONTENT, ID, VISITCOUNT) VALUES(seq_board_num.nextval, '아듀 2025년', '다사다난한 한해였습니다3.', 'hm', 0);

SELECT b.*, m.NAME 
FROM MEMBER m INNER JOIN BOARD b 
ON m.ID = b.ID 
WHERE b.NUM = 1
;

UPDATE BOARD SET VISITCOUNT = VISITCOUNT + 1
WHERE num = 7
;

SELECT * FROM BOARD;
UPDATE BOARD SET TITLE = '홍게 무제한 메뉴', CONTENT = '홍게 + 홍게 라면 + 홍게주먹밥 무제한 음식이네요'
WHERE NUM = 9
;

UPDATE BOARD SET TITLE = ?, CONTENT = ?  WHERE NUM = ?

DELETE FROM BOARD WHERE num = 7;
ROLLBACK;

-- rownum
SELECT ID , PASS , rownum FROM MEMBER;
SELECT NUM ,TITLE , rownum FROM BOARD;


SELECT * FROM BOARD ORDER BY num DESC
;

SELECT A.*, rownum rNum
FROM (
	SELECT * FROM BOARD ORDER BY num DESC
) A
;

SELECT *
FROM (
	SELECT A.*, rownum rNum
	FROM (
		SELECT * FROM BOARD ORDER BY num DESC
	) A
)
WHERE rNum BETWEEN 1 AND 10
;

SELECT *
FROM (
	SELECT A.*, rownum rNum
	FROM (
		SELECT * FROM BOARD ORDER BY num DESC
	) A
)
WHERE rNum BETWEEN 11 AND 20
;







SELECT * FROM (
	SELECT A.*, rownum rNum FROM (
		SELECT * FROM BOARD 
		
		
		
		
		ORDER BY num DESC
	) A
)
WHERE rNum BETWEEN 1 AND 10
;


/*
 * 	hifile 테이블 정의서 (첨부파일 업로드 및 다운로드 용도)
 * -----------------------------------------------------------------------------------------
 * 	컬럼명			데이터 타입			null허용			키		기본값			설명
 * -----------------------------------------------------------------------------------------
 * 	 id		   number		       N		   기본키 	              일련번호. 기본키
 *   title	   varchar2(200)	   N							  제목
 * 	 category  varchar2(30) 				 					  카테고리	  
 * 	 ofile	   varchar2(100)	   N							  원본파일명(original filename)  
 *   sfile	   varchar2(30)        N				              저장된 파일명(saved filename)
 *   postdate	date			   N					sysdate	  등록된 날짜 
 * 
 */

DROP TABLE hifile PURGE;
CREATE TABLE hifile 
(
	id 		NUMBER		PRIMARY KEY
	,title	varchar2(200)	NOT NULL
	,category	varchar2(30)	
	,ofile	varchar2(100) NOT NULL
	,sfile	varchar2(30) NOT NULL
	,postdate	DATE	DEFAULT sysdate NOT NULL 

);

select seq_board_num.nextval
from dual
;

INSERT INTO HM.HIFILE (ID, TITLE, CATEGORY, OFILE, SFILE, POSTDATE)
VALUES(seq_board_num.nextval, '강아지', '사진', 'puppy.jpg', '20231123', sysdate );

SELECT * FROM HIFILE;

SELECT * FROM HIFILE ORDER BY id DESC 
;

-----------------------------------------------------------------
-- mvcboard (모델2 방식, 파일첨부형 게시판 테이블)
DROP TABLE mvcboard PURGE;
CREATE TABLE mvcboard
(
	id 		NUMBER  	PRIMARY KEY
	,name	varchar2(50)	NOT NULL 
	,title	varchar2(200)	NOT NULL
	,content	varchar2(2000) NOT NULL 
	,postdate	DATE	DEFAULT sysdate NOT NULL 
	,ofile		varchar2(200)
	,sfile		varchar2(30)
	,downcount	number(5)	DEFAULT 0 NOT NULL 
	,pass 		varchar2(50) NOT NULL 
	,visitcount	NUMBER  DEFAULT 0 NOT NULL 
);

INSERT INTO HM.MVCBOARD (ID, NAME, TITLE, CONTENT, PASS)
VALUES(seq_board_num.nextval, '이순신', '2023년 12월', '올해 한달 남았습니다...', '0305');
INSERT INTO HM.MVCBOARD (ID, NAME, TITLE, CONTENT, PASS)
VALUES(seq_board_num.nextval, '류성룡', '2024년 1월', '1월입니다...', '0305');
INSERT INTO HM.MVCBOARD (ID, NAME, TITLE, CONTENT, PASS)
VALUES(seq_board_num.nextval, '이방원', '2024년 2월', '2월입니다...', '0305');
INSERT INTO HM.MVCBOARD (ID, NAME, TITLE, CONTENT, PASS)
VALUES(seq_board_num.nextval, '신사임당', '2024년 3월', '3월입니다...', '0305');
INSERT INTO HM.MVCBOARD (ID, NAME, TITLE, CONTENT, PASS)
VALUES(seq_board_num.nextval, '이성계', '2024년 4월', '4월입니다...', '0305');

SELECT * FROM MVCBOARD;
SELECT * FROM MVCBOARD WHERE id='145';

--INSERT INTO MVCBOARD (ID, NAME, TITLE, CONTENT,OFILE ,SFILE, PASS)
--VALUES(seq_board_num.nextval, ?, ?, ?, ?, ?, ?);

UPDATE MVCBOARD SET VISITCOUNT = VISITCOUNT + 1 WHERE id = '145'
;


UPDATE MVCBOARD SET DOWNCOUNT = DOWNCOUNT + 1 WHERE ID = '147'
;

SELECT count(*) FROM MVCBOARD WHERE pass = '0304' AND ID = '147'
;

DELETE FROM MVCBOARD WHERE ID = '142'
;
ROLLBACK;


UPDATE MVCBOARD SET TITLE='굿바이 11월2', NAME='이성계2', CONTENT='굿바이 11월, 웰컴 12월', OFILE='', SFILE=''
WHERE ID='147' AND PASS ='0305';
ROLLBACK;







