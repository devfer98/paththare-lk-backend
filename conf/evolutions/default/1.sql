# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table customer (
  customerid                    varchar(255) not null,
  fname                         varchar(255),
  lname                         varchar(255),
  email                         varchar(255),
  phoneno                       varchar(255),
  constraint pk_customer primary key (customerid)
);

create table product (
  productid                     varchar(255) not null,
  name                          varchar(255),
  category                      varchar(255),
  constraint pk_product primary key (productid)
);

create table promoter (
  promoterid                    varchar(255) not null,
  name                          varchar(255),
  category                      varchar(255),
  constraint pk_promoter primary key (promoterid)
);

create table promoter_product (
  promoter_promoter_id          varchar(255) not null,
  product_product_id            varchar(255) not null,
  constraint pk_promoter_product primary key (promoter_promoter_id,product_product_id)
);

create table seller (
  sellerid                      varchar(255) not null,
  name                          varchar(255),
  category                      varchar(255),
  constraint pk_seller primary key (sellerid)
);

alter table promoter_product add constraint fk_promoter_product_promoter foreign key (promoter_promoter_id) references promoter (promoterid) on delete restrict on update restrict;
create index ix_promoter_product_promoter on promoter_product (promoter_promoter_id);

alter table promoter_product add constraint fk_promoter_product_product foreign key (product_product_id) references product (productid) on delete restrict on update restrict;
create index ix_promoter_product_product on promoter_product (product_product_id);


# --- !Downs

alter table promoter_product drop foreign key fk_promoter_product_promoter;
drop index ix_promoter_product_promoter on promoter_product;

alter table promoter_product drop foreign key fk_promoter_product_product;
drop index ix_promoter_product_product on promoter_product;

drop table if exists customer;

drop table if exists product;

drop table if exists promoter;

drop table if exists promoter_product;

drop table if exists seller;

