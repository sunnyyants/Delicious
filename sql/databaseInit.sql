drop database if exists finalProject;
create database if not exists finalProject;
use finalProject;
create table if not exists user( 
id integer auto_increment primary key,
username varchar(255),
password varchar(255),
firstname varchar(255),
lastname varchar(255),
address varchar(255),
zipcode varchar(10),
phone varchar(50),
email varchar(100),
registerDate date);

create table if not exists menu(
id integer auto_increment primary key,
name varchar(255),
imageURL varchar(255) ,
discription text,
price float,
likes int not null default 0);

create table if not exists cart(
id integer auto_increment,
userId integer,
constraint cart_user_fk foreign key(userId) references user(id) on delete cascade,
primary key(id, userId) 
);

create table if not exists cartWithselect(
id integer auto_increment primary key,
usrId integer,
cartId integer,
menuId integer,
mount integer,
constraint cws_cart_user_fk foreign key(cartId, usrId) references cart(id,userId) on delete cascade,
constraint cws_menu_fk foreign key(menuId) references menu(id) on delete cascade
);

create table if not exists orders(
id Integer auto_increment primary key,
uId Integer,
cId Integer,
orderDate date,
constraint order_cart_user_fk foreign key(cId, uId) references cart(id, userId) on delete cascade);

