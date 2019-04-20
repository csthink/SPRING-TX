CREATE TABLE `employee` (
  `uid` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `username` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(32) NOT NULL,
  `name` varchar(20) NOT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO `jdbc`.`employee`(`uid`, `username`, `password`, `name`, `create_time`) VALUES (1, 'aaa', '111', '张三', '2019-03-20 18:55:19');
INSERT INTO `jdbc`.`employee`(`uid`, `username`, `password`, `name`, `create_time`) VALUES (2, 'bbb', '222', '李四', '2019-03-20 18:55:19');
INSERT INTO `jdbc`.`employee`(`uid`, `username`, `password`, `name`, `create_time`) VALUES (3, 'ccc', '333', '王五', '2019-03-20 18:55:19');
INSERT INTO `jdbc`.`employee`(`uid`, `username`, `password`, `name`, `create_time`) VALUES (4, 'test', '11233', '测试用户', '2019-03-20 18:55:19');
INSERT INTO `jdbc`.`employee`(`uid`, `username`, `password`, `name`, `create_time`) VALUES (5, 'jack', '12233', 'jack Jones', '2019-03-20 18:55:19');
INSERT INTO `jdbc`.`employee`(`uid`, `username`, `password`, `name`, `create_time`) VALUES (7, 'c3p0测试', '1111111', 'clone', '2019-03-20 18:55:19');
INSERT INTO `jdbc`.`employee`(`uid`, `username`, `password`, `name`, `create_time`) VALUES (8, 'ruby2', 'ruby111', 'ruby大叔', '2019-04-13 00:00:00');
INSERT INTO `jdbc`.`employee`(`uid`, `username`, `password`, `name`, `create_time`) VALUES (14, 'go2', 'go111', 'go大叔', '2019-04-13 09:41:11');
INSERT INTO `jdbc`.`employee`(`uid`, `username`, `password`, `name`, `create_time`) VALUES (15, 'jdbc_new', '111', 'jdbc template', '2019-04-19 22:08:59');
INSERT INTO `jdbc`.`employee`(`uid`, `username`, `password`, `name`, `create_time`) VALUES (32, '小王11', '111111', '王小二', '2019-04-20 19:36:07');