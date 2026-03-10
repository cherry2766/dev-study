-- 종합연습문제
-- 김소강

/*
다음과 같이 SQL 문 작성(모든 테이블 속성 데이터내용으로 구성 크기는 적절하게)
1.고객 테이블 (customer) 생성
2.주문 테이블 (orderProduct) 생성 (이미 생성된 상품(product) 테이블에 대한 주문)
prd/ orderProduct와 customer 테이블에 적절한 관계 설정
*/

CREATE TABLE customer(
    custNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    custName VARCHAR2(20) NOT NULL,
    custPhone VARCHAR2(30),
    custAddress VARCHAR2(50)
);

CREATE TABLE orderProduct(
    orderNo VARCHAR2(10) NOT NULL PRIMARY KEY,
    orderDate DATE NOT NULL,
    orderQty NUMBER(8),
    custNo VARCHAR2(10),
    prdNo VARCHAR2(10)
);

ALTER TABLE orderProduct ADD CONSTRAINT FK_orderProduct_prd FOREIGN KEY(prdNo) REFERENCES prd(prdNo);
ALTER TABLE orderProduct ADD CONSTRAINT FK_orderProduct_customer FOREIGN KEY(custNo) REFERENCES customer(custNo);

INSERT ALL
    INTO customer VALUES ('1001','홍길동','010-1111-1111','강원도 평창')
    INTO customer VALUES ('1002','이몽룡','010-2222-2222','서울 종로구')
    INTO customer VALUES ('1003','성춘향','010-3333-3333','서울시 강남구')
SELECT * FROM DUAL;

INSERT ALL
    INTO orderProduct VALUES ('1','2018-01-10',3,'1003','3')
    INTO orderProduct VALUES ('2','2018-03-03',1,'1001','7')
    INTO orderProduct VALUES ('3','2018-04-05',3,'1002','2')
SELECT * FROM DUAL;

-- 고객 테이블의 전화번호 열을 NOT NULL로 변경
ALTER TABLE customer MODIFY custPhone VARCHAR2(30) NOT NULL;

-- 고객 테이블에 ‘성별’, ‘나이’ 열 추가
ALTER TABLE customer ADD (custGender VARCHAR2(4), custAge NUMBER(8));

-- 고객, 주문 테이블에 데이터 삽입 (3개씩)

INSERT ALL
    INTO customer VALUES ('1004','강아지','010-4444-4444','강원도 원주','남',20)
    INTO customer VALUES ('1005','고양이','010-5555-5555','서울 구로구','여',18)
    INTO customer VALUES ('1006','핑핑이','010-6666-6666','세종시','여',24)
SELECT * FROM DUAL;

UPDATE customer SET 
    custGender = '남',
    custAge = 32
WHERE custNo = '1001';

UPDATE customer SET 
    custGender = '남',
    custAge = 28
WHERE custNo = '1002';

UPDATE customer SET 
    custGender = '여',
    custAge = 25
WHERE custNo = '1003';

-- 주문 테이블에서 상품번호가 2인 행의 주문수량을 3으로 수정

UPDATE orderProduct SET 
    orderQty = 3
WHERE orderNo = '2';
