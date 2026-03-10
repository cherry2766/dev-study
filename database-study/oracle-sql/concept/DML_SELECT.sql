/* 
SELECT 연습
*/

-- 연습용 테이블에 제약조건 추가
-- 기본키 제약조건 추가
ALTER TABLE publisher ADD PRIMARY KEY (pubNo);
ALTER TABLE book ADD PRIMARY KEY (bookNo);
ALTER TABLE client ADD PRIMARY KEY (clientNo);
ALTER TABLE booksale ADD PRIMARY KEY (bsNo);

describe publisher; -- 테이블 구조 확인 명령어

-- 외래키 추가
ALTER TABLE book
    ADD CONSTRAINT FK_book_publisher  
    FOREIGN KEY (pubNo) REFERENCES publisher(pubNo);
ALTER TABLE booksale
    ADD CONSTRAINT FK_booksale_client  
    FOREIGN KEY (clientNo) REFERENCES client (clientNo);
ALTER TABLE booksale
    ADD CONSTRAINT FK_booksale_book  
    FOREIGN KEY (bookNo) REFERENCES book (bookNo);

--------------------------------------------------------------------------------
/*
    SELECT 문 : 테이블에서 조건에 맞는 행 검색
    형식의 구문절들은 순서가 뒤바뀌면 안됨
    기본형식
    SELECT [ALL|DISTINCT]열이름 리스트|함수식
    FROM 테이블명|DUAL
    [WHERE 검색조건(들)]
    [GROUP BY 열이름]
    [HAVING 검색조건(들)]
    [ORDER BY 열이름 [ASC|DESC]]
    
    사용 가능 기호 : * (모든컬럼을 대신해서 사용)
    
    반환 결과는 테이블 객체임 : 조건에 맞는 데이터가 하나도 없어도 컬럼명은 추출됨
*/

-- 도서 테이블에서 모든(*) 레코드 검색
    
SELECT * FROM book;

-- 도서 테이블에서 모든 레코드의 도서명과 가격 컬럼을 검색

SELECT bookName, bookPrice FROM book;

-- DISTINCT
-- 속성값이 중복되어 있으면 한번만 출력
-- 현재 서점에 진열된 책들의 출판사 번호 중복값 없이 확인
SELECT DISTINCT pubNo FROM book;

-- 현재 서점에 진열된 도서들의 저자를 확인
SELECT bookAuthor FROM book;

-- 진열된 도서의 저자명 확인(중복값은 제외)
SELECT DISTINCT bookAuthor FROM book;

-- bookSale(주문) 테이블
-- 한번이라도 주문한적이 있는 고객 리스트 확인

describe bookSale;

SELECT DISTINCT clientNo
FROM bookSale;
    
SELECT * FROM client;    

-- 두개 이상의 컬럼을 검색하면 레코드 단위의 DISTINCT가 진행됨
SELECT DISTINCT bookNo, clientNo
FROM bookSale;

--------------------------------------------------------------------------------
-- WHERE 조건절
-- 조건에 맞는 레코드만 검색
/*
    사용연산
    비교 (=, <, >, <=, >=, !=)
    범위 (BETWEEN)
    리스트에 포함 (IN, NOT IN)
    NULL (IS NULL, IS NOT NULL)
    논리(AND, OR)
    패턴 매칭 (LIKE)
*/

-- 비교 (=, <, >, <=, >=, !=) 연산

-- 저자가 홍길동인 도서의 도서명, 저자 검색
SELECT bookname, bookAuthor
FROM book
WHERE bookAuthor = '홍길동'; -- 다른 조건이 없으면 전체 레코드를 순회하면서 조건에 부합하는 레코드인지 확인

-- 가격이 30000 이상인 레코드의 도서명, 가격, 재고 검색
SELECT bookname,bookPrice,bookStock
FROM book
WHERE bookPrice >= 30000;

