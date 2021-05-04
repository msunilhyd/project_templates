create database moviedb;

use moviedb;



create table movie(
    movie_id int primary key auto_increment,
    movie_name varchar(255),
    seats_available varchar(255),
    price int,
    rating varchar(255),
    theatre_screen varchar(255)
)auto_increment = 101;

insert into movie (movie_name, seats_available, price, rating, theatre_screen) values
 ('m1', 'A1-A100', 20, 'NC17', 'Screen1'),
 ('m2', 'B1-B100', 20, 'R', 'Screen2'),
 ('m3', 'C1-C100', 20, 'PG16', 'Screen3'),
 ('m4', 'D1-D100', 20, 'PG13', 'Screen4'),
 ('m5', 'E1-E100', 20, 'G', 'Screen5'),
 ('m6', 'F1-F100', 20, 'NC17', 'Screen6'),
 ('m7', 'G1-G100', 20, 'R', 'Screen7'),
 ('m8', 'H1-H100', 20, 'PG16', 'Screen8'),
 ('m9', 'I1-I100', 20, 'PG13', 'Screen9'),
 ('m10', 'J1-J100', 20, 'G', 'Screen10');



create table transaction(
    customer_id int primary key auto_increment,
    address varchar(255),
    movi_id int,
    theatre_screen varchar(255),
    adult varchar(255),
    child varchar(255),
    amount_due int
  ) auto_increment = 1001;

insert into transaction (address , movi_id, theatre_screen, adult, child, amount_due) values ('1Aghasfdasj', 101, 'Screen1', '18orabove', '10orbelow', 10),
  ('2Aghasfdasj', 102, 'Screen1', '18orabove', '10orbelow', 8),
  ('3Aghasfdasj', 103, 'Screen1', '18orabove', '10orbelow', 9),
  ('4Aghasfdasj', 104, 'Screen1', '18orabove', '10orbelow', 6),
  ('5Aghasfdasj', 105, 'Screen1', '18orabove', '10orbelow', 7),
  ('6Aghasfdasj', 106, 'Screen1', '18orabove', '10orbelow', 4),
  ('7Aghasfdasj', 107, 'Screen1', '18orabove', '10orbelow', 8),
  ('8Aghasfdasj', 108, 'Screen1', '18orabove', '10orbelow', 9),
  ('9Aghasfdasj', 109, 'Screen1', '18orabove', '10orbelow', 6),
  ('10Aghasfdasj', 110, 'Screen1', '18orabove', '10orbelow', 7);
