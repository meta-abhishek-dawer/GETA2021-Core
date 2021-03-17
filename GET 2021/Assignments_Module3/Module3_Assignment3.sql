#Query1:- 
select user.UserId, user.UserName, COUNT(*) AS NumberOFOrders from itemorder INNER JOIN user ON(itemorder.UserId = user.UserId) WHERE itemorder.OrderDate > now() - Interval 30 day GROUP BY user.UserId;
select * from category;

#Query2:-
select user.UserName from user JOIN itemorder ON user.UserId = itemorder.UserId
WHERE DATEDIFF(CURDATE(), itemorder.OrderDate) <= 30
ORDER BY SUM(itemorder.Price) DESC limit 10;

#Query3:- 
select products.Product_id, products.ProductName, products.Description, COUNT(*) AS NumberOfProducts from products LEFT JOIN itemorder ON(products.Product_id = itemorder.Product_id) WHERE itemorder.OrderDate > now() - Interval 60 day Group by products.Product_id ORDER BY itemorder.OrderId DESC limit 20;

#Query4:-
Select SUM(Price) from itemorder GROUP BY MONTH(OrderDate);

#Query5:-

Update products JOIN itemorder ON (products.Product_id = itemorder.Product_id) 
SET products.ProductStatus = 'Inactive' where DATEDIFF(CURDATE(), itemorder.OrderDate) >= 90;

#Query 6:-
Select category.categoryId, products.ProductName, products.Stock, products.Description from category JOIN products ON (category.categoryId = products.CategoryId) where category.CategoryName = 'Mobile';

#Query 7:-
select products.ProductName, products.Price, products.Stock, products.Description from products join itemorder on(products.Product_id = itemorder.Product_id)
JOIN itemorderstatus on(itemorder.OrderId = itemorderstatus.OrderId) where itemorderstatus.OrderStatus = 'Cancelled' ORDER BY itemorderstatus.OrderStatus desc limit 10;

