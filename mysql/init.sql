drop table if exists user;

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   bigint not null auto_increment comment 'id',
   name                 varchar(50) comment '姓名',
   primary key (id)
);

alter table user comment '用户表';
