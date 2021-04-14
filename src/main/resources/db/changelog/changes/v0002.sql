--liquibase formatted sql
--changeset osipova.va:add table teacher_group failOnError:True dbms:postgresql

create table teacher_group(
    user_id int not null references users(id),
    group_id int not null references "group"(id),

    unique (user_id, group_id)
);