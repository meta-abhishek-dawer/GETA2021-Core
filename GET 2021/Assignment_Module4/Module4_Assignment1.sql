
#Query1:- 

DELIMITER $$
CREATE FUNCTION OrdersINMonth(month INT, year INT)
RETURNS INT
BEGIN
DECLARE numberOfOrders INT;
SELECT count(*) INTO numberOfOrders FROM itemorder where YEAR(OrderDate) IN(year) AND MONTH(OrderDate) IN (month);
return (numberOfOrders);
END$$

SELECT OrdersINMonth(03, 2021);

#QUERY 2:-

DELIMITER $$
CREATE FUNCTION MaximumOrderMonthINYear(year INT)
RETURNS VARCHAR(15)
BEGIN
DECLARE monthName VARCHAR(15);
SELECT MONTHNAME(OrderDate) INTO monthName FROM itemorder where YEAR(OrderDate) IN (year) GROUP BY MONTH(OrderDate) order by count(*) DESC limit 1;
return (monthName);
END$$
 
 SELECT MaximumOrderMonthINYear(2021);
 