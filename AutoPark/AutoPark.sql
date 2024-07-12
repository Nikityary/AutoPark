create database AutoPark;
use AutoPark;
show tables;
create table auto (id int primary key auto_increment, 
auto_name varchar(150), 
motor int check (motor >= 0 and motor <= 100), 
front_left_wheel TINYINT, 
front_right_wheel TINYINT,
rear_left_wheel TINYINT,
rear_right_wheel TINYINT,
oil int check (oil >= 0 and oil <= 100),
front_left_brake int check (front_left_brake >= 0 and front_left_brake <= 100), 
front_right_brake int check (front_right_brake >= 0 and front_right_brake <= 100),
rear_left_brake int check (rear_left_brake >= 0 and rear_left_brake <= 100),
rear_right_brake int check (rear_right_brake >= 0 and rear_right_brake <= 100),
front_left_turn_signal TINYINT,
front_right_turn_signal TINYINT,
rear_left_turn_signal TINYINT,
rear_right_turn_signal TINYINT,
left_headlight TINYINT,
right_headlight TINYINT,
left_brake_light TINYINT,
right_brake_light TINYINT);

insert into auto value ('3','ВАЗ 2001','74','1','1','1','1','35','80','80','80','80','1','1','0','1','1','0','1','1');

create table transportation_plan (id int primary key auto_increment, 
auto_name varchar(150), 
departure_date date, 
arrival_date date, 
start_point varchar(150),
end_point varchar(150));

insert into transportation_plan value ('1','Lada_Largus','2023.12.10','2023.12.26','Ярославль','Владимир');
INSERT INTO transportation_plan (auto_name, departure_date, arrival_date, start_point, end_point, on_the_way)
VALUES 
('Зил1', '2023-05-10', '2023-05-15', 'Москва', 'Санкт-Петербург', '0'),
('Mazda', '2023-06-01', '2023-06-07', 'Новосибирск', 'Екатеринбург', '0'),
('Citroen', '2023-07-12', '2023-07-20', 'Нижний Новгород', 'Казань', '0');
drop table auto;
select id, auto_name, departure_date, arrival_date, start_point, end_point, on_the_way from transportation_plan where auto_name = '' and on_the_way = '1';
select * from transportation_plan;
ALTER TABLE transportation_plan ADD on_the_way tinyint;
update transportation_plan set on_the_way = '1' where id = 1;
delete from auto where id > '1';
update auto set auto_name = 'Audi RS5' where id = 8;

select auto_name from auto;
select * from auto where auto_name ='Lada_Largus';


select * from auto;
update auto set 
motor = '', 
front_left_wheel = '', 
front_right_wheel = '', 
rear_left_wheel = '', 
rear_right_wheel = '', 
oil = '',
front_left_brake = '',
front_right_brake = '',
rear_left_brake = '',
rear_right_brake = '',
front_left_turn_signal = '',
front_right_turn_signal = '',
rear_left_turn_signal = '',
rear_right_turn_signal = '',
left_headlight = '',
right_headlight = '',
left_brake_light = '',
right_brake_light = ''
where auto_name = 'Lada_Largus';

select MAX(id) AS id from auto;
update transportation_plan set 
departure_date = '', 
arrival_date='', 
start_point='', 
end_point='', 
on_the_way ='1' 
where auto_name = '';

update transportation_plan set 
end_point='Владимир' 
where auto_name = 'УАЗ Патриот';