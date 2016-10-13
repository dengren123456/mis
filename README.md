# mis
<p>管理信息系统作业
<p>DROP TABLE IF EXISTS `保养人信息`;
CREATE TABLE `保养人信息` (
 `保养人ID` int(11) NOT NULL,
 `保养人` varchar(255) NOT NULL,
 `班组` varchar(255) NOT NULL,
 PRIMARY KEY (`保养人ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
