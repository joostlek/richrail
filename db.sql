create table trains
(
  key varchar(5) not null
    constraint trains_pk
      primary key
);

create table if not exists traincomponent
(
  key       varchar(5) not null
    constraint traincomponent_pk
      primary key,
  seats     integer default 0,
  train_key varchar(5)
    constraint traincomponent_trains_key_fk
      references trains
      on delete set null,
  type      varchar(10)
);

