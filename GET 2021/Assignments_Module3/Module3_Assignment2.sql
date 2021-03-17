#Assignments1
#Basically, In all table, id we have NOT NULL , PRIMARY KEYS. I use constraints already in Assignment1 and Assignment2

select * from products;
#Query1
select * from products INNER JOIN category ON(products.CategoryId = category.categoryId) group by category.CategoryId;

#Query 2 
SELECT COUNT(Price) from products WHERE Price BETWEEN 0 AND 100;
SELECT COUNT(Price) from products WHERE Price BETWEEN 101 AND 500;
SELECT COUNT(Price) from products WHERE Price>500;

#Query 3
SELECT products.CategoryId, COUNT(*) AS Number_of_Items from products GROUP BY products.CategoryId;



