--liquibase formatted sql
--changeset osipova.va:init failOnError:True dbms:postgresql

create table if not exists city
(
    id serial NOT NULL PRIMARY KEY,
    name varchar(30) not null
);

create table if not exists users
(
    id serial NOT NULL PRIMARY KEY,
    first_name varchar(15) not null,
    last_name varchar(15) not null,
    patronymic varchar(15),
    birth_date date,
    email varchar(50) not null,
    phone varchar(11),
    password varchar(255),
    city_id int references city (id),
    registration_date date
);

create table if not exists role
(
    id serial NOT NULL PRIMARY KEY,
    name varchar(15) not null
);

create table user_roles(
    user_id int not null references users(id),
    role_id int not null references role(id),

    unique (user_id, role_id)
);

create table course(
    id serial NOT NULL PRIMARY KEY,
    name varchar(100) not null,
    description text not null,
    price money not null
);

create table course_program(
    id serial NOT NULL PRIMARY KEY,
    course_id int not null references course(id),
    is_actual boolean not null,
    title varchar(50) not null
);

create table "group"(
    id serial NOT NULL PRIMARY KEY,
    start_date date not null,
    end_date date not null,
    time_start time(0) not null,
    duration int not null,
    course_program_id int not null references course_program(id)
);

create table news(
    id serial NOT NULL PRIMARY KEY,
    title varchar(50) not null,
    content text not null,
    publication_date date not null,
    author_id int not null references users(id),
    recipient_id int references users(id),
    group_id int references "group"(id)
);

create table program_details(
    id serial NOT NULL PRIMARY KEY,
    course_program_id int not null references course_program(id),
    lesson_number int not null,
    lesson_theme varchar(100) not null
);

create table theme_details(
    id serial NOT NULL PRIMARY KEY,
    program_details_id int not null references program_details(id),
    topic varchar(100) not null
);

create table course_program_skill(
    id serial NOT NULL PRIMARY KEY,
    course_program_id int not null references course_program(id),
    name varchar(50) not null
);

create table user_skill(
    users_id int not null references users(id),
    course_program_skill_id int not null references course_program_skill(id),

    unique (users_id, course_program_skill_id)
);

create table attestation_theme(
    id serial NOT NULL PRIMARY KEY,
    course_id int not null references course(id),
    theme varchar(50) not null
);

create table user_attestation(
    id serial NOT NULL PRIMARY KEY,
    users_id int not null references users(id),
    attestation_theme_id int not null references attestation_theme(id),
    theory_passed boolean not null,
    practice_passed boolean not null
);

create table lesson(
    id serial NOT NULL PRIMARY KEY,
    group_id int not null references "group"(id),
    day date not null,
    home_task varchar(200),
    read varchar(100),
    videos varchar(100)
);

create table lesson_topic(
    lesson_id int not null references lesson(id),
    theme_details_id int not null references theme_details(id),

    unique (lesson_id, theme_details_id)
);

create table student_group(
    id serial NOT NULL PRIMARY KEY,
    users_id int not null references users(id),
    group_id int not null references "group"(id),
    rating int
);

create table time_table(
    id serial NOT NULL PRIMARY KEY,
    group_id int not null references "group"(id),
    room_number int not null,
    day date not null,
    time_start time(0) not null,
    time_end time(0) not null
);

create table journal(
    id serial NOT NULL PRIMARY KEY,
    users_id int not null references users(id),
    lesson_id int not null references lesson(id),
    absent boolean not null,
    absent_reason varchar(50),
    feadback text
)
