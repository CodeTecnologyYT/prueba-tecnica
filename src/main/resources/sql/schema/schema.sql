create table npt_user (
   id varchar(255) not null,
   date_created timestamp default CURRENT_TIMESTAMP,
   date_last_login timestamp default CURRENT_TIMESTAMP,
   date_modified timestamp default CURRENT_TIMESTAMP,
   email VARCHAR(100) not null,
   is_active VARCHAR(1) not null,
   name VARCHAR(100) not null,
   password VARCHAR(100) not null,
   primary key (id)
);
alter table npt_user
    add constraint UK_vujtw2ai84f4ll2u9g3snyih unique (email);

create table npt_phone (
   id varchar(255) not null,
   city_code VARCHAR(3) not null,
   country_code VARCHAR(5) not null,
   date_created timestamp default CURRENT_TIMESTAMP,
   date_modified timestamp default CURRENT_TIMESTAMP,
   number VARCHAR(15) not null,
   id_user varchar(255),
   primary key (id)
);

alter table npt_phone
    add constraint FKodsm9bgcqiaesxb8et1k0s95v
        foreign key (id_user)
            references npt_cuser;