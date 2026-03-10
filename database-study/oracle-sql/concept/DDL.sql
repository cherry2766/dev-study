-- 동일 이름으로 테이블 구성 불가능
CREATE TABLE product(
    prdNo VARCHAR2(10) NOT NULL,
    prdName VARCHAR2(30) NOT NULL,
    prdPrice NUMBER(8),
    prdCompany VARCHAR(30),
    CONSTRAINT PK_product_prdNo PRIMARY KEY(prdNo)
    ); 
-- 모든 쿼리는 ;으로 종료해야 함
-- 기본키는 특정 속성에 지정
-- 중복 X null X
-- 기본키 지정 방법
-- 1. CONSTRAINT PK_product_prdNo PRIMARY KEY(prdNo)
-- 2. 속성 옆에 PRIMARY KEY 지정
-- 3. 구성 마지막에 PRIMARY KEY(prdNo)만 추가

-- 2
CREATE TABLE product1(
    prdNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    prdName VARCHAR2(30) NOT NULL,
    prdPrice NUMBER(8),
    prdCompany VARCHAR(30)
    );
    
-- 3
CREATE TABLE product2(
    prdNo VARCHAR2(10) NOT NULL,
    prdName VARCHAR2(30) NOT NULL,
    prdPrice NUMBER(8),
    prdCompany VARCHAR(30),
    PRIMARY KEY(prdNo)
    );
    
--4(권장하지 않음)
CREATE TABLE product3(
    prdNo VARCHAR2(10) NOT NULL CONSTRAINT PK_product_prdNo1 PRIMARY KEY,
    prdName VARCHAR2(30) NOT NULL,
    prdPrice NUMBER(8),
    prdCompany VARCHAR(30)
    );
    
/*
    출판사 테이블 생성(출판사 번호, 출판사 명)
    제약조건
        - 기본키 pubNo, NOT NULL
        - pubName NOT NULL
*/
-- 데이터 삽입시 컬럼의 값은 비워질 수 있도록 기본 구성
-- 필수값이면 NOT NULL
CREATE TABLE publisher(
    pubNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    pubName VARCHAR2(30) NOT NULL
);

/*
    도서 테이블 (book)
    1개의 도서는 출판사에서 발행
    서점은 거래하는 출판사가 존재함
    기본키 : 도서번호(bookNo)
    외래키 : 출판사 테이블의 출판사 번호(pubN0)
*/
-- 외래키(참조무결성) 제약조건 추가 : CONSTRAINT 제약조건 식별자 제약조건종류
-- 기본값:DEFAULT, CHECK()
-- 제약조건 식별자 : 기본키 PK로 시작, 왜래키(참조무결성) FK
-- REFERENCES 참조할 테이블(테이블의 기본키)
CREATE TABLE book(
    bookNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    bookName VARCHAR2(30) NOT NULL,
    bookPrice NUMBER(8) DEFAULT 10000 CHECK(bookPrice>1000),
    bookDate DATE,
    pubNo VARCHAR2(10) NOT NULL,
    CONSTRAINT FK_book_publisher FOREIGN KEY(pubNo) REFERENCES publisher(pubNo)
    );
    
-- book 테이블에서 publisher 테이블을 참조하고 있음
-- 테이블 생성시 참조관계가 필요하면 참조되는 테이블(publisher) 먼저 생성해야 함
-- 데이터 입력
-- 참조되는 테이블의 데이터가 먼저 입력되어 있어야 함
-- 참조하는 테이블의 데이터가 입력될 때 참조무결성 제약조건 확인해야 하므로

/*
ALTER TABLE
ADD : 열 추가
DROP COLUMN : 열 삭제
DROP : 여러 개의 열 삭제
RENAME COLUMN : 열의 이름 변경
MODIFY : 열의 데이터 형식 변경
DROP PRIMARY KEY : 기본키 삭제
DROP CONSTRAINT : 제약조건 삭제
ADD CONSTRAINT : 제약조건 추가
*/

-- 열(속성)추가 : ADD
ALTER TABLE product ADD (prdUnitPrice NUMBER(8), prdStock NUMBER(12));

-- 속성(열) 데이터 형식 변경
ALTER TABLE product MODIFY prdUnitPrice NUMBER(4);

-- 열의 제약조건 변경 (prdName NOT NULL -> NULL)
ALTER TABLE product MODIFY prdName VARCHAR2(30) NULL;

