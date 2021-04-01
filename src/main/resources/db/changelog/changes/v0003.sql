--liquibase formatted sql
--changeset osipova.va:insert table city, role failOnError:True dbms:postgresql

insert into role (name) values ('User');
insert into role (name) values ('Admin');
insert into role (name) values ('Teacher');
insert into role (name) values ('Student');

insert into city (name) values ('Москва');
insert into city (name) values ('Санкт-Петеребург');
insert into city (name) values ('Ростов-на-Дону');
insert into city (name) values ('Новосибирск');
insert into city (name) values ('Екатеренбург');
insert into city (name) values ('Уфа');
insert into city (name) values ('Воронеж');
insert into city (name) values ('Омск');




