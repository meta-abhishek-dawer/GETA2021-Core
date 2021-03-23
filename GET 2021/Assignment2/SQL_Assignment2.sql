#Query1:-
INSERT INTO products VALUES(1, 'Íphone', 50000, 1, 10, 'Iphone11 pro');
INSERT INTO products VALUES(2, 'Samsung', 20000, 1, 15, 'A31s');
INSERT INTO products VALUES(3, 'Redmi', 15000, 1, 40, 'Note9 pro');
INSERT INTO products VALUES(4, 'HP', 60000, 2, 20, 'pavillion');
INSERT INTO products VALUES(5, 'DELL', 55000, 2, 15, 'Latitude 3410');
INSERT INTO products VALUES(6, 'Shirt', 600, 3, 55, 'formal');
INSERT INTO products VALUES(7, 'T-Shirt', 400, 3, 60, 'Half-Slieve');
INSERT INTO products VALUES(8, 'Pants', 800, 3, 25, 'jeans');
INSERT INTO products VALUES(9, 'pen', 10, 4, 100, 'Stationary');
INSERT INTO products VALUES(10, 'NoteBook', 30, 4, 70, 'Stationary');
INSERT INTO products VALUES(11, 'pencil', 5, 4, 150, 'Stationary');
INSERT INTO category VALUES(1, 'Mobile', 'Electronics');
INSERT INTO category VALUES(2, 'Laptop', 'Electronics');
INSERT INTO products VALUES(6, 'Pants', 800, 3, 30, 'jeans');
INSERT INTO products VALUES(7, 'Pants', 1000, 3, 25, 'formal');
INSERT INTO products VALUES(8, 'Pants', 500, 3, 60, 'shorts');
INSERT INTO category VALUES(3, 'Pants', 'Clothes');
INSERT INTO products VALUES(9, 'pen', 10, 4, 50, 'ball pen');
INSERT INTO products VALUES(10, 'pen', 20, 4, 60, 'gel pen');
INSERT INTO products VALUES(11, 'flair', 20, 4, 20, 'writo meter');
INSERT INTO category VALUES(4, 'Pen', 'Stationary');
INSERT into subcategory VALUES(11, 4, 'Gel pen');
INSERT into category VALUES(5, 'Maggie', 'Noodles');
INSERT into images VALUES(2, 9, LOAD_FILE('C:\Users\abhishek.dawer_metac\Downloads\pen.jpg'));
INSERT into user VALUES(5, 'Ruhi', 'ruhi@yahoomail.com', '9875346789');
INSERT into itemorder VALUES(4, 2, 4, 20000,  DATE '2021-03-01');
INSERT into itemorderstatus VALUES(4, 'Shipped');

#Query2:- 
SELECT products.Product_id, products.ProductName, products.price, category.CategoryName FROM products JOIN category ON (products.CategoryId = category.categoryId) WHERE Stock> 0 ORDER BY Product_id DESC;

#Query3:-
SELECT products.Product_id, products.ProductName, products.Price, products.Description FROM products JOIN images ON (products.Product_id = images.Product_id) WHERE images.Image = NULL;

#Query4:-
SELECT subcategory.SubCategoryId, category.CategoryName, subcategory.SubCategoryName FROM subcategory JOIN category ON(subcategory.CategoryId = category.categoryId) ORDER BY category.CategoryName, subcategory.SubCategoryName ASC; 

#Query5:-
SELECT * FROM category WHERE categoryId NOT IN(SELECT CategoryId FROM subcategory);

#Query 6:- 
SELECT products.ProductName, products.Price, products.Description FROM products JOIN category ON(products.CategoryId = category.categoryId) WHERE category.CategoryName = 'Mobile';

#Query 7:-
SELECT * FROM products WHERE Stock <50;
