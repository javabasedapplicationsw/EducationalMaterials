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

SELECT COUNT(*) FROM BOARD WHERE TITLE LIKE '%아파트%'
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