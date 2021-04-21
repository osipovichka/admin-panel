--liquibase formatted sql
--changeset osipova.va:alter table Course column price failOnError:True dbms:postgresql

ALTER TABLE course ALTER COLUMN price TYPE numeric(10,2);