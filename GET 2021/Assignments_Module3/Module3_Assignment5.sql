
#query 1
CREATE view UserOrderView as SELECT user.UserId, user.UserName, user.Email, itemorder.price, itemorder.Product_id, itemorder.OrderDate, itemorder.Status FROM user JOIN itemorder ON(user.UserId = itemorder.UserId);

SELECT * FROM UserOrderView WHERE UserOrderView.OrderDate > now() - Interval 60 day;

#Query 2:-
SELECT * FROM UserOrderView S UserOrderView.Status= 'Shipped';

#Query3:-
SELECT * FROM UserOrderView  ORDER BY UserOrderView.Product_id DESC limit 5;
