#Query1
SELECT * FROM products INNER JOIN category ON(products.CategoryId = category.categoryId) GROUP BY category.CategoryId;

#Query 2 
SELECT COUNT(Price) FROM products WHERE Price BETWEEN 0 AND 100;
SELECT COUNT(Price) FROM products WHERE Price BETWEEN 101 AND 500;
SELECT COUNT(Price) FROM products WHERE Price>500;

#Query 3
SELECT products.CategoryId, COUNT(*) AS Number_of_Items FROM products GROUP BY products.CategoryId;



