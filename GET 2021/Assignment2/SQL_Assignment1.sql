#Query 1:- Create all tables

CREATE TABLE Products(Product_id INT, Product_Name VARCHAR(20), InStock INT(10));
CREATE TABLE Category(categoryId INT PRIMARY KEY, CategoryName VARCHAR(20), CategoryType VARCHAR(20));
CREATE TABLE SubCategory(SubCategoryId INT PRIMARY KEY, CategoryId INT, SubCategoryName VARCHAR(20));
CREATE TABLE ItemOrder(OrderId INT NOT NULL, Product_id INT NOT NULL, OrderDate DATE, price INT );
CREATE TABLE ItemOrderStatus(OrderId INT, OrderStatus VARCHAR(15));
CREATE TABLE User(UserId INT PRIMARY KEY, UserName VARCHAR(20), Email VARCHAR(20), MobileNo VARCHAR(10));
CREATE TABLE Images(ImageId INT PRIMARY KEY, Product_id INT, Image BLOB);

#Query 2:- show all tables
SHOW tables;

#Query 3:- Delete table product
DROP TABLE products;

#Query 4:- Create product table again
CREATE TABLE products(Product_id INT PRIMARY KEY, ProductName VARCHAR(20), Price INT, CategoryId INT, Stock INT, Description VARCHAR(20));
