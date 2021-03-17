
#query 1
create view UserOrderView as select user.UserId, user.UserName, user.Email, itemorder.price, itemorder.Product_id, itemorder.OrderDate, itemorder.Status from user JOIN itemorder ON(user.UserId = itemorder.UserId);

select * from UserOrderView where UserOrderView.OrderDate > now() - Interval 60 day;

#Query 2:-
select * from UserOrderView where UserOrderView.Status= 'Shipped';

#Query3:-
select * from UserOrderView  ORDER BY UserOrderView.Product_id DESC limit 5;
