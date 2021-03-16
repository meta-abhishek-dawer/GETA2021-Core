create table user(UserId int PRIMARY KEY, UserName varchar(20));
select * from itemorderstatus;

Query1: - Some values are inserted in Assignment1 file and some in this file
insert into subcategory values(11, 4, 'Gel pen');
create table Images(ImageId int PRIMARY KEY, Product_id int, Image BLOB);
insert into category values(5, 'Maggie', 'Noodles');
insert into images values(2, 9, LOAD_FILE('C:\Users\abhishek.dawer_metac\Downloads\pen.jpg'));
insert into user values(5, 'Ruhi', 'ruhi@yahoomail.com', '9875346789');
insert into itemorder values(4, 2, 4, 20000,  DATE '2021-03-01');
insert into itemorderstatus values(4, 'Shipped');

Query2:- 
select products.Product_id, products.ProductName, products.price, category.CategoryName from products join category ON (products.CategoryId = category.categoryId) where Stock> 0 ORDER BY Product_id DESC;

Query3:-
select products.Product_id, products.ProductName, products.Price, products.Description from products join images ON (products.Product_id = images.Product_id) WHERE images.Image = NULL;

Query4:-
select subcategory.SubCategoryId, category.CategoryName, subcategory.SubCategoryName from subcategory join category ON(subcategory.CategoryId = category.categoryId) ORDER BY category.CategoryName, subcategory.SubCategoryName ASC; 

Query5:-
select * from category where categoryId NOT IN(Select CategoryId from subcategory);

Query 6:- 
select products.ProductName, products.Price, products.Description from products join category ON(products.CategoryId = category.categoryId) where category.CategoryName = 'Mobile';

Query 7:-
select * from products where Stock <50;
