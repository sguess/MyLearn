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


use sguess;
show tables;
select * from sguess.sys_para;
drop database sguess;
create database sguess;