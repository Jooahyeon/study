-- limit
SELECT
		  menu_code
		, menu_name
		, menu_price
  FROM tbl_menu
 ORDER BY menu_price DESC, menu_code DESC
 LIMIT 4, 3; 						-- 프로그램언어에서는 위치를 설명부터는 0부터 시작 (인덱스체계) // 4번 인덱스부터 3개를 잘라! 라는 의미//pagenation할때 주로 사용
 
SELECT
		 *
  FROM tbl_menu
 ORDER BY menu_code LIMIT 10;   -- 첫번째 행부터 10개 (length의 의미만 가진다.)