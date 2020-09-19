DELIMITER //
DROP PROCEDURE IF EXISTS `getCusById`//
CREATE PROCEDURE getCusById( cusNum INT)

BEGIN

  SELECT * FROM customers WHERE customerNumber = cusNum;

END //

DELIMITER ;

call getCusById(175);
-- out
DELIMITER //
DROP PROCEDURE IF EXISTS `GetCustomersCountByCity`//
CREATE PROCEDURE GetCustomersCountByCity( in_city VARCHAR(50),OUT total INT)

BEGIN

    SELECT COUNT(customerNumber) -- as result
	into total

    FROM customers

    WHERE city = in_city;

END//

DELIMITER ;

call GetCustomersCountByCity('Lyon',@abc);
select @abc;
-- inout
DELIMITER //

CREATE PROCEDURE SetCounter(INOUT counter INT,inc INT)

BEGIN

    SET counter = counter + inc;

END//

DELIMITER ;

set @counter=1;
call SetCounter(@counter,2);
select @counter;

