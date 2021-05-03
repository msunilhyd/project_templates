drop database RAM;

create database RAM;

use RAM;

create table category(
id int primary key auto_increment,
type varchar(50) not null unique,
image varchar(100) not null,
deleted int not null
) auto_increment = 101;

insert into category(type,image,deleted) values
('HomeAppliances','HomeAppliances.jpg',0),
('ElectricalWork','ElectricalWork.jpg',0),
('Beauty','Beauty.jpg',0),
('Cleaning','Cleaning.jpg',0),
('PestControl','PestControl.jpg',0);



create table subcategory(
id int primary key auto_increment,
type varchar(50) not null unique,
category_id int not null,
image varchar(100) not null,
deleted int not null,
foreign key(category_id) references category(id)
) auto_increment = 1001;


insert into subcategory(type,category_id,image,deleted) values
('Refrigerator',101,'Refrigerator.jpg',0),
('AC',101,'AC.jpg',0),
('WashingMachine',101,'WashingMachine.jpg',0),
('MainBoard',102,'MainBoard.jpg',0),
('Internal',102,'Internal.jpg',0),
('Manicure',103,'Manicure.jpg',0),
('Pedicure',103,'Pedicure.jpg',0),
('CockroachControl',105,'CockroachControl.jpg',0),
('TermiteControl',105,'TermiteControl.jpg',0),
('BathroomCleaning',104,'BathroomCleaning.jpg',0),
('KitchenCleaning',104,'KitchenCleaning.jpg',0);


create table service(
id int primary key auto_increment,
description varchar(300) not null,
approx_price float(10,2) not null,
subcategory_id int(10) not null,
deleted int not null,
foreign key(subcategory_id) references subcategory(id)
) auto_increment = 2001;

insert into service(description,approx_price,subcategory_id,deleted) values
('Fridge Gas Filling',2500.00,1001,0),
('Fridge Door Changing',500.00,1001,0),
('Setting Cooling efficiency',500.00,1001,0),
('Window AC Installation',1000.00,1002,0),
('Window AC UnInstallation',500.00,1002,0),
('Motor Damaged',2000.00,1003,0),
('WashingMachine Drain problem',500.00,1003,0);



create table user(
id int primary key auto_increment,
name varchar(100)  not null,
password varchar(100) not null,
email varchar(100) not null unique,
register_date date, 
mobile_number bigint(10) not null unique,
role varchar(6)
) auto_increment = 101;

insert into user(name,password,email,register_date,mobile_number,role) values
('kiran','kiran@123','kiran@gmail.com','2018-03-25',9885874779,'user'),
('sachin','sach@123','sachin@gmail.com','2018-04-21',9885724345,'user'),
('arun','arun@123','arun@gmail.com','2018-05-18',9885671238,'user'),
('suresh','suresh@123','suresh@gmail.com','2018-06-17',9885184869,'force'),
('laxmi','laxmi@123','laxmi@gmail.com','2018-03-17',9885275999,'force'),
('keerthi','keerthi@123','keerthi@gmail.com','2018-02-12',9885854579,'force'),
('surya','surya@123','surya@gmail.com','2018-05-12',9866854559,'user'),
('anil','anil@123','anil@gmail.com','2018-02-12',9985856679,'user');



create table address(
id int primary key auto_increment,
door_no varchar(30),
street varchar(20),
city varchar(30) not null,
state varchar(30) not null,
postal_code varchar(10),
user_id int not null,
deleted int not null,
foreign key(user_id) references user(id)
);


insert into address(door_no,street,city,state,postal_code,user_id,deleted) values
('852APT ','LEXINGTON','135TH ST','OP','12326',101,0),
('871APT','LIONSGATE','117ST','OP','65423',101,0),
('877APT','SKYLER','854ST','OP','45217',102,0);


create table reference(
 first_name varchar(30),
 last_name varchar(30),
 mobile_number bigint(12),
 email varchar(50),
 service_id int,
 user_id int,
 verified char(1),
 rating int,
 deleted int,
 foreign key(service_id) references service(id),
 foreign key(user_id) references user(id)
);


insert into reference values
('vinay','raj',9030267899,'vinay@gmail.com',2002,104,'N',4,0),
('vishnu','priya',9030269699,'vishnu@gmail.com',2001,104,'N',4,0),
('suresh','kumar',9866267349,'suresh@gmail.com',2005,102,'N',4,0),
('kumar','raja',9033265476,'kumar@gmail.com',2007,102,'N',4,0),
('venkat','rao',9133267899,'venkat@gmail.com',2001,102,'N',4,0);


create table work(
id int primary key auto_increment,
posted_date date not null,
description varchar(200),
status char(1) not null,
user_id int not null,
service_id int not null,
address_id int not null,
foreign key(user_id) references user(id),
foreign key(service_id) references service(id),
foreign key(address_id) references address(id)
) auto_increment = 501;


insert into work(posted_date,description,status,user_id,service_id,address_id) values
('2018-7-21','My AC is not working properly','O',103,2002,2),
('2018-7-22','Fridge cooling efficiency is very less','O',103,2004,2),
('2018-7-21','My AC is not working properly','O',107,2002,1);
