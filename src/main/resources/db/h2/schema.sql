drop table if exists singer;

create table singer (
    id int primary key auto_increment,
    first_name varchar(225) not null,
    last_name varchar(225) not null
)