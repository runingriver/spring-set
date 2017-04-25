USE test;
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(32) DEFAULT NULL COMMENT '用户名',
  `num` VARCHAR (12) NOT NULL DEFAULT '' COMMENT '学号',
  `sex` VARCHAR (10) NOT NULL DEFAULT '' COMMENT '性别',
  `country` varchar(32) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO test.student (name, num, sex, country)
VALUES ('student1','0001','男', 'china'),('student1','0002','女', 'American'),
       ('student1','0003','男', 'china'),('student1','0004','女', 'American'),
       ('student1','0005','男', 'china'),('student1','0006','女', 'American');