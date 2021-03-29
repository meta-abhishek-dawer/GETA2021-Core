
#Query1:- 

DELIMITER $$
CREATE PROCEDURE monthlyProductsSales(month int, year int)
BEGIN
SELECT products.ProductName, count(products.Product_id) as MonthlySales FROM itemorder JOIN products ON (products.Product_id = itemorder.Product_id)
WHERE MONTH(itemorder.OrderDate) = month AND YEAR(itemorder.OrderDate) = year GROUP BY itemorder.Product_id;
END$$
DELIMITER ;

CALL monthlyProductsSales(3, 2021);

SELECT * FROM itemorderstatus;

#Query2:- 
DELIMITER $$
CREATE PROCEDURE OrderDetailsInPeriod(startingDate DATE, ENDingDate DATE)
BEGIN
if startingDate > ENDingDate THEN
SET startingDate = ENDingDate - INTERVAL DAY(ENDingDate) DAY;
END if;
SELECT itemorder.OrderId, itemorder.OrderDate, itemorder.price, itemorder.Status FROM itemorder WHERE itemorder.OrderDate >= startingDate AND itemorder.OrderDate <= ENDingDate;

END$$
DELIMITER ;

CALL OrderDetailsInPeriod('2021-03-01', CURDATE());