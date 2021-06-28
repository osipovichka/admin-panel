--liquibase formatted sql
--changeset osipova.va:alter table Group column courseProgramId add NOT NULL failOnError:True dbms:postgresql

alter table groups alter column course_program_id set not null;