-- 도서 재고가 3~5 사이인 도서의 도서명, 재고 검색
SELECT bookName, bookstock
FROM book
WHERE bookStock >= 3 AND bookStock <=5;

-- 범위 연산자(BETWEEN 범위의 시작값 AND 범위의 끝값) : 이상과 이하
-- 시작값 >= AND <= 끝값
SELECT bookName, bookstock
FROM book
WHERE bookStock between 3 and 5;

-- 리스트 포함 여부(IN)
-- 리스트 포함되지 않는지의 여부(NOT IN)
-- 출판사번호가 1이거나 2인 도서의 도서명, 출판사번호 검색
SELECT bookName, pubNo
FROM book
WHERE pubNo ='1' OR pubNo = '2';

-- IN 연산자 사용
SELECT bookName, pubNo
FROM book
WHERE pubNo IN('1','2');

-- 출판사 번호 2가 아닌 다른 출판사에서 출판한 도서의 도서명, 출판사 번호 검색
SELECT bookName, pubNo
FROM book
WHERE pubNo != '2';

-- NOT IN 연산자 사용
SELECT bookName, pubNo
FROM book
WHERE pubNo NOT IN('2');

-- 도서 테이블에서 출판사 번호가 1 또는 2가 아닌 레코드의 도서명/출판사 번호 검색
SELECT bookName, pubNo
FROM book
WHERE pubNo NOT IN('1','2');

-- NULL과 관련된 연산
SELECT clientName, clientHobby FROM client;

-- 고객 데이터 중 취미 정보가 입력되어있는 고객의 이름과 취미 레코드를 검색
SELECT clientName, clientHobby
FROM client
WHERE clientHobby is not NULL;

-- 아자르 클라이언트 취미는 빈값(SPACE 문자 1개) 입력되어 있음
SELECT clientName, clientHobby
FROM client
WHERE clientHobby = ' ';

-- 고객 데이터 중 취미 정보가 입력되지 않은 고객의 이름과 취미 레코드를 검색
SELECT clientName, clientHobby
FROM client
WHERE clientHobby is NULL;

-- 논리(AND, OR)
-- 두개 이상의 컬럼 조건과 매칭시킬때

-- 도서 중 저자가 '홍길동' 이면서 재고가 3권 이상인 도서의 모든 정보 출력
SELECT *
FROM book
WHERE bookAuthor = '홍길동' AND bookStock >= 3;

-- 도서 중 저자가 '홍길동' 이거나 재고가 3권 이상인 도서의 모든 정보 출력
SELECT *
FROM book
WHERE bookAuthor = '홍길동' OR bookStock >= 3;

SELECT * FROM book;
/* -----------------------------------------------------------------------------
     문자열 값 인 경우 LIKE 연산 이용 패턴 매칭
     와일드카드 문자
        % : 0개 이상의 문자를 가진 문자열
        _ : 단일문자
        Ex. '홍길동%' : 홍길동, 홍길동이, 홍길동부모님
            홍길동으로 시작하는 모든 문자열
            '%홍길동%' : 홍길동, 홍길동이, 홍길동부모님, 친구 홍길동, 형홍길동이가
            '홍길동'을 포함하고 있는 모든 문자열
            '%홍길동' : 홍길동, 친구홍길동, 형홍길동
            '홍길동'으로 끝나는 모든 문자열
            
            '____' : 4개의 문자로 구성된 문자열(홍길동이,형홍길동,버스타기)
*/

-- 출판사명에 '출판사'가 포함된 모든 출판사 이름을 검색
DESCRIBE publisher;

SELECT pubName 
FROM publisher
WHERE pubName LIKE '%출판사%';

-- 출판사명이 '출판사'로 끝나는 모든 출판사 이름을 검색
SELECT pubName 
FROM publisher
WHERE pubName LIKE '%출판사';

-- 고객 테이블에서 출생년도가 1990년대인 고객의 모든 컬럼을 검색
SELECT * 
FROM client
WHERE clientBirth LIKE '199%';

