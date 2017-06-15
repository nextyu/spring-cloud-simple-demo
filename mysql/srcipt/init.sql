USE test;
DROP TABLE IF EXISTS user;

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
CREATE TABLE user
(
  id   BIGINT NOT NULL AUTO_INCREMENT
  COMMENT 'id',
  name VARCHAR(50) COMMENT '姓名',
  PRIMARY KEY (id)
);

ALTER TABLE user
  COMMENT '用户表';
