

#Query1:- 

DELIMITER $$
CREATE FUNCTION OrdersInMonth(month int, year int)
RETURNS int
BEGIN
DECLARE numberOfOrders int;
select count(*) into numberOfOrders from itemorder where YEAR(OrderDate) in(year) AND MONTH(OrderDate) in (month);
return (numberOfOrders);
END$$

select OrdersInMonth(03, 2021);

#QUERY 2:-

DELIMITER $$
CREATE FUNCTION MaximumOrderMonthInYear(year int)
RETURNS varchar(15)
BEGIN
DECLARE monthName varchar(15);
SELECT MONTHNAME(OrderDate) into monthName from itemorder where YEAR(OrderDate) in (year) GROUP BY MONTH(OrderDate) order by count(*) DESC limit 1;
return (monthName);
END$$
 
 select MaximumOrderMonthInYear(2021);

    