-- 고객 이름이 4글자인 고객의 이름과 고객번호를 검색
SELECT clientName, clientNo
FROM client
WHERE clientName LIKE '____';

-- NOT 연산 (부정 연산)
-- NOT LIKE (패턴) : 패턴과 부합하지 않는 레코드
-- 도서명에 안드로이드가 포함되지 않는 도서의 도서명, 가격 검색
SELECT bookName, bookPrice
FROM book
WHERE bookName NOT LIKE ('%안드로이드%');

-- 도서명에 안드로이드가 포함되는 도서의 도서명, 가격 검색
SELECT bookName, bookPrice
FROM book
WHERE bookName LIKE ('%안드로이드%');

--------------------------------------------------------------------------------

-- ORDER BY : SQL 질의어 마지막에 표현
-- 특정 컬럼의 값을 기준으로 질의 결과(SELECT까지 종료된 결과) 정렬
-- ASC : 오름차순(생략 가능) / DESC : 내림차순
-- ORDER BY 컬럼명1 ASC/DESC[, 컬럼명2 ASC/DESC]

SELECT * FROM book
ORDER BY bookName ASC; 
-- bookName을 기준으로 레코드의 모든 컬럼 이동하게 됨
-- 정렬 기준 : 0~9 A~Z 가~하

-- ASC는 생략 가능
SELECT * FROM book
ORDER BY bookName; 

-- 내림차순 : DESC 반드시 포함
SELECT * FROM book
ORDER BY bookName DESC; 

-- 도서테이블에서 재고 수량을 기준으로 내림차순 정렬하여 검색(단, 컬럼은 도서명, 저자 검색)
-- select 되지 않는 컬럼도 정렬 조건으로 사용 가능
SELECT bookName, bookAuthor
FROM book
ORDER BY bookStock DESC;

SELECT bookName, bookAuthor, bookStock
FROM book
ORDER BY bookStock DESC;

-- 재고수량이 5권 이상인 도서의 도서명, 저자, 재고수량 확인하는데 재고수량 기준으로 내림차순 정렬
SELECT bookName, bookAuthor, bookStock
FROM book
WHERE bookStock >=5
ORDER BY bookStock DESC;  

-- 도서테이블에서 저자를 기준으로 내림차순 정렬하시오(도서명, 저자)
SELECT bookName, bookAuthor
FROM book
ORDER BY bookAuthor DESC;

-- 도서테이블에서 저자를 기준으로 내림차순 정렬하시오 저자가 동일한 경우 bookNo 기준 오름차순 정렬
SELECT bookNo, bookName, bookAuthor
FROM book
ORDER BY bookAuthor DESC, bookNo;

SELECT bookNo, bookName, bookAuthor
FROM book
ORDER BY bookAuthor DESC, bookNo DESC;

-- SELECT 되는 컬럼의 표현 명 변경 : AS 예약어 사용
-- SELECT 컬럼명 AS 별명
-- SELECT 절에 표현된 컬럼명이 반환되는 객체(테이블)의 컬럼명으로 처리됨
SELECT bookNo, bookName, bookAuthor
FROM book
ORDER BY bookAuthor DESC, bookNo;

-- 상수연산 컬럼은 테이블에 없는 컬럼이지만 SELECT 되어서 반환되는 테이블에는 컬럼을 생성하고 연산결과를 모든 레코드에 동일하게 뿌림
SELECT 3+5, bookNo, bookName, bookAuthor
FROM book
ORDER BY bookAuthor DESC, bookNo;

-- 상수연산에 대한 별명 추가
SELECT 3+5 AS CUST_NO, bookNo, bookName, bookAuthor
FROM book
ORDER BY bookAuthor DESC, bookNo;

-- 일반 컬럼에 별명 추가 별명 표현 문자열 ""
SELECT 3+5 AS CUST_NO, bookNo AS "도서번호", bookName AS "도서명", bookAuthor AS "저자"
FROM book
ORDER BY bookAuthor DESC, bookNo;

