-- CREATE DATABASE taxi;

create TABLE dict_role (
	id integer primary key ,
	name varchar(255)
);

insert into dict_role values (1, 'Клиент'), (2, 'Водитель');

create TABLE dict_status (
	id integer primary key ,
	name varchar(255)
);

insert into dict_status values (1, 'Заказана'), (2, 'Принята'), (3, 'Начата'), (4, 'Завершена');

CREATE SEQUENCE users_seq;

CREATE TABLE users (
	id integer primary key default nextval('users_seq'),
	username varchar(255) not null UNIQUE,
	password varchar(255) not null
);

CREATE TABLE user_info (
	id integer primary key references users(id),
	name varchar(255) not null,
	phone varchar(255) not null UNIQUE,
	card_number varchar(255) not null,
	role_id integer references dict_role(id)
);

CREATE SEQUENCE car_seq;

CREATE TABLE car (
	id integer primary key default nextval('car_seq'),
	carnumber varchar(255) not null UNIQUE,
	car_brand varchar(255) not null,
	color varchar(255) not null
);

CREATE TABLE driver_data (
	id integer primary key references users(id),
	car_id integer references car(id)
);

CREATE SEQUENCE trip_seq;

CREATE TABLE trip (
	id integer primary key default nextval('trip_seq'),
	start_date timestamp without time zone,
	end_date timestamp without time zone,
	client_id integer references users(id),
	driver_id integer references users(id),
	address_from varchar(255) not null,
	address_to varchar(255) not null,
	trip_cost float,
	status_id integer references dict_status(id)
	);