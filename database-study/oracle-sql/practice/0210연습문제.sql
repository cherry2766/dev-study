-- 0210 연습문제
-- 김소강


-- 1.도서 테이블에서 가격 순으로 내림차순 정렬하여,  도서명, 저자, 가격 출력 (가격이 같으면 저자 순으로 오름차순 정렬)
SELECT bookName AS 도서명, bookAuthor AS 저자, bookPrice AS 가격
FROM book
ORDER BY bookPrice DESC, bookAuthor;

-- 2.도서 테이블에서 저자에 '길동'이 들어가는 도서의 총 재고 수량 계산하여 출력
SELECT SUM(bookStock) AS 총재고수량
FROM book
WHERE bookAuthor LIKE '%길동%';

-- 3.도서 테이블에서 ‘서울 출판사' 도서 중 최고가와 최저가 출력(출판사 번호 활용)
-- SELECT의 별명은 AS 생략 가능
SELECT MAX(bookPrice) AS 최고가, MIN(bookPrice) AS 최저가
FROM book
WHERE pubNo = '1';

    -- 서울출판사 정보를 활용 : 서브쿼리 활용
    -- 서브쿼리 : 비교 연산자 사용 가능(단, 서브쿼리 반환 결과가 단일행이어야 함)
    SELECT MAX(bookPrice) AS 최고가, MIN(bookPrice) AS 최저가
    FROM book
    WHERE pubNo = (SELECT pubNo FROM publisher WHERE pubName = '서울 출판사');
    -- 서브쿼리 사용 가능 연산자 : 비교연산자, IN, NOT IN
    -- 서브쿼리 반환 레코드가 다중행일때 사용 가능 : IN, NOT IN, EXISTS, ANY, ALL
    SELECT MAX(bookPrice) AS 최고가, MIN(bookPrice) AS 최저가
    FROM book
    WHERE pubNo IN (SELECT pubNo FROM publisher WHERE pubName = '서울 출판사');
    
    -- 조인 활용
    SELECT pubName, MAX(bookPrice) AS 최고가, MIN(bookPrice) AS 최저가
    FROM book B, publisher P
    WHERE B.pubNo = P.pubNo
        AND P.pubName = '서울 출판사'
    GROUP BY pubName;
    
    SELECT pubName, MAX(bookPrice) AS 최고가, MIN(bookPrice) AS 최저가
    FROM book B
        INNER JOIN publisher P
        ON B.pubNo = P.pubNo
    WHERE P.pubName = '서울 출판사'
    GROUP BY pubName;
    

-- 4.도서 테이블에서 출판사별로 총 재고수량과 평균 재고 수량 계산하여 출력 (‘총 재고 수량’으로 내림차순 정렬)(출판사번호)
SELECT pubNo, SUM(bookStock) AS 총재고수량, AVG(bookStock) AS 평균재고수량
FROM book
GROUP BY pubNo
ORDER BY 2 DESC;

-- 5.도서판매 테이블에서 고객별로 ‘총 주문 수량’과 ‘총 주문 건수’ 출력. 단 주문 건수가 2이상인 고객만 해당
SELECT clientNo AS 고객번호, SUM(bsQty) AS 총주문수량, COUNT(*) AS 총주문건수
FROM bookSale
GROUP BY clientNo
HAVING COUNT(*) >=2; --GROUP BY된 결과에 대한 조건 : 그룹 함수에 대한 결과로 필터링을 해야할 경우 사용

-- 모든 도서에 대하여 도서의 도서번호, 도서명, 출판사명 출력
SELECT B.bookNo AS 도서번호, B.bookName AS 도서명, P.pubName AS 출판사명
FROM book B 
    INNER JOIN publisher P ON B.pubNo = P.pubNo;
    
-- ‘서울 출판사'에서 출간한 도서의 도서명, 저자명, 출판사명 출력 (출판사명 사용)
SELECT B.bookName AS 도서명, B.bookAuthor AS 저자명, P.pubName AS 출판사명
FROM book B 
    INNER JOIN publisher P ON B.pubNo = P.pubNo
WHERE P.pubName = '서울 출판사';