-- 컬럼명 변경 : RENAME COLUMN 기존컬럼명 TO 새컬럼명
ALTER TABLE product RENAME COLUMN prdUnitPrice TO prdUprice;

-- 컬럼(열) 삭제
ALTER TABLE product DROP COLUMN prdStock;

-- 여러 열 삭제
ALTER TABLE product DROP (prdUprice, prdCompany);

-- 제약조건 삭제 : 기본키 DROP PRIMARY KEY
-- SQL 문법 상 기본키 제약조건 없어도 오류는 없음 단, 관계형 데이터베이스의 릴레이션 특징 유지하기 위해서는 기본키는 설정해야 함
ALTER TABLE product DROP PRIMARY KEY;

-- 참조무결성(외래키 제약조건)으로 참조되어 있는 경우에는 기본키 제약조건 삭제 불가
-- publisher는 book이 참조하고 있음
ALTER TABLE publisher DROP PRIMARY KEY;
-- 오류 보고 - ORA-02273: 고유/기본 키가 외부 키에 의해 참조되었습니다

-- 참조하고 있어도 무조건 기본키 삭제 : CASCADE - 권장하지 않음
-- 참조되고 있는 테이블의 기본키가 삭제되면, 논리적으로 위배되는 내용 해결 위해 참조하는 테이블의 외래키 제약조건도 같이 삭제됨
ALTER TABLE publisher DROP PRIMARY KEY CASCADE;

-- 제약조건 추가 : 기본키 추가
ALTER TABLE publisher ADD CONSTRAINT PK_publisher_pubNo PRIMARY KEY(pubNo);

-- 제약조건 추가 : 외래키 추가
ALTER TABLE book ADD CONSTRAINT FK_book_publisher FOREIGN KEY(pubNo) REFERENCES publisher(pubNo);

------------------------------------------------------------------------------------------------------------
/* 
테이블 삭제 : 테이블의 모든 구조와 모든 데이터 삭제 
데이터만 삭제 : DML문의 DELETE문 
삭제 쿼리 : DROP TABLE 테이블명 [PURGE | CASCADE CONSTRAINTS]
PURGE : 복구 가능한 임시 테이블 생성하지 않고 영구히 삭제
CASCADE CONSTRAINTS : 테이블이 다른 테이블에 의해 참조되고 있어도 강제 삭제, 권장하지 않음
*/
-- unique/primary keys in table referenced by foreign keys
DROP TABLE publisher; -- 참조되는 테이블 삭제 불가능
DROP TABLE publisher CASCADE CONSTRAINTS; -- 참조 상관없이 삭제

-- 참조되지 않는 테이블
DROP TABLE product;

-------------------------------------------------------------------------------------------
/*
시퀀스

데이터베이스 객체로 유일한 값으로 일련번호 생성
지정된 수치로 증가하거나 감소
기본키 값을 일련번호로 자동 생성할 때 사용
최대 15개까지 생성 가능
테이블과 독립적으로 저장되고 생성
하나의 시퀀스를 여러 테이블에서 사용 가능

CREATE SEQUENCE 시퀀스식별자
    STRAT WITH 시작숫자
    INCREMENT BY 증가감값
    MAXVALUE 최대값
    MINVALUE 최소값
    CYCLE/NOCYCLE -> 최대값 or 최소값 다다랐을 경우 순환할 것인지의 여부
*/

CREATE SEQUENCE NO_SEQ
    START WITH 1
    INCREMENT BY 1
    MAXVALUE 10000
    MINVALUE 1
    NOCYCLE;
    
/*
현재 시퀀스 값 검색 : 현재까지 사용한 시퀀스 값
    SELECT NO_SEQ.CURRVAL
    FROM dual
    사용해야 함
*/

    SELECT NO_SEQ.CURRVAL
    FROM dual;
    
-- 시퀀스 수정 : 구조 수정(객체 수정이므로 ALTER)
ALTER SEQUENCE NO_SEQ
    MAXVALUE 1000;
    
-- 시퀀스 구조 속성 검색 (ALTER로 수정한 구조 속성 확인)
-- user_SEQUENCES : SYSTEM TABLE 활용(일반 사용자 검색 권한 있음)
SELECT SEQUENCE_NAME,MAX_VALUE
FROM USER_SEQUENCES;

-- 시퀀스 삭제
DROP SEQUENCE NO_SEQ;

-- 시퀀스 삭제 결과확인
SELECT SEQUENCE_NAME FROM USER_SEQUENCES;

--SELECT는 반환되는 레코드가 없어도 빈 객체를 반환함






























