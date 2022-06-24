create sequence hibernate_sequence start 1 increment 1;

create table Dog (
                     id int8 not null,
                     birth date,
                     name varchar(255),
                     human_id int8,
                     primary key (id)
);

create table Human (
                       id int8 not null,
                       birth date,
                       name varchar(255),
                       primary key (id)
);

alter table if exists Dog
    add constraint FK601yb4mxnxsx01v3usl80t3el
    foreign key (human_id)
    references Human;