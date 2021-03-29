#Query1:- 
SELECT user.UserId, user.UserName, COUNT(*) AS NumberOFOrders FROM itemorder INNER JOIN user ON(itemorder.UserId = user.UserId) WHERE itemorder.OrderDate > now() - Interval 30 day GROUP BY user.UserId;
SELECT * FROM category;

#Query2:-
SELECT user.UserName FROM user JOIN itemorder ON user.UserId = itemorder.UserId
WHERE DATEDIFF(CURDATE(), itemorder.OrderDate) <= 30
ORDER BY SUM(itemorder.Price) DESC limit 10;

#Query3:- 
SELECT products.Product_id, products.ProductName, products.Description, COUNT(*) AS NumberOfProducts FROM products LEFT JOIN itemorder ON(products.Product_id = itemorder.Product_id) WHERE itemorder.OrderDate > now() - Interval 60 day Group by products.Product_id ORDER BY itemorder.OrderId DESC limit 20;

#Query4:-
SELECT SUM(Price) FROM itemorder GROUP BY MONTH(OrderDate);

#Query5:-

Update products JOIN itemorder ON (products.Product_id = itemorder.Product_id) 
SET products.ProductStatus = 'Inactive' WHERE DATEDIFF(CURDATE(), itemorder.OrderDate) >= 90;

#Query 6:-
SELECT category.categoryId, products.ProductName, products.Stock, products.Description FROM category JOIN products ON (category.categoryId = products.CategoryId) WHERE category.CategoryName = 'Mobile';

#Query 7:-
SELECT products.ProductName, products.Price, products.Stock, products.Description FROM products join itemorder on(products.Product_id = itemorder.Product_id)
JOIN itemorderstatus on(itemorder.OrderId = itemorderstatus.OrderId) WHERE itemorderstatus.OrderStatus = 'Cancelled' ORDER BY itemorderstatus.OrderStatus DESC limit 10;

