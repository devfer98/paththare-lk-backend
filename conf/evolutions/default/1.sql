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
  sellerid                      varchar(255),
  constraint pk_product primary key (productid)
);

create table buys (
  product_product_id            varchar(255) not null,
  customer_customer_id          varchar(255) not null,
  constraint pk_buys primary key (product_product_id,customer_customer_id)
);

create table promoter (
  promoterid                    varchar(255) not null,
  name                          varchar(255),
  category                      varchar(255),
  constraint pk_promoter primary key (promoterid)
);

create table promotes (
  promoter_promoter_id          varchar(255) not null,
  product_product_id            varchar(255) not null,
  constraint pk_promotes primary key (promoter_promoter_id,product_product_id)
);

create table seller (
  sellerid                      varchar(255) not null,
  storename                     varchar(255),
  category                      varchar(255),
  constraint pk_seller primary key (sellerid)
);

alter table product add constraint fk_product_sellerid foreign key (sellerid) references seller (sellerid) on delete restrict on update restrict;
create index ix_product_sellerid on product (sellerid);

alter table buys add constraint fk_buys_product foreign key (product_product_id) references product (productid) on delete restrict on update restrict;
create index ix_buys_product on buys (product_product_id);

alter table buys add constraint fk_buys_customer foreign key (customer_customer_id) references customer (customerid) on delete restrict on update restrict;
create index ix_buys_customer on buys (customer_customer_id);

alter table promotes add constraint fk_promotes_promoter foreign key (promoter_promoter_id) references promoter (promoterid) on delete restrict on update restrict;
create index ix_promotes_promoter on promotes (promoter_promoter_id);

alter table promotes add constraint fk_promotes_product foreign key (product_product_id) references product (productid) on delete restrict on update restrict;
create index ix_promotes_product on promotes (product_product_id);


# --- !Downs

alter table product drop foreign key fk_product_sellerid;
drop index ix_product_sellerid on product;

alter table buys drop foreign key fk_buys_product;
drop index ix_buys_product on buys;

alter table buys drop foreign key fk_buys_customer;
drop index ix_buys_customer on buys;

alter table promotes drop foreign key fk_promotes_promoter;
drop index ix_promotes_promoter on promotes;

alter table promotes drop foreign key fk_promotes_product;
drop index ix_promotes_product on promotes;

drop table if exists customer;

drop table if exists product;

drop table if exists buys;

drop table if exists promoter;

drop table if exists promotes;

drop table if exists seller;

