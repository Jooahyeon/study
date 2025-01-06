 --  order by(정렬)
 
 -- 오름차순(Ascending, ASC)
 -- 내림차순(Descending, DESC)
 select
 		 menu_code  -- 1
 	  , menu_name  -- 2
 	  , menu_price -- 3
  FROM tbl_menu
-- ORDER BY menu_price ASC;
-- ORDER BY menu_price					   	    -- 오름차순 생략가능(생략시 ASC)
-- ORDER BY menu_price, menu_name DESC; 	    -- 정렬의 우선순위를 가지고 여러 정렬 기분 적용이 가능하다(1차정렬, 2차정렬 등)
 ORDER BY 3  , 2 DESC; 								 -- select 절에 작성한 컬럼의 순번 활용 가능 (최근에 작성한걸 내림차순으로 정렬)
 															 -- 3-> (ASC 생략) 3번째 순서의 내용을 오름차순, 2번째 순서에 (정렬되지 않은) 두번째 값을 내림차순  ex.서울사는 2명의 홍길동씨, 이름 분류(1차) 나이분류(2차)

-- 별칭을 이용한 정렬
SELECT
		  menu_code AS 메뉴코드
		, menu_name AS 메뉴명
		, menu_price AS 메뉴가격
   FROM tbl_menu
order by 메뉴코드 DESC;	                     -- 별칭에 특수기호 있을 시 별칭을 활용한 정렬 x(특수기호 쓰기지 말자)

-- field 함수를 활용한 정렬이 가능하다 (시험범위야)
SELECT FIELD('a','b','c','a');


-- 주문 불가능한 메뉴부터 보기 (이런걸 보고 쿼리를 짤 수 있는 눙력)
-- field를 왜 쓰냐?!
SELECT 
		  orderable_status
		, FIELD(orderable_status, 'Y', 'N') AS 가능여부
  FROM tbl_menu
-- ORDER BY 2 DESC;
-- ORDER BY FIELD(oderable_status, 'y', 'N') desc;
 ORDER BY 가능여부 DESC;
 
 -- ----------------------------------------------------------------
 -- null 값(비어 있는 컬럼 값)에 대한 정렬
 SELECT * FROM tbl_category;
 
 -- 1) 오름차순 시 : null값이 먼저 나옴
 select
 		 *
  FROM tbl_category
 ORDER BY ref_category_code ASC;
 
 -- 2) 내림차순 시 : null값이 마지막에 나옴
 select
 		 *
  FROM tbl_category
 ORDER BY ref_category_code DESC;
 
  -- 3) 오름차순 시 : null값이 먼저 나옴
 select
 		 *
  FROM tbl_category
 ORDER BY -ref_category_code DESC;   			-- desc를 통해 null의 위치(나중)를 선정하고 desc와 반대(asc)로 컬럼값을 정렬
 
 -- 4) 내림차순 시 : null값이 마지막에 나옴
 select
 		 *
  FROM tbl_category
 ORDER BY -ref_category_code ASC;				-- asc를 통해 null의 위치(먼저)를 선정하고 asc와 반대(desc)로 컬럼값 정렬
 
