/* 
데이터 조작어(DML): 데이터 입력/수정/삭제/조회
INSERT/UPDATE/DELETE/SELECT
*/

-- INSERT
-- 기본형식 : INSERT INTO 테이블명(컬럼명 리스트) VALUES (값 리스트);

-- 수업용 테이블

CREATE TABLE pub (
  pubNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    pubName VARCHAR2(30) NOT NULL
 );
 
INSERT INTO pub (pubNo, pubName) VALUES('1', '서울 출판사');
INSERT INTO pub (pubNo, pubName) VALUES('2', '강남 출판사');
INSERT INTO pub (pubNo, pubName) VALUES('3', '종로 출판사');

SELECT * FROM pub;

-- BOOK 테이블 외래키 추가
ALTER TABLE book ADD CONSTRAINT FK_book_publisher FOREIGN KEY(pubNo) REFERENCES pub(pubNo);
 
-- BOOK 테이블에 데이터 입력 : 모든 컬럼 값 입력
INSERT INTO book(bookNo, bookName, bookPrice,bookDate,pubNo) VALUES('5','자바스크립트','23000','2019-05-17','1');
SELECT * FROM book;
-- 모든 컬럼 값 입력할 경우 열 이름 생략 가능 : 컬림값이 1개라도 부족하면 오류
-- 컬럼값의 순서는 생성할 때 순서를 지켜줌
INSERT INTO book VALUES('6','C++프로그래밍','25000','2024-02-02','2');
SELECT * FROM book;

-- 여러개의 레코드를 한번에 INSERT
-- DBMS마다 차이가 있음
/*
    INSERT ALL
        INTO 테이블명([컬럼명 나열]) VALUES (값 나열) -- 쉼표 등 기호 없이 진행
        INTO 테이블명([컬럼명 나열]) VALUES (값 나열)
        INTO 테이블명([컬럼명 나열]) VALUES (값 나열) 
    SELECT * FROM DUAL; -- DUAL : 가상 테이블
*/
INSERT ALL
    INTO book VALUES ('7','알고리즘','25000','2023-02-04','1')
    INTO book VALUES ('8','웹프로그래밍','26000','2025-11-11','2')
SELECT * FROM DUAL;
SELECT * FROM book;

-- 일부 컬럼값만 삽입하려면 컬럼명은 추가되어야 함
INSERT INTO book(bookNo, bookName, bookDate, pubNo)
VALUES('9','C++프로그래밍','2024-02-02','2');
SELECT * FROM book;

INSERT INTO book VALUES('10','C++프로그래밍','1000','2024-02-02','2');

--------------------------------------------------------------------------------
-- INSERT시 SEQUENCE 사용 가능

-- 시퀀스 적용할 테이블 생성
CREATE TABLE board(
    bNO NUMBER PRIMARY KEY, -- 기본키(시퀀스 적용할 컬럼)
    bSubject VARCHAR(30) NOT NULL,
    bName VARCHAR(20) NOT NULL,
    bContent VARCHAR2(100) NULL
);

-- 데이터 추가
-- 시퀀스 사용 : 시퀀스 객체명.NEXTVAL (현재값 반환하고 증가감값으로 설정)
INSERT INTO board VALUES(NO_SEQ.NEXTVAL,'추석','홍길동','...');
INSERT INTO board VALUES(NO_SEQ.NEXTVAL,'추석','홍길동','...');
INSERT INTO board VALUES(NO_SEQ.NEXTVAL,'추석','홍길동','...');
SELECT * FROM board;

--------------------------------------------------------------------------------
-- 불필요한 테이블 삭제 후 IMPORT 완료
DROP TABLE book;
DROP TABLE publisher;

-- 기본키 제약조건 추가
ALTER TABLE prd 
    ADD CONSTRAINT pk_prd_prdNo
    PRIMARY KEY (prdNo);
    
--------------------------------------------------------------------------------
/*
    UPDATE 문
    특정 열의 값을 수정하는 명령어
        조건을 사용하지 않으면 컬럼의 전체값 동일하게 수정됨
    조건에 맞는 행을 찾아서 열의 값 수정이 되도록 WHERE절을 보통 사용함
    UPDATE 테이블명 SET 컬럼명=값 [WHERE 조건절];
*/

-- PRD 테이블에서 상품번호가 5인 레코드의 상품명을 'UHD TV'로 수정
-- 데이터(레코드) 수정
-- UPDATE prd SET prdname = 'UHD TV'; PRD 테이블의 컬럼 PRDNAME의 모든 값을 UHD TV로 변경함, WHERE 절을 사용함
UPDATE prd SET prdname = 'UHD TV' WHERE prdno='5';
SELECT * FROM PRD;
COMMIT; -- 이전 DML문은 모두 실제 저장소에 반영됨 (ROLLBACK이 불가능 함)

/*
    DML등 쿼리 구문은 수정과 관련된 실행은 바로 적용되지 않는다(DDL 예외)
    롤백 가능 (COMMIT : 최종반영 / ROLLBACK : 취소(이전 커밋된 내용 바로 다음 명령까지 취소))
*/

/*
    DELETE 문
    테이블에 있는 기존 행을 삭제하라는 명령어
    기본형식
    DELETE FROM 테이블명 [WHERE 조건절];
    DELETE 문에서 WHERE 절 생략하면 테이블의 모든 데이터가 삭제됨
    삭제는 레코드 단위로 삭제됨 : 특정 컬럼의 특정 값만 삭제는 불가능
*/

-- 상품명이 '그늘막 텐트'인 레코드를 삭제
DELETE FROM prd
WHERE prdName='그늘막 텐트';
SELECT * FROM prd;

-- DELETE 시 참조
-- 15번 제품의 PrdColor의 값을 삭제(UPDATE임 : 컬럼의 공간은 놔두고 값만 변경)
UPDATE prd SET prdcolor=NULL WHERE prdNo = '15';
SELECT * FROM prd;



















