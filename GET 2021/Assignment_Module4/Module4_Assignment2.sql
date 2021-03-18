
#Query1:- 

DELIMITER $$
CREATE PROCEDURE monthlyProductsSales(month int, year int)
BEGIN
select products.ProductName, count(products.Product_id) as MonthlySales from itemorder join products on (products.Product_id = itemorder.Product_id)
where MONTH(itemorder.OrderDate) = month AND YEAR(itemorder.OrderDate) = year group by itemorder.Product_id;
END$$
DELIMITER ;

CALL monthlyProductsSales(3, 2021);

select * from itemorderstatus;

#Query2:- 
DELIMITER $$
CREATE PROCEDURE OrderDetailsInPeriod(startingDate DATE, endingDate DATE)
BEGIN
if startingDate > endingDate then
set startingDate = endingDate - INTERVAL DAY(endingDate) DAY;
end if;
select itemorder.OrderId, itemorder.OrderDate, itemorder.price, itemorder.Status from itemorder where itemorder.OrderDate >= startingDate AND itemorder.OrderDate <= endingDate;

END$$
DELIMITER ;

CALL OrderDetailsInPeriod('2021-03-01', CURDATE());