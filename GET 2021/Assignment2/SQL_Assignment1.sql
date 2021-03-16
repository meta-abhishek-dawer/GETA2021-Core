Query 1:- Create all tables

create table Products(Product_id int, Product_Name varchar(20), InStock int(10));
create table Category(categoryId int PRIMARY KEY, CategoryName varchar(20), CategoryType varchar(20));
create table SubCategory(SubCategoryId int PRIMARY KEY, CategoryId int, SubCategoryName varchar(20));
create table ItemOrder(OrderId int NOT NULL, Product_id int NOT NULL, OrderDate DATE, price int );
create table ItemOrderStatus(OrderId int, OrderStatus varchar(15));
create table User(UserId int PRIMARY KEY, UserName varchar(20), OrderDate DATE, OrderId int NOT NULL);

Query 2:- show all tables
show tables;

Query 3:- Delete table product
drop table products;

Query 4:- Create product table again
create table products(Product_id int PRIMARY KEY, ProductName varchar(20), Price int, CategoryId int, Stock int, Description varchar(20));

Assginment 2
Query1 :- Insert values in tables
insert into products values(1, 'Íphone', 50000, 1, 10, 'Iphone11 pro');
insert into products values(2, 'Samsung', 20000, 1, 15, 'A31s');
insert into products values(3, 'Redmi', 15000, 1, 40, 'Note9 pro');
insert into products values(4, 'HP', 60000, 2, 20, 'pavillion');
insert into products values(5, 'DELL', 55000, 2, 15, 'Latitude 3410');
insert into products values(6, 'Shirt', 600, 3, 55, 'formal');
insert into products values(7, 'T-Shirt', 400, 3, 60, 'Half-Slieve');
insert into products values(8, 'Pants', 800, 3, 25, 'jeans');
insert into products values(9, 'pen', 10, 4, 100, 'Stationary');
insert into products values(10, 'NoteBook', 30, 4, 70, 'Stationary');
insert into products values(11, 'pencil', 5, 4, 150, 'Stationary');
select * from products

select * from products where stock>50;
select * from category;
insert into category values(1, 'Mobile', 'Electronics');
insert into category values(2, 'Laptop', 'Electronics')	1 row(s);
SET SQL_SAFE_UPDATES=0;
delete from products where categoryId = '3';
select * from products;
insert into products values(6, 'Pants', 800, 3, 30, 'jeans');
insert into products values(7, 'Pants', 1000, 3, 25, 'formal');
insert into products values(8, 'Pants', 500, 3, 60, 'shorts');
select * from products;
select * from category;
insert into category values(3, 'Pants', 'Clothes');
select * from products;
insert into products values(9, 'pen', 10, 4, 50, 'ball pen');
select * from products;
insert into products values(10, 'pen', 20, 4, 60, 'gel pen');
insert into products values(11, 'flair', 20, 4, 20, 'writo meter');
select * from category;
insert into category values(4, 'Pen', 'Stationary');