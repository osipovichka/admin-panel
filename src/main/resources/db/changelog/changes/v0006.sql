--liquibase formatted sql
--changeset osipova.va:alert table user_skill failOnError:True dbms:postgresql

alter table user_skill rename column users_id to user_id;