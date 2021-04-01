--liquibase formatted sql
--changeset osipova.va:alert table teacher_group failOnError:True dbms:postgresql

alter table teacher_group rename column users_id to user_id;