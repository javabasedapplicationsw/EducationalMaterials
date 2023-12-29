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







