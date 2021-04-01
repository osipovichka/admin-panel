--liquibase formatted sql
--changeset osipova.va:alert table student_group failOnError:True dbms:postgresql

alter table student_group rename column users_id to user_id;
