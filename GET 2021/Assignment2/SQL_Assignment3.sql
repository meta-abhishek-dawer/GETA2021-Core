Query1:- 
select * from itemorder ORDER BY OrderDate DESC limit 50;

Query 2:-
select * from itemorder ORDER BY price DESC limit 10;

Query3:-
select * from itemorder LEFT JOIN itemorderstatus ON(itemorder.OrderId = itemorderstatus.OrderId) where itemorder.OrderDate < now() - INTERVAL 10 day AND itemorderstatus.OrderStatus = 'Placed';

Query4:-
select user.userId, user.UserName, user.Email, user.MobileNo from user LEFT JOIN itemorder ON (user.UserId = itemOrder.UserId) BETWEEN '2021-02-16' AND '2021-03-15';

Query5:-
select * from user INNER JOIN itemorder ON(user.UserId = itemorder.UserId) where OrderDate > now() - INTERVAL 15 day;

Query6:-
select * from itemorder LEFT JOIN itemorderstatus ON(itemorder.OrderId = itemorderstatus.OrderId) where itemorderstatus.OrderId = 2 AND itemorderstatus.OrderStatus = 'Shipped';

Query7:-
select * from itemorder where Price BETWEEN 20 AND 50;