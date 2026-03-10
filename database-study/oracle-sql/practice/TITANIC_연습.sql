-- 타이타닉 데이터를 활용한 SELECT 연습

-- 데이터 구조 파악
-- 테이블 컬럼명/컬럼 유형 확인
DESCRIBE TITANIC;

-- 생존(1)/사망(0) 컬럼의 값을 확인 : 생존/사망 외에 다른 값은 없음
SELECT DISTINCT survived FROM titanic;
-- 성별 확인(male/female)
SELECT DISTINCT sex FROM titanic;
-- 선실등급 확인
-- 1/2/3 : 1등실이 가장 좋은 선실 : 층이 높음
SELECT DISTINCT pclass FROM titanic;

-- 데이터를 통해 데이터 구조 확인 : 상위 10에 나타나는 데이터를 확인하는 작업
SELECT *
FROM titanic
WHERE ROWNUM <= 10;

-- 나이의 범위
-- 0.42세 ~ 80세
SELECT MAX(age) 최고연령 , MIN(age) 최저연령
FROM titanic;

-- 승객의 수를 확인하기 위해 passengerid를 사용
-- 중복값이 있는지 확인 - 중복 없음
-- 튜플 714
SELECT COUNT(passengerid) "승객수(중복포함)", 
       COUNT(DISTINCT passengerid) "승객수(중복제거)"
FROM titanic;

/* 성별에 따른 생존율 확인 */

-- 성별에 따른 탑승자 수
-- 여성보다 남성의 탑승자 수가 많다
SELECT sex 성별, COUNT(passengerid) 탑승자수
FROM titanic
GROUP BY sex;

-- 성별에 따른 탑승자수와 생존자 수
-- 남성보다 여성의 생존자가 많다
SELECT sex 성별, COUNT(passengerid) 탑승자수, SUM(survived) 생존자수
FROM titanic
GROUP BY sex;

-- 비교를 하기 위해서는 비율로 확인하는 것이 일반적임
-- 성별에 따른 탑승자수와 생존자 수, 생존율(%단위로 확인)
-- 생존율은 2배 이상 차이가 남(남성보다 여성의 생존율이 훨씬 높음)
SELECT sex 성별, COUNT(passengerid) 탑승자수, 
                 SUM(survived) 생존자수, 
                 ROUND(SUM(survived)/COUNT(passengerid)*100,2) 생존율
FROM titanic
GROUP BY sex;

-- 나이(연령) 데이터를 활용한 생존 분석
-- 연령 데이터 정리 후 생존과의 관계 확인
-- AGEBAND : 10년 구간
-- 62세 60대

-- 가공필드가 포함된 아래 질의를 인라인 뷰 서브쿼리로 활용
-- 오라클은 셀렉트된 컬럼을 GROUP BY 조건으로 활용 불가능
SELECT FLOOR(AGE/10)*10 AGEBAND, age, survived, passengerid
FROM titanic;

-- 연령대별 탑승객 수 확인
-- 80대 1명, 70대 6명 : 샘플이 적기 때문에 생존과의 관계 데이터 무의미
-- 20대~30대 탑승객수가 가장 많다
-- 미성년자 탑승객 수도 어느정도 차지함(가족단위 탑승이 많았음)
SELECT AGEBAND, COUNT(passengerid) 탑승자수
FROM (SELECT FLOOR(AGE/10)*10 AGEBAND, age, survived, passengerid
      FROM titanic)
GROUP BY AGEBAND
ORDER BY AGEBAND;

-- 연령대별 생존자수
-- 탑승객수가 가장 많은 연령대가 20대고 생존자수도 가장 많음
-- 70대는 생존자수가 없고, 80대는 모두 생존함(무의미함)
SELECT AGEBAND, COUNT(passengerid) 탑승자수, SUM(survived) 생존자수
FROM (SELECT FLOOR(AGE/10)*10 AGEBAND, age, survived, passengerid
      FROM titanic)
GROUP BY AGEBAND
ORDER BY AGEBAND;

-- 연령대별 생존자수와 생존율
-- 탑승객수가 가장 많은 연령대가 20대고 생존자수도 가장 많음
-- 20대가 절대수치로는 생존자수가 가장 많지만 생존율은 낮은편
-- 아동의 생존율이 가장 높다
SELECT AGEBAND, COUNT(passengerid) 탑승자수, SUM(survived) 생존자수,
       ROUND(SUM(survived)/COUNT(passengerid)*100,2) 생존율
FROM (SELECT FLOOR(AGE/10)*10 AGEBAND, age, survived, passengerid
      FROM titanic)
GROUP BY AGEBAND
ORDER BY AGEBAND;

-- 연령대와 성별에 따른 생존과의 관계
-- 연령대는 가공컬럼이르모 인라인뷰를 사용해야 함

