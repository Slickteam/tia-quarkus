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

INSERT INTO Human VALUES (1, '1990-09-24', 'Michel');
INSERT INTO Human VALUES (2, '1982-02-07', 'Beyonce');
INSERT INTO Dog VALUES (1, '2021-01-09', 'Poupouille', 1);
INSERT INTO Dog VALUES (2, '2015-11-25', 'Zazou', 1);
INSERT INTO Dog VALUES (3, '2017-07-12', 'Tyson', 2);