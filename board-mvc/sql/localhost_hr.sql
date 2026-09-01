/*
SPRING 웹프로젝트 : 게시판(tbl_table) 생성
번호, 제목, 작성자, 내용, 조회수, 등록일
*/

create table tbl_board(
no number (5) primary key
, title varchar2(200) not null
, writer varchar2(200) not null
,content varchar2(4000) not null
,view_cnt number (5) default 0
,reg_date date default sysdate
);

create sequence seq_tbl_board_no nocache;

INSERT INTO tbl_board(no,title,writer,content)
    VALUES(seq_tbl_board_no.nextval, '제목이요2', '홍길동', '내용입니다.');
    
INSERT INTO tbl_board(no,title,writer,content)
    VALUES(seq_tbl_board_no.nextval, '제목이요3', '김길동', '내용2입니다.');
    
INSERT INTO tbl_board(no,title,writer,content)
    VALUES(seq_tbl_board_no.nextval, '제목이요4', '이길동', '내용3입니다.');

commit;

SELECT * FROM tbl_board;


-- type : s(슈퍼유저), u(일반유저)
CREATE TABLE TBL_MEMBER(
	ID 				VARCHAR2(20) PRIMARY KEY,
    NAME 			VARCHAR2(20) NOT NULL,
    PASSWORD 		VARCHAR2(20) NOT NULL,
    EMAIL_ID 		VARCHAR2(30),
    EMAIL_DOMAIN 	VARCHAR2(20),
    TEL1 			CHAR(3),
    TEL2 			CHAR(4),
    TEL3 			CHAR(4),
    POST 			CHAR(5),
    BASIC_ADDR 		VARCHAR2(200),
    DETAIL_ADDR 	VARCHAR2(200),
    TYPE            CHAR(1) default 'U',
    REG_DATE 		DATE default sysdate
);

INSERT INTO tbl_member(id, name, password, email_id, email_domain, tel1,tel2,tel3,post,basic_addr,detail_addr)
    VALUES('dnwls7739', '천우진', '1234','dnwls7738','@naver.com','010','1234','5678','09876','성남시','중원구');
    
commit;

SELECT * FROM TBL_MEMBER;