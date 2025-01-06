 -- where 절
 -- 주문가능한 메뉴만 조회
 SELECT * FROM tbl_menu;
 
 -- 테이블의 구조(스키마)를 바로 파악할 수 있다.
 DESC tbl_menu;
 
 select
 		 menu_name
  FROM tbl_menu
 WHERE orderable_status = 'Y'; -- mariadb는 대소문자 크게 상관x, 해석의 순서 잘 인지할 것
 
 -- -----------------------------------------------------------------------------------
 -- '기타' 카테고리에 해당하지 않는 메뉴를 조회하시오. (이런 조건이 들어왔다면?)
SELECT
 		 *
  FROM tbl_category
 WHERE category_name = '기타'; 		-- '=' 하나가 '같냐'라는 뜻(결과는 true or false)
 
 -- 카테고리 테이블을 통해 메뉴에도 있는 카테고리 코드 번호를 알게 됨(10번)
SELECT
		 * 
   FROM tbl_menu
--  WHERE category_code != 10; 		-- '!='과 '<>'는 '같지않냐'라는 뜻(mariadb 기준)
  WHERE category_code <> 10; 
  

-- 추후에 배움 서브쿼리라는걸 쓰면 하나의 sql문으로 작성 가능하당
SELECT
		 *
  FROM tbl_menu
 WHERE category_code != (SELECT category_code
 								 FROM tbl_category
 								WHERE category_name = '기타');
 								
-- =, != 과 같이 대소 비교 연산자(>, <, >=,<=)를 통해서도 where절에 활용할 수 있다. //왼쪽을 기준으로 대소비교 읽기
-- 5000원 이상의 메뉴 모든 컬럼 보기
SELECT
		 *
  FROM tbl_menu
 WHERE menu_price >= 5000
 ORDER BY menu_price asc;
 
 
 -- 논리연산자 ( and (이면서, 그리고, 동시에), or ( 이거나 또는))
 -- 5000원 이상이면서 7000원 미만인 메뉴 조회(동시에 만족 => AND)
 select
 		 *
   FROM tbl_menu
  WHERE menu_price >= 5000 
   AND menu_price < 7000;
   
-- 10000원보다 초과이거나 5000원 이하인 메뉴 조회(OR)
SELECT
		 *
  FROM tbl_menu
  WHERE menu_price > 10000
   OR menu_price <= 5000;
   
-- 5000원 이하이거나 카테고리 번호가 10번인 메뉴 조회
SELECT * FROM tbl_menu;
DESC tbl_menu;
SELECT
		 menu_code
	  , menu_name
	  , menu_price
	  , category_code
	  , orderable_status
  FROM tbl_menu
 WHERE menu_price <= 5000
 	 OR category_code = 10; 
	  
-- ------------------------------------------------------------
-- between 연산자 활용하기
-- 가격이 5000원 이상이면서 9000원 이하인 메뉴 전체 컬럼 조회
SELECT
		 *
  FROM tbl_menu
 WHERE menu_price >= 5000
   AND menu_price <= 9000;
	
SELECT
		 *
  FROM tbl_menu
 WHERE menu_price BETWEEN 5000 AND 9000;  -- 하한가 and 상한가
 
-- 반대 범위인 5000원 미만 또는 9000원 초과인 메뉴 전체 컬럼 조회
SELECT
		 *
  FROM tbl_menu
 WHERE menu_price NOT BETWEEN 5000 AND 9000;  -- 'not' 은 조건을 뒤집는 것
 
 -- ---------------------------------------------------
 -- like문
 -- 제목, 작성자 등을 검색할 때 사용
 -- %라는 와일드카드는 0개 이상의 문자를 뜻하는 특수기호이다.
 select
  FROM tbl_menu
 WHERE menu_name LIKE '%밥%'; 			 -- '%'는 0개 이상 문자 (기능이 있는 특수기호 칭함 -> wildcard)
 						
 select
 		 *
  FROM tbl_menu
 WHERE menu_name not LIKE '%밥%'	   	--밥이  들어가지 않는 내용 검색
 
 -- ---------------------------------------------------
 -- in 연산자
 -- 카테고리가 '중식', '커피', '기타'인 메뉴 조회하기 (이거나)
 
 select
 		 *
  FROM tbl_menu
 WHERE category_code = 5
 	 OR category_code = 8
 	 OR category_code = 10;
 	 
SELECT
		*
	FROM tbl_menu
--   WHERE category_code IN (5, 8, 10);         -- or로 찾기에는 범위가 너무 많을 경우 in을 사용해서 간단히 표현
  WHERE category_code not IN (5, 8, 10); 
  
-- ---------------------------------------------------
-- is null 연산자 활용 (값이 있냐 없냐~?) // 시험 많이 나와
SELECT
		 *
  FROM tbl_category
 WHERE ref_category_code IS NULL;    -- 상위 카테고리 조회 -> 저 카테고리중에 null이 들어간 것을 뽑아
 
 SELECT
		 *
  FROM tbl_category
 WHERE ref_category_code IS NOT NULL; -- 하위 카테고리 조회
 
  