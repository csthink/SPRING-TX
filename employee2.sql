CREATE TABLE `employee2` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `dept_id` int(11) unsigned NOT NULL COMMENT '部门编号',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uni_username` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='员工信息表';

CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '部门编号',
  `dept_name` varchar(20) NOT NULL COMMENT '部门名称',
  `address` varchar(100) NOT NULL DEFAULT '' COMMENT '部门地址',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='部门信息表';


INSERT INTO `jdbc`.`employee2`(`id`, `username`, `dept_id`, `create_time`, `update_time`) VALUES (1, 'jack', 1, '2019-02-01 09:31:21', '2019-02-02 09:31:21');
INSERT INTO `jdbc`.`employee2`(`id`, `username`, `dept_id`, `create_time`, `update_time`) VALUES (2, 'rose', 1, '2019-02-01 10:31:21', '2019-02-01 10:31:21');
INSERT INTO `jdbc`.`employee2`(`id`, `username`, `dept_id`, `create_time`, `update_time`) VALUES (3, 'meimei', 2, '2019-02-01 11:31:21', '2019-02-01 11:31:21');
INSERT INTO `jdbc`.`employee2`(`id`, `username`, `dept_id`, `create_time`, `update_time`) VALUES (4, 'lucy', 2, '2019-02-01 12:31:21', '2019-02-01 12:31:21');

INSERT INTO `jdbc`.`department`(`id`, `dept_name`, `address`, `create_time`, `update_time`) VALUES (1, '总经办', '飞天大厦110室', '2019-02-01 06:38:21', '2019-02-01 06:38:21');
INSERT INTO `jdbc`.`department`(`id`, `dept_name`, `address`, `create_time`, `update_time`) VALUES (2, '财务部', '飞天大厦120室', '2019-02-01 06:38:21', '2019-02-01 06:38:21');



