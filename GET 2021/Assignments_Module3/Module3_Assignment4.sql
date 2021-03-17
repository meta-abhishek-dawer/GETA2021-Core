#Query 1:-
create table city_details(pincode int NOT NULL, CityName varchar(20), State varchar(20));
alter table city_details ADD PRIMARY KEY(pincode);

insert into city_details values(302003, 'Jaipur', 'Rajasthan');

select * from city_details where pincode = 125104 order by city_details.State, city_details.CityName;