-- 연령대와 성별에 따른 탑승객 수와 생존자 수, 생존율
-- 10대 남성 아동의 생존자수가 유난히 작음, 여자아이는 상대적으로 생존자수가 많다
-- 전 연령대에 걸쳐 여성의 생존자수가 남성의 생존자수보다 많음
-- 전 연령대에 걸쳐 여성의 생존율이 높게 나타남, 10대의 남성 생존율이 가장 낮음
SELECT sex 성별, AGEBAND 연령대,COUNT(passengerid) 탑승자수, SUM(survived) 생존자수,
       ROUND(SUM(survived)/COUNT(passengerid)*100,2) 생존율
FROM (SELECT FLOOR(AGE/10)*10 AGEBAND, age, survived, sex, passengerid
      FROM titanic)
GROUP BY AGEBAND, sex
ORDER BY sex, AGEBAND;

----------- 위 결과에서 성별 동일 연령대의 차이를 확인해보고자 하면
-- 남성과 여성에 대한 연령대별 생존율 테이블 구성
-- 남성의 연령대별 생존율
SELECT sex 성별, AGEBAND 연령대,COUNT(passengerid) 탑승자수, SUM(survived) 생존자수,
       ROUND(SUM(survived)/COUNT(passengerid)*100,2) 생존율
FROM (SELECT FLOOR(AGE/10)*10 AGEBAND, age, survived, sex, passengerid
      FROM titanic)
GROUP BY AGEBAND, sex
HAVING sex = 'male'
ORDER BY sex, AGEBAND;

-- 여성의 연령대별 생존율
SELECT sex 성별, AGEBAND 연령대,COUNT(passengerid) 탑승자수, SUM(survived) 생존자수,
       ROUND(SUM(survived)/COUNT(passengerid)*100,2) 생존율
FROM (SELECT FLOOR(AGE/10)*10 AGEBAND, age, survived, sex, passengerid
      FROM titanic)
GROUP BY AGEBAND, sex
HAVING sex = 'female'
ORDER BY sex, AGEBAND;

-- 위에서 확인한 두 view를 조인해서 생존율의 차이를 구함
SELECT A.연령대, A.생존율 "남성 생존율", B.생존율 "여성 생존율",
       A.생존율 - B.생존율 "연령대별 생존율 차이"
FROM ( -- 남성의 연령대별 생존율 view
         SELECT sex 성별, AGEBAND 연령대,COUNT(passengerid) 탑승자수, SUM(survived) 생존자수,
                ROUND(SUM(survived)/COUNT(passengerid)*100,2) 생존율
         FROM (SELECT FLOOR(AGE/10)*10 AGEBAND, age, survived, sex, passengerid
               FROM titanic)
               GROUP BY AGEBAND, sex
               HAVING sex = 'male'
     ) A
     LEFT JOIN 
     ( -- 여성의 연령대별 생존율 view
         SELECT sex 성별, AGEBAND 연령대,COUNT(passengerid) 탑승자수, SUM(survived) 생존자수,
                ROUND(SUM(survived)/COUNT(passengerid)*100,2) 생존율
         FROM (SELECT FLOOR(AGE/10)*10 AGEBAND, age, survived, sex, passengerid
               FROM titanic)
         GROUP BY AGEBAND, sex
         HAVING sex = 'female'
     ) B
     ON A.연령대 = B.연령대
ORDER BY A.연령대;

-- 전반적으로 여성의 경우 모든 연령대에서 60%이상의 생존율을 보이지만
-- 남성의 경우 10,20대의 생존율이 50,60대와 비슷하게 나타난다
-- 성별과 연령에 따라 생존율이 다르게 나타남
-- 타이타닉호 선장 구조활동 원칙에 따라 구조순서 : 어린이 여성 남성 순이었기 때문에 이런 결과가 나타남
-- 알려진 사실에 의하면 본인이 살겠다고 이성을 잃은 경우도 있었으나 공포틀 쏘면서 질서를 유지하도록 하게 했고 선장과 승무원들이 배와 운명을 같이 했다고 알려짐
-- 영국의 기사도 정신에 의한 결과라는 내용은 잘못된 주장으로 판명되었음
-- (선장의 책임의식이 알려지지 않았다면 타이타닉 구조활동의 결과는 영국식 기사도라는 잘못된 주장의 근거가 될 수도 있었을것임)
-- 분석할 때 다양한 관점과 가능성을 열어두고 해석해야 함

-- 객실 등급과 생존율 사이의 관계 정리

