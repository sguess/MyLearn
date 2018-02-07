show databases;
drop database tmp; 
create database tmp;
use tmp;
show tables;

select * from city;
select * from city_streets;
select * from mayor;
select * from street;

select * from user;


show databases;

show tables;

select * from sina_status_raw_data_table 
where id >250
order by id desc;
select * from sina_data_atype;
