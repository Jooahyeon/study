/* index */
-- 고유 인덱스: 중복된 값이 없는 컬럼에 달리는 인덱스(pk, uk(unique))
-- 비고유 인덱스: 중복된 값이 있는 컬럼에 달리는 인데스

SELECT * FROM tbl_menu;

CREATE TABLE phone (
	 phone_code INT PRIMARY KEY,
	 phone_name VARCHAR(100),
	 phone_price DECIMAL(10, 2)
);

INSERT
  INTO phone
VALUES
(1, 'galaxy24', 1200000),
(2, 'iphone16pro', 1430000),
(3, 'galaxfold7', 1730000);

SELECT * FROM phone;
SHOW INDEX FROM phone;


-- pk컬럼은 고유 인덱스가 있으므로 pk컬럼을 활용한(where절_조건절) 조회를 하자
-- (검색속도 향상을 위함)

SELECT * FROM phone WHERE phone_code = 1;
EXPLAIN SELECT * FROM phone WHERE phone_code = 1;

-- 다른 컬럼으로 조회 성능 향상을 위해서는 인덱스를 수동으로 달자.
-- (create index)

CREATE INDEX id_name ON phone(phone_name);
SHOW INDEX FROM phone;
ㅐ

-- 인덱스가 달린 컬럼을 조건으로 조회
SELECT * FROM phone WHERE phone_name = 'iphone16pro';
EXPLAIN SELECT * FROM phone WHERE phone_name = 'iphone16pro';

-- 인덱스는 필요한 곳에 달아야 함. (단점을 줄이기 위해)
-- 1) 조건으로 활용할 컬럼(where절, having절_그룹으로 묶은 경우, join 시 on에 사용하는 컬럼)
-- ()위에 처럼 하면 인덱스를 태울 수 있다는 뜻
-- 2) '=' 같다 조건으로 쓰일 컬럼
-- 3) 데이터가 자주 수정되지 않는 컬럼에 달아야 함. (대표적인게 pk컬럼)
-- 4) 전체 데이터의 10~15% 정도의 범위에 해당하는 조건이 가장 효율이 좋음
-- (비고유 인덱스만 해당)
-- 5) 카디널리티(구분되는 행의 갯수)가 높은(중복되지 않는 데이터일수록) 컬럼일수록 좋다. 
-- (중복되는 값이 많을수록 효율이 떨어짐)




-- 1) 별도의 저장공간 필요
-- 2) 주기적으로 인덱스를 다시 달아줘야 된다.
--  (주기가 정해져있진 않지만 한달에 한번은 권장
-- ( 자동화 할거면 _ 스프링 스퀘쥴러 활용→ 자동으로 쿼리 실행)

-- 어떻게 인덱스를 다시 달아줄건데? (인덱스 최적화)

optimize table phone;

-- 인덱스 삭제
DROP INDEX idx_name ON phone;
SHOW INDEX FROM phone;