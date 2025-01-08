/* stored procedure */
-- 저장해둔 일련의 sql문장을 불러와 반봅 재사용함으로써 반복적인 작업을 효율화 함.
-- 반복적인 작업 효율화
-- 네트워크 트래픽 감소 효과 (DB에서 일어나는 일이기 때문)


--쿼리를 만들어주는 자동화 메크로를 만들었다! 는 느낌
delimiter //

CREATE OR REPLACE PROCEDURE getAllEmployees()
BEGIN
	  SELECT emp_id, emp_name, salary
		FROM employee;
END //

delimiter ; 

-- 출력할 때는 이렇게!
CALL getAllEmployees();

-- -------------------------------------------'
-- in 매개변수
delimiter //
CREATE OR REPLACE PROCEDURE getEmployeesByDepartment (
	 IN dept CHAR(2)
)
BEGIN 
	 SELECT emp_id, emp_name, salary, dept_code
	 FROM employee
	 WHERE dept_code = dept;
END // 

delimiter ;

CALL getEmployeesByDepartment('D5')
CALL getEmployeesByDepartment('D5')
CALL getEmployeesByDepartment('D5')


-- --------------------------------
-- out 매개변수(매개변수를 매개변수로 리턴해냄 / 리턴의 개념이 없지만 이거로 만듬)
DELIMITER //

CREATE OR replace PROCEDURE getEmployeeSalary(
	 IN id VARCHAR(3),
	 OUT sal DECIMAL(10,2)
)
BEGIN
	 SELECT salary INTO sal
	 FROM employee
	 WHERE emp_id = id;
END //

delimiter;

SET @sal = 0;
CALL getEmployeeSalary('201',@sal);
SELECT @sal;

-- ----------------------------------
-- inout 매개변수

delimiter//

CREATE OR REPLACE PROCEDURE updateAndReturnSalary (
	 IN id VARCHAR(3),
	 INOUT sal DECIMAL(10,2)
)
BEGIN
	 UPDATE employee
	 SET salary = sal
	 WHERE emp_id = id;
	 
	 SELECT salary + (salary * ifnull(bonus, 0)) INTO sal
	 FROM employee
	 WHERE emp_id = id;
END //

delimiter ;

SET @NEW_sal = 9000000;     						-- 전역변수
CALL updateAndReturnSalary('205',@NEW_sal);
SELECT @new_sal;

-- null이 포함된 연산은 결과값이 무조건 null (연산의미가 없음)
-- if null or nvl 함수를 활용하여 치환하여 나타내야 함

SELECT
		 salary AS 급여 
	  , bonus
	  , emp_neme
	  , salary * bonus AS 보너스
	  , salary + 
	  
	  
	  
-- @변수 의미
-- 1) '사용자 정의형 변수'
-- 2) 크기를 따로 정하지 않지만 대입해도 되는 값에 
-- 3) 전역 변수의 의미를 가짐

-- ----------------------------------------
-- if - else 활용;
delimiter //

CREATE OR REPLACE PROCEDURE chechEmployeeSalary(
	  IN id VARCHAR(3),
	  IN threshold DECIMAL(10,2),
	  OUT result VARCHAR(50)
)
BEGIN
	  DECLARE sal DECIMAL (10,2)
	  
	  SELECT salary INTO sal
	  FROM employee
	  WHERE emp_id = id;
	  
	  if sal > threshold then 														-- 조건문
	      SET result = '기준치를 넘는 급여입니다.';
	   else
	      SET result = '기준치와 같거나 기준치 이하의 급여입니다.';
	  END if;
END //

delimiter ;

SET @result = '';
CALL chechEmployeeSalary('200', 3000000, @result);
SELECT @result;

-- -------------------------------------------
-- case

delimiter //

CREATE OR REPLACE PROCEDURE getDepartmentMessage(
	  IN id VARCHAR(3),
	  OUT message VARCHAR(100)
)
BEGIN 	
	 DECLARE dept VARCHAR(50);
	 
	 SELECT dept_code INTO dept
	 from employee
	 WHERE emp_id = id;
	 
	 case
	     when dept = 'D1' then
	     	  SET message = '인사관리부 직원이시군요!';
	     when dept = 'D2' then
	    	  SET message = '회계관리부부 직원이시군요!';
	     when dept = 'D1' then
	        SET message = '마케팅부  직원이시군요!';
	     else
	        SET message = '어떤 부서 직원이신지 모르겠어요!'
	 END case;
END //

delimiter;

SET @message = '';
CALL getDepartmentMessage('221',@message);
SELECT @message;


-- ----------------------------------------
-- while 활용
delimiter //

CREATE OR REPLACE PROCEDURE calculateSumUpto(
	 IN max_num INT,
	 OUT SUM_result INT
)
BEGIN
	 DECLARE current_num INT DEFAULT 1;               -- 선언과 동시에 초기화
	 DECLARE total_sum INT DEFAULT 0;
	 
	  while current_num <= max_num do
	     SET total_sum = total_sum + CURRENT_num;
	     SET current_num = current_num + 1;
	  END while;
	  
	  SET sum_result = total_sum;
END //

delimiter ;

SET @result = 0;
CALL calculateSumUpTo(10, @result);
SELECT @result;

-- --------------------------------------
-- 예외 처리 
-- (예외상황에 알림을 띄운다는 개념으로 알아두세용)
delimiter //

CREATE PROCEDURE dividNumber(
	 IN numerator DOUBLE,
	 IN denominator DOUBLE,
	 OUT result DOUBLE
)
BEGIN 
	 DEClaRE division_by_zero CONDITION FOR SQLSTATE '45000';
	 DECLARE EXIT HANDLER FOR division_by_zero
	 begin
	     SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = '0d으로 나눌 수 없습니다.';
	 END;
	if denominator = 0 then
		 SIGNAL division_by_zero;
	  else
	    SET result = numerator / denominator;
	END if;
END //

delimiter ; 

SET @result = 0;
CALL dividNumber(10, 2, @result);
SELECT @result;
 CALL divideNumbers(10, 0, @result)  -- 나누는 수가 0일 때 division_by_zero 예외 처리가 동작함
 
-- ---------------------------------------
-- stored function
delimiter //

CREATE OR REPLACE FUNCTION getAnnualSalary(
	 id VARCHAR(3)
)
RETURNS DECIMAL(15,2)
DETERMINISTIC
BEGIN
	  DECLARE monthly_salary DECIMAL(10,2);
	  DECLARE annual_salary DECIMAL(15,2);
	  
	  SELECT salary INTO monthly_salary
	  FROM employee
	  WHERE emp_id = id;
	  
	  SET annual_salary = monthly_salary * 12;
	  
	  RETURN annual_salary;
END //

delimiter ;

SELECT
		 emp_name
	  , getAnnualSalary(emp_id) AS '연봉'
  FROM employee; 