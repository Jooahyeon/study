SELECT menu_name, menu_code FROM tbl_menu;	

SELECT 
		 menu_name
		,menu_code
		,category_code
	FROM tbl_menu;	
	
SELECT
		 *
  FROM tbl_menu;
  
  -- ----------------------------------------------------------------
  select
  		*
  FROM tbl_category;
  	
-- -------------------------------------------------------------------
-- from절 없는 select 해보기-> select절 (절 cluase)
SELECT 7 + 3;
select 10 * 2;
SELECT 6 % 3, 6 % 4; -- 나머지값 모듈러스?
select NOW(); -- 서버의 현재시간
select CONCAT('유', ' ','관순'); -- 하나의 문자열로 나타내는 /글자를 이어줌


-- 별칭(alias)
SELECT 7 + 3 AS '합';
-- SELECT 2 * 3 AS 곱입니다.; -- 특수기호(띄어쓰기를 포함한) 사용시에는 (')싱글 쿼테이션 생략 불가// 특수기호 단독으로는 쓸 수 없다!
-- 									AS는 생략 가능하지만 가독성을 위해 생략하지 말자.

SELECT menu_name AS 메뉴명 FROM tbl_menu;