-- 1, 2, 3 등급이 존재
-- 1등실 : 부유한 승객 급한사정보다 여유를 즐기려고 승선한 승객이 많았고 객실을 최상층부터 갑판 E(상갑판)까지 설치되어 있었으며 호화 호텔수준으로 개인목욕탕이 있었음
    -- 중요포인트 (높은곳에 위치했음)
-- 2등실 : 비교적 편리한 시설이 설치되어 있었고 객실은 갑판 D부터 갑판 G까지 설치되어있었고 시설과 같이 존재함
-- 3등실 : 가난한 승객들이 타고 있었고 가장 낮은 갑판에 설치됨 엔진에 가까운 곳이고 여자와 남자는 배의 앞머리와 뒷머리에 떨어져 승선했으나 가족단위일 경우 같이 승선함
    -- 3등실이어도 다른 배보다는 대우가 좋았다고 함
    -- 엔진룸과 가까운 곳, 여자와 남자는 배의 앞머리와 뒷머리에 떨어져

-- 승객은 3등실이 가장 많았지만 생존율은 가장 떨어짐
-- 객실 등급에 따라 생존율이 차이가 남
-- 어린이 - 여성 - 남성 순으로 구조했다는 것과는 상충됨
SELECT pClass,
       COUNT(passengerid) 승객수, 
       SUM(survived) 생존자수,
       ROUND(SUM(survived)/COUNT(passengerid)*100,2) 생존율
FROM titanic
GROUP BY pClass
ORDER BY pClass;

-- 객실 등급과 성별을 조합해서 생존율 확인
SELECT sex, pClass,
       COUNT(passengerid) 승객수, 
       SUM(survived) 생존자수,
       ROUND(SUM(survived)/COUNT(passengerid)*100,2) 생존율
FROM titanic
GROUP BY pClass, sex
ORDER BY sex, pClass;

-- 동일 객실등급이어도 여성 생존율이 남성 생존율보다 월등히 높음
-- 남성이 객실 등급에 따라 생존율 차이가 나는 이유는 객실 위치 때문일 가능성이 높음

-- 연습문제
-- 객실 등급과 성별/연령대에 따른 생존율 관계 확인
-- 질의 결과에 따른 해석 추가

-- 타이타닉호의 생존율을 분석한 결과 객실 등급과 성별이 큰 영향을 미친 것으로 나타났다
-- 여성은 전체 객실 등급에서 높은 생존율을 보였고 객실 위치 특성에 따라 1등급 객실의 여성 생존율이 가장 높았다
-- 남성은 전체 객실 등급에서 여성에 비해 낮은 생존율을 보였고 특히 3등급 객실의 남성 생존율이 가장 낮았다
-- 10세 미만의 어린아이의 경우 성별과 상관없이 높은 생존율을 보였으며, 3등급 객실의 경우에도 성인 남성에 비해 상대적으로 높은 생존율을 보였다
-- 따라서 '여성과 어린아이를 우선으로 구조한다' 라는 원칙이 적용되었을 가능성이 높아보이고 객실 위치 및 구조의 차이가 생존율에 영향을 미쳤을 것으로 보인다
SELECT sex, pClass, AGEBAND,
       COUNT(passengerid) 승객수, 
       SUM(survived) 생존자수,
       ROUND(SUM(survived)/COUNT(passengerid)*100,2) 생존율
FROM (SELECT FLOOR(AGE/10)*10 AGEBAND, age, survived, sex, passengerid, pClass
      FROM titanic)
GROUP BY pClass, sex, AGEBAND
ORDER BY sex, pClass,AGEBAND;

-- TITANIC2 테이블 확인
SELECT * FROM TITANIC2;
DESCRIBE TITANIC2; -- 승객들의 거주지

-- 홈타운별 탑승객 수 및 생존율
SELECT homeTown,
       COUNT(passengerid) 탑승객수,
       ROUND(SUM(survived)/COUNT(passengerid)*100,2) 생존율
FROM titanic2
GROUP BY homeTown;

-- 홈타운별 탑승객 수가 10명 이상
-- 탑승객 거주 정보인 홈타운이 정형화되어있지 않음
SELECT homeTown,
       COUNT(passengerid) 탑승객수,
       ROUND(SUM(survived)/COUNT(passengerid)*100,2) 생존율
FROM titanic2
GROUP BY homeTown
HAVING COUNT(passengerid) >=10
ORDER BY 생존율;

-- 홈타운별 탑승객 수가 10명 이상이면서 생존율이 50%이상인 홈타운 확인
SELECT homeTown,
       COUNT(passengerid) 탑승객수,
       ROUND(SUM(survived)/COUNT(passengerid)*100,2) 생존율
FROM titanic2
GROUP BY homeTown
HAVING COUNT(passengerid) >=10 AND ROUND(SUM(survived)/COUNT(passengerid)*100,2) >=50
ORDER BY 생존율;









