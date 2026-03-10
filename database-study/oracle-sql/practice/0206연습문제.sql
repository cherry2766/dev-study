-- 0206 연습문제
/*
학생(student)과 학과(department) 테이블 생성하고 데이터 입력 (각 3개씩)
제약조건
기본키 설정
학생은 학과에 소속
학생 이름과 학과 이름은 NULL 허용하지 않음
학년은 4를 기본값으로, 범위를 1 ~ 4로 설정
논리연산자 : AND,OR
관계연산자 : < > >= <= 등 사용가능
*/

CREATE TABLE department(
    deptNo NUMBER(10) NOT NULL PRIMARY KEY,
    deptName VARCHAR2(30) NOT NULL,
    deptTel VARCHAR2(20)
);

CREATE TABLE student(
    stdNo NUMBER(10) NOT NULL PRIMARY KEY,
    stdName VARCHAR2(30) NOT NULL,
    stdYear NUMBER(1) DEFAULT 4 NOT NULL CHECK(stdYear BETWEEN 1 and 4),
    stdAddr VARCHAR2(50),
    stdBirth DATE,
    deptNo NUMBER(10) NOT NULL,
    CONSTRAINT FK_student_department FOREIGN KEY(deptNo) REFERENCES department(deptNo)
);

/*
.product 테이블에 숫자 값을 갖는 prdStock과 제조일을 나타내는 prdDate 열 추가
.product 테이블의 prdCompany 열 기본 추가해서 NOT NULL로 변경
.publisher 테이블에 pubPhone, pubAddress 열 추가
.publisher 테이블에서 pubPhone 열 삭제
*/


ALTER TABLE product ADD (prdStock NUMBER(12), prdDate DATE);

ALTER TABLE product MODIFY prdCompany VARCHAR2(10) NOT NULL; 

ALTER TABLE publisher ADD (pubPhone NUMBER(8), pubAddress VARCHAR2(30));

ALTER TABLE publisher DROP COLUMN pubPhone;

/*
INSERT 문을 사용하여 STUDENT 테이블에 다음과 같이 행 삽입하고　
SELECT 문으로 조회
*/

INSERT INTO student(stdNo,stdName,stdYear,stdAddr,stdBirth,deptNo)
    VALUES(2016001,'홍길동','4','서울시','1997-01-01',1);
    
INSERT INTO student
    VALUES(2016002,'성춘향','3','강화도','1996-12-10',3);

INSERT ALL
    INTO student VALUES(2014004,'이몽룡','2','인천광역시','1996-03-03',2)
    INTO student VALUES(2015002,'변학도','4','세종시','1995-05-07',1)
    INTO student VALUES(2015003,'손흥민','3','제주도','1997-11-11',2)
SELECT * FROM DUAL;

SELECT * FROM student;
--------------------------------------------------------------------------------
-- 학과 테이블
-- drop table department;
create table department (
	dptNo varchar(10) not null primary key,
    dptName varchar(30) not null,
    dptTel varchar(13) not null
);

-- 학생 테이블
-- drop table student;
create table student (
	stdNo varchar(10) not null primary key,
    stdName varchar(30) not null,
    stdYear int default 4 check (stdYear>=1 and stdYear<=4),
    stdAddress varchar(30),
    stdBirth date,
    dptNo varchar(10) not null,
    foreign key (dptNo) references department(dptNo)
);

INSERT ALL INTO department (dptNo, dptName, dptTel)
 VALUES('001', '경영학과', '02-111-1111')
 INTO department (dptNo, dptName, dptTel)
 VALUES ('002', '기계공학과', '02-222-2222')
 INTO department (dptNo, dptName, dptTel)
 VALUES ('003', '컴퓨터공학과', '02-333-3333')
 SELECT * 
 FROM DUAL;

INSERT ALL INTO student
 VALUES('2023001', '홍길동', 3, '서울시', '1999-01-01', '002')
 INTO student
 VALUES('2023002', '이몽룡', 1, '서울시', '2001-05-03', '001')
 INTO student
 VALUES('2023003', '성춘향', 4, '경기도', '1996-10-10', '003')
 SELECT *
 FROM DUAL;














