--liquibase formatted sql
--changeset osipova.va:add new column program_details_id in table lesson failOnError:True dbms:postgresql

alter table lesson add program_details_id int references program_details(id);