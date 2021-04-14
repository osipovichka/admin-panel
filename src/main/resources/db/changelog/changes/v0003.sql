--liquibase formatted sql
--changeset osipova.va:insert table city, role failOnError:True dbms:postgresql

insert into role (id, name) values (1, 'User');
insert into role (id, name) values (2, 'Admin');
insert into role (id, name) values (3, 'Teacher');
insert into role (id, name) values (4, 'Student');

insert into city (id, name) values (1, 'Москва');
insert into city (id, name) values (2, 'Санкт-Петеребург');
insert into city (id, name) values (3, 'Ростов-на-Дону');
insert into city (id, name) values (4, 'Новосибирск');
insert into city (id, name) values (5, 'Екатеренбург');
insert into city (id, name) values (6, 'Уфа');
insert into city (id, name) values (7, 'Воронеж');
insert into city (id, name) values (8, 'Омск');




