-- 0211 연습문제
-- 김소강

-- 서브 쿼리 활용해서 질의 완성하세요

-- 호날두(고객명)가 주문한 도서의 총 구매량 출력
-- 서브쿼리 사용
SELECT SUM(bsQty) AS 총구매량
FROM bookSale
WHERE clientNo IN (SELECT clientNo
                   FROM client
                   WHERE clientName = '호날두');
                   
-- 조인 사용
SELECT SUM(BS.bsQty) AS 총구매량
FROM bookSale BS
    INNER JOIN client C
    ON BS.clientNo = C.clientNo
WHERE C.clientName = '호날두';

-- ‘정보출판사’에서 출간한 도서를 구매한 적이 있는 고객명 출력
-- 서브쿼리 사용
SELECT clientName AS 고객명
FROM client
WHERE clientNo IN (SELECT clientNo
                   FROM bookSale
                   WHERE bookNo IN (SELECT bookNo
                                    FROM book
                                    WHERE pubNo IN (SELECT pubNo
                                                   FROM publisher
                                                   WHERE pubName = '정보출판사')));

-- 조인 사용
SELECT DISTINCT C.clientName AS 고객명
FROM bookSale BS
    INNER JOIN book B ON B.bookNo = BS.bookNo
    INNER JOIN publisher P ON P.pubNo = B.pubNo
    INNER JOIN client C ON C.clientNo = BS.clientNo
WHERE P.pubName = '정보출판사';

-- 베컴이 주문한 도서의 최고 주문수량 보다 더 많은 도서를 구매한 고객명 출력
-- 서브쿼리 & 조인 사용
SELECT DISTINCT C.clientName AS 고객명
FROM bookSale BS
     INNER JOIN client C ON C.clientNo = BS.clientNo
WHERE BS.bsQty > (SELECT MAX(BS2.bsQty)
                      FROM bookSale BS2
                      INNER JOIN client C2 ON C2.clientNo = BS2.clientNo
                      WHERE C2.clientName = '베컴');

-- 천안에 거주하는 고객에게 판매한 도서의 총 판매량 출력
-- 서브쿼리 사용
SELECT SUM(bsQty) 총판매량
FROM bookSale
WHERE clientNo IN (SELECT clientNo
                   FROM client
                   WHERE clientAddress LIKE '%천안%');
                   
-- 조인 사용
SELECT SUM(bsQty) 총판매량
FROM bookSale BS
    INNER JOIN client C ON C.clientNo = BS.clientNo
WHERE C.clientAddress LIKE '%천안%';

-- 함수 사용 연습 문제

-- 저자 중 성(姓)이 '손'인 모든 저자 출력
SELECT bookAuthor 저자
FROM book
WHERE SUBSTR(bookAuthor,1,1) = '손';

-- 저자 중에서 같은 성(姓)을 가진 사람이 몇 명이나 되는지 알아보기 위해 성(姓)별로 그룹 지어 인원수 출력
SELECT SUBSTR(bookAuthor,1,1) 성, COUNT(*) 인원수
FROM book
GROUP BY SUBSTR(bookAuthor,1,1);

-- 아래와같은 테이블을 생성하고 CUBE, ROLLUP, GROUPING SETS를 적용시켜 결과를 설명하시오
-- 자세한 결과 설명 필요

CREATE TABLE sales(
prdName VARCHAR2(20),
salesDate VARCHAR2(10),
prdCompany VARCHAR2(10),
salesAmount NUMBER(8)
);

INSERT INTO sales VALUES ('노트북','2021.01','삼성',10000);
INSERT INTO sales VALUES ('노트북','2021.03','삼성',20000);
INSERT INTO sales VALUES ('냉장고','2021.01','LG',12000);
INSERT INTO sales VALUES ('냉장고','2021.03','LG',20000);
INSERT INTO sales VALUES ('프린터','2021.01','HP',3000);
INSERT INTO sales VALUES ('프린터','2021.03','HP',1000);

SELECT * FROM sales;

SELECT prdName, salesDate, prdCompany, SUM(salesAmount) "금액합계"
FROM sales 
GROUP BY ROLLUP(prdName, salesDate, prdCompany)
ORDER BY prdName, salesDate, prdCompany;
-- prdName의 소계 
-- (prdName + salesDate) 의 소계 
-- (prdName + salesDate + prdCompany)의 상세 합계 
-- 전체 합계 출력

SELECT prdName, salesDate, prdCompany, SUM(salesAmount) "금액합계"
FROM sales 
GROUP BY CUBE(prdName, salesDate, prdCompany)
ORDER BY prdName, salesDate, prdCompany;
-- prdName의 소계, salesDate 소계, prdCompany 소계
-- (prdName + salesDate)의 소계, (prdName + prdCompany)의 소계, (salesDate + prdCompany)의 소계
-- (prdName + salesDate + prdCompany)의 상세 합계
-- 전체 합계 출력

SELECT prdName, salesDate, prdCompany, SUM(salesAmount) "금액합계"
FROM sales 
GROUP BY GROUPING SETS((prdName), (salesDate), (prdCompany));
-- prdName의 소계
-- salesDate 소계
-- prdCompany 소계


-- 주문 테이블에서 주문일에 7일을 더한 날을 배송일로 계산하여 출력
SELECT orderDate + 7 AS "배송일"
FROM orderProduct;

SELECT bsDate + 7 AS "배송일"
FROM bookSale;

-- 도서 테이블에서 도서명과 출판연도 출력
SELECT bookName, EXTRACT(YEAR FROM bookDate) 출판연도
FROM book;