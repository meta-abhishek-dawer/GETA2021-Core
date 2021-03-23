#Query1:- 
SELECT * FROM itemorder ORDER BY OrderDate DESC LIMIT 50;

#Query 2:-
SELECT * FROM itemorder ORDER BY price DESC LIMIT 10;

#Query3:-
SELECT * FROM itemorder LEFT JOIN itemorderstatus ON(itemorder.OrderId = itemorderstatus.OrderId) WHERE itemorder.OrderDate < now() - INTERVAL 10 day AND itemorderstatus.OrderStatus = 'Placed';

#Query4:-
SELECT user.userId, user.UserName, user.Email, user.MobileNo FROM user LEFT JOIN itemorder ON (user.UserId = itemOrder.UserId) BETWEEN '2021-02-16' AND '2021-03-15';

#Query5:-
SELECT * FROM user INNER JOIN itemorder ON(user.UserId = itemorder.UserId) WHERE OrderDate > now() - INTERVAL 15 day;

#Query6:-
SELECT * FROM itemorder LEFT JOIN itemorderstatus ON(itemorder.OrderId = itemorderstatus.OrderId) WHERE itemorderstatus.OrderId = 2 AND itemorderstatus.OrderStatus = 'Shipped';

#Query7:-
SELECT * FROM itemorder WHERE Price BETWEEN 20 AND 50;