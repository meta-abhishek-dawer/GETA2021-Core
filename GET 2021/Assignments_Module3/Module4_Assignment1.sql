select count(*) from itemorder where YEAR(OrderDate) = '2021' AND MONTH(OrderDate) = '02';

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


    