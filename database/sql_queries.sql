-- create database
DROP DATABASE IF EXISTS hotel_reservation_system;

CREATE DATABASE hotel_reservation_system;

USE hotel_reservation_system;

CREATE TABLE room (
	id INT PRIMARY KEY AUTO_INCREMENT,
	description TEXT,
	number_of_person INT,
	have_private_bathroom BOOLEAN,
	price REAL
);

CREATE TABLE reservation (
	id INT PRIMARY KEY AUTO_INCREMENT,
	id_room INT NOT NULL REFERENCES room(id),
	check_in_date DATE,
	check_out_date DATE,
	full_name VARCHAR(25),
	email VARCHAR(25),
	phone VARCHAR(20),
	special_request TEXT
);