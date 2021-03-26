#Query 1:-
CREATE table city_details(pincode INT NOT NULL, CityName VARCHAR(20), State VARCHAR(20));
ALTER table city_details ADD PRIMARY KEY(pincode);

SELECT * FROM city_details WHERE pincode = 125104 ORDER BY city_details.State, city_details.CityName;