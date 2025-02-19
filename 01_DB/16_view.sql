/* view */
-- 테이블을 활용한 가상 테이블
-- view는 원본 테이블을 참조해서 보여주는 용도이고
-- 보여지는건 실제 테이블(베이스 테이블)의 값이다.
-- 데이터가 아닌 쿼리를 저장하는 가상의 

SELECT
		 menu_name
	  , menu_price
  FROM tbl_menu;
  
-- view 또다른 테이블이 아닌 조회된 테이블을 보여주기 위한 가상의 테이블인 것!

-- view 를 사용하는 목적
-- 1) DBA가 일반 개발자 각각에게 필요한 만큼의 정보를 제공하기 위해 (접근 제어)
-- 2) 실제 비즈니스에서 사용되는 용어로 별칭을 달아 이해하기 쉽게 하기 위해
-- 3) 복잡한 DB관계를 고민하지 않고 사용할 수 있게 하기 위해

-- DROP VIEW v_menu;
CREATE OR replace VIEW v_menu
AS
SELECT
		 menu_name AS '메뉴명'
	  , menu_price AS '메뉴단가'
  FROM tbl_menu;
  
SELECT * FROM v_menu;

-- view는 DML작업이 가능하지만 사용을 비추천(경우에 따라 불가능한 경우들이 있음)
-- 베이스 테이블(tbl_menu)
SELECT * FROM tbl_menu;

-- '한식'카테고리만 담은 hansik 뷰 생성 (별칭이 일반적이나 수업때 생략!)
CREATE OR REPLACE VIEW hansik
AS
select
		 menu_code
	  , menu_name
	  , menu_price
	  , category_code
	  , orderable_status
  FROM tbl_menu
  WHERE category_code = 4;
  
SELECT * FROM hansik;

-- hansik 뷰를 통해 tbl_menu베이스 테이블에 영향을 주는지 확인 -> 주지않음
-- 이렇게 하는 방식은 비추천 
INSERT
	INTO hansik
VALUES
(NULL, '식혜맛국밥', 5500, 4, 'Y')

SELECT * FROM tbl_menu;

UPDATE hansik
	SET  menu_name = '버터맛국밥'
		, menu_price = 6000
  WHERE menu_name = '식혜맛국밥';
  
SELECT * FROM tbl_menu ORDER BY 1 DESC;

-- -----------------------------------------
-- view에 연산도 가능하나 조회에만 가능하고 실제 데이터에는 없는 값임 
-- 불가능한 경우,,,인데 설명해주신걸 이해 못함 ㅠㅠ(노션확인)
CREATE OR REPLACE VIEW v_test
AS
SELECT
		 AVG(menu_price) + 3
  FROM tbl_menu;
  
SELECT * FROM v_test;
