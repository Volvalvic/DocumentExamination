drop table if exists document;

create table document (
  id identity,
  name varchar(100) not null,
  number varchar(100) not null,
);