-- 도서가격 인상을 준비하고 있고 전체 도서에 대해서 10%인상된 가격을 확인을 위한 검색(도서번호, 도서명, 도서가격(10%인상))
-- select된 컬럼 값에 연산 추가 가능
SELECT bookNo, bookName, bookPrice, bookPrice * 1.1
FROM book;

-- 연산 진행한 select된 컬럼명은 연산식이 그대로 표현됨
-- 컬럼명 변경해서 표현하도록 권장
-- 별명에 띄어쓰기가 없으면 "" 없어도 됨
SELECT bookNo AS "도서번호", bookName AS "도서명", bookPrice AS "도서가격", bookPrice * 1.1 AS "인상가격" 
FROM book;

-- SELECT 결과에 연산이 포함되거나 컬럼명이 너무 길어서 복잡한 경우 별명을 활용

--------------------------------------------------------------------------------
/*
    SELECT 문에는 연산식을 포함할 수 있다
    집계 함수
    SUM() : 합계
    AVG() : 평균
    COUNT() : 선택된 열의 행 수(널 값은 제외)
    COUNT(*) : 전체 행의 수
    MAX() : 최대
    MIN() : 최소
*/
    
-- SUM() : 합계
-- 도서테이블에서 총재고 수량 계산하여 검색
-- 반환결과가 테이블(객체) : 컬럼명 반드시 필요
-- 컬럼명이 연산식(함수식)
SELECT SUM(bookStock)
FROM book;

-- 컬럼명 별명 사용
SELECT SUM(bookStock) AS "SUM of bookStock"
FROM book;

-- 한글 별명 가능
SELECT SUM(bookStock) AS "총 재고 수량"
FROM book;

-- 띄어쓰기 없으면 ""생략 가능
SELECT SUM(bookStock) AS 총재고수량
FROM book;

-- 도서 판매 테이블에서 
-- 고객번호가 2인 호날두가 주문한 도서의 총 주문수량 계산하여 출력
SELECT SUM(bsQty) AS "총 주문수량"
FROM booksale
WHERE clientNo = '2';

-- 고객번호가 2인 호날두가 주문한 도서의 총 주문수량 계산하여 출력하고 고객번호를 표현
-- ORA-00937: 단일 그룹의 그룹 함수가 아닙니다 : clientNo가 집계함수의 결과가 아니다
-- select에서 집계함수 이용시 다른 컬럼도 집계함수 사용하거나 사용하지 말아야 함
/*
SELECT SUM(bsQty) AS "총 주문수량", clientNo
FROM booksale
WHERE clientNo = '2';
*/

-- 도서판매 테이블에서 최대/최소 판매수량을 검색
-- SELECT 집계함수를 사용한 컬럼들의 나열은 가능
SELECT MAX(bsQty) AS 최대주문량, MIN(bsQty) AS 최소주문량
FROM booksale;

SELECT SUM(bookPrice) AS 가격총액,
       AVG(bookPrice) AS 가격평균,
       MAX(bookPrice) AS 최대가격,
       MIN(bookPrice) AS 최소가격
FROM book;

-- COUNT(): NULL값은 제외 후 데이터의 수를 반환
-- COUNT(*) : 테이블 레코드를 개수 / COUNT(컬럼명)
-- * : 테이블의 모든 레코드
-- 컬럼명 : 컬럼의 데이터

SELECT COUNT(*) AS 총고객수 FROM client;
SELECT COUNT(*) AS 총판매건수 FROM booksale;

-- NULL 값을 포함하고 있는 컬럼 대상으로 고객수를 개수하면 잘못된 결과가 나올 수 있음
-- * 를 사용하는게 가장 정확함
SELECT COUNT(clientHobby) AS 총고객수 FROM client;  -- 별명의 의미가 잘못 됨

SELECT COUNT(clientHobby) AS "취미가 있는 고객 수" FROM client;
    
    
    
    
    
    
    