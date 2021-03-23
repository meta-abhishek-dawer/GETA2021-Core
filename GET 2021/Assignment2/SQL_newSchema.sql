CREATE TABLE user(Id INT PRIMARY KEY, name VARCHAR(20), Email VARCHAR(30) NOT NULL, MobileNo VARCHAR(10));  

CREATE TABLE category(categoryId INT PRIMARY KEY, Name VARCHAR(20), categoryType VARCHAR(20));

CREATE TABLE product(productId INT PRIMARY KEY, Name VARCHAR(20), StockQuantity INT NOT NULL, Price INT NOT NULL, Description VARCHAR(20), 
categoryId INT, FOREIGN KEY(categoryId) REFERENCES category(categoryId));

CREATE TABLE images(productId INT NOT NULL, ImageId INT NOT NULL, Image BLOB, FOREIGN KEY(productId) REFERENCES product(productId));

CREATE TABLE subcategory(subCategoryId INT PRIMARY KEY, categoryId int NOT NULL, Name VARCHAR(20),
FOREIGN KEY(categoryId) REFERENCES category(categoryId));

CREATE TABLE itemorder(orderId INT PRIMARY KEY, productId INT NOT NULL, userId INT NOT NULL, orderDate DATE, 
FOREIGN KEY(productId) REFERENCES product(productId),
FOREIGN KEY(userId) REFERENCES user(Id));

CREATE TABLE itemorderstatus(orderId INT NOT NULL, orderStatus VARCHAR(20), FOREIGN KEY(orderId) REFERENCES itemorder(orderId));