-- ＇정보출판사'에서 출간한 도서 중 판매된 도서의 도서명 출력 (중복된 경우 한 번만 출력) (출판사명 사용)
SELECT DISTINCT B.bookName AS 도서명
FROM book B
    INNER JOIN publisher P ON B.pubNo = P.pubNo
    INNER JOIN bookSale BS ON B.bookNo = BS.bookNo
WHERE P.pubName = '정보출판사';
    
-- 도서가격이 30,000원 이상인 도서를 주문한 고객의 고객명, 도서명, 도서가격, 주문수량 출력
SELECT C.clientName AS 고객명, B.bookName AS 도서명, B.bookPrice AS 도서가격, BS.bsQty AS 주문수량
FROM bookSale BS
    INNER JOIN client C ON C.clientNo = BS.clientNo
    INNER JOIN book B ON B.bookNo = BS.bookNo
WHERE B.bookPrice >=30000;

-- '안드로이드 프로그래밍' 도서를 구매한 고객에 대하여 도서명, 고객명, 성별, 주소 출력 (고객명으로 오름차순 정렬)
SELECT B.bookName AS 도서명, C.clientName AS 고객명, C.clientGender AS 성별, C.clientAddress AS 주소
FROM bookSale BS
    INNER JOIN client C ON C.clientNo = BS.clientNo
    INNER JOIN book B ON B.bookNo = BS.bookNo
WHERE B.bookName = '안드로이드 프로그래밍'
ORDER BY C.clientName;

-- ‘도서출판 강남'에서 출간된 도서 중 판매된 도서에 대하여 ‘총 매출액’ 출력
SELECT SUM(B.bookPrice * BS.bsQty) AS "총 매출액"
FROM book B 
    INNER JOIN publisher P ON B.pubNo = P.pubNo
    INNER JOIN bookSale BS ON B.bookNo = BS.bookNo
WHERE P.pubName = '도서출판 강남';
    
-- ‘서울 출판사'에서 출간된 도서에 대하여 판매일, 출판사명, 도서명, 도서가격, 주문수량, 주문액 출력
SELECT BS.bsDate AS 판매일, P.pubName AS 출판사명, B.bookName AS 도서명, B.bookPrice AS 도서가격, BS.bsQty AS 주문수량, B.bookPrice * BS.bsQty AS 주문액
FROM book B 
    INNER JOIN publisher P ON B.pubNo = P.pubNo
    INNER JOIN bookSale BS ON B.bookNo = BS.bookNo
WHERE P.pubName = '서울 출판사';

-- 판매된 도서에 대하여 도서별로 도서번호, 도서명, 총 주문 수량 출력
SELECT B.bookNo AS 도서번호, B.bookName AS 도서명, SUM(BS.bsQty) AS "총 주문 수량"
FROM bookSale BS
    INNER JOIN book B ON B.bookNo = BS.bookNo
GROUP BY B.bookNo, B.bookName;

-- 판매된 도서에 대하여 고객별로 고객명, 총구매액 출력 ( 총구매액이 100,000원 이상인 경우만 해당)
SELECT C.clientName AS 고객명, SUM(B.bookPrice*BS.bsQty) AS 총구매액
FROM bookSale BS
    INNER JOIN client C ON C.clientNo = BS.clientNo
    INNER JOIN book B ON B.bookNo = BS.bookNo
GROUP BY C.clientNo, C.clientName
HAVING SUM(B.bookPrice*BS.bsQty) >= 100000;

-- 판매된 도서 중 ＇도서출판 강남'에서 출간한 도서에 대하여 고객명, 주문일, 도서명, 주문수량, 출판사명 출력 (고객명으로 오름차순 정렬)
SELECT C.clientName AS 고객명, BS.bsDate AS 주문일, B.bookName AS 도서명, BS.bsQty AS 주문수량, P.pubName AS 출판사명
FROM bookSale BS
    INNER JOIN client C ON C.clientNo = BS.clientNo
    INNER JOIN book B ON B.bookNo = BS.bookNo
    INNER JOIN publisher P ON B.pubNo = P.pubNo
WHERE P.pubName = '도서출판 강남'
ORDER BY C.clientName;
    
