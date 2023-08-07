-- 회원정보 테이블
-- 아이디, 이름, 패스워드, 회원가입일, 별명, 핸드폰번호, 성별, 생일,  이메일, 유저등급, 접속아이피, 접속일, 비밀번호 변경일, 주소
DROP TABLE if exists MEMBER;
CREATE TABLE MEMBER
(
    id varchar(255) NOT NULL
    , name varchar(255) not null
    , password varchar(255) not null
    , register_date timestamp not null
    , nickname varchar(255)
    , phone varchar(255)
    , sex char(1)
    , birth varchar(255)
    , email varchar(255)
    , rank char(1)
    , ip varchar(255)
    , login_date timestamp
    , change_date timestamp
    , address_seq integer
    , primary key(id)
);


-- 장소 관리 테이블
-- PK, 지명, 우편번호, 주소, 상세주소, 도(시), 시(군, 구) GPS X, GPS Y
DROP TABLE if exists ADDRESS;
CREATE TABLE ADDRESS
(
    seq integer NOT NULL
    , name varchar2(255)
    , zipcode integer NOT NULL
    , add1 varchar2(255) NOT NULL
    , add2 varchar2(255)
    , state varchar2(255)
    , city varchar2(255)
    , gpsx integer
    , gpsy integer
    , primary key(seq)
);

-- 게시물 테이블
-- PK, 게시물제목, 작성자, 작성시간, 수정시간, 게시물내용, 작성아이피
DROP TABLE if exists BOARD;
CREATE TABLE BOARD
(
    seq integer NOT NULL
    , title varchar2(255)
    , editor varchar2(255) NOT NULL
    , edit_time timestamp NOT NULL
    , modify_time timestamp
    , content varchar2(255)
    , ip varchar2(255)
    , primary key(seq)
);

-- 게시물 댓글 테이블
-- PK, 게시물제목, 작성자, 작성시간, 수정시간, 게시물내용, 작성아이피
DROP TABLE if exists BOARD_COMMENT;
CREATE TABLE BOARD_COMMENT
(
    seq integer NOT NULL
    , editor varchar2(255) NOT NULL
    , edit_time timestamp NOT NULL
    , modify_time timestamp
    , comment varchar2(255)
    , ip varchar2(255)
    , primary key(seq)
);