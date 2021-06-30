--liquibase formatted sql
--changeset osipova.va:delete column feadback in table journal failOnError:True dbms:postgresql

alter table journal drop column feadback;