--liquibase formatted sql
--changeset osipova.va:delete tables failOnError:True dbms:postgresql

alter table theme_details drop constraint theme_details_program_details_id_fkey;
alter table lesson_topic drop constraint lesson_topic_theme_details_id_fkey;
alter table user_skill drop constraint user_skill_course_program_skill_id_fkey;

drop table news;
drop table theme_details;
drop table course_program_skill;
drop table user_skill;
drop table lesson_topic;
drop table time_table;