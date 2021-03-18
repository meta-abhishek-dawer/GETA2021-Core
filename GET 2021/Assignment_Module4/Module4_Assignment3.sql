
#ADDING INDEXES TO TABLES

#products table
ALTER TABLE products ADD INDEX ProductIndex(ProductName);

#category table
ALTER TABLE category ADD INDEX CategoryIndex(CategoryName);

#order table
ALTER TABLE itemorder ADD INDEX ItemOrderIndex(OrderDate);