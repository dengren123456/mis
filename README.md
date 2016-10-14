# mis
## 管理信息系统作业</br>
### 建表</br>
DROP TABLE IF EXISTS `保养记录`;</br>
CREATE TABLE `保养记录` (</br>
  `记录ID` int(11) NOT NULL AUTO_INCREMENT,</br>
  `保养时间` date NOT NULL,</br>
  `说明` varchar(255) DEFAULT NULL,</br>
  `F保养人ID` int(11) NOT NULL,</br>
  PRIMARY KEY (`记录ID`),</br>
  KEY `保养人ID` (`F保养人ID`),</br>
  CONSTRAINT `保养人ID` FOREIGN KEY (`F保养人ID`) REFERENCES `保养人信息` (`保养人ID`)</br>
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;</br>
INSERT INTO `保养记录` VALUES ('1', '2015-10-01', null, '1');</br>
INSERT INTO `保养记录` VALUES ('2', '2015-10-07', null, '1');</br>
<p></p>
DROP TABLE IF EXISTS `保养人信息`;</br>
CREATE TABLE `保养人信息` (</br>
  `保养人ID` int(11) NOT NULL,</br>
  `保养人` varchar(255) NOT NULL,</br>
  `班组` varchar(255) NOT NULL,</br>
  PRIMARY KEY (`保养人ID`)</br>
) ENGINE=InnoDB DEFAULT CHARSET=utf8;</br>
INSERT INTO `保养人信息` VALUES ('1', '张三', '001');</br>
<p></p>
DROP TABLE IF EXISTS `检修项目`;</br>
CREATE TABLE `检修项目` (</br>
  `检修项目ID` int(11) NOT NULL AUTO_INCREMENT,</br>
  `保养内容` varchar(255) NOT NULL,</br>
  `保养情况` varchar(255) NOT NULL,</br>
  `备注` varchar(255) DEFAULT NULL,</br>
  `F类别ID` int(11) NOT NULL,</br>
  PRIMARY KEY (`检修项目ID`),</br>
  KEY `类别ID` (`F类别ID`)</br>
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;</br>
INSERT INTO `检修项目` VALUES ('1', '检查6000V接线盒内瓷瓶、端子', '更换端子', null, '1');</br>
INSERT INTO `检修项目` VALUES ('2', '接线盒内卫生清洁', '完成', null, '1');</br>
INSERT INTO `检修项目` VALUES ('3', '检查电缆引线、穿线管、接地线', '完成', null, '1');</br>
INSERT INTO `检修项目` VALUES ('4', '检查进线口密封情况', '完成', null, '1');</br>
INSERT INTO `检修项目` VALUES ('5', '检查前后轴承温度传感器的接线盒', '完成', null, '1');</br>
INSERT INTO `检修项目` VALUES ('6', '检查定子绕组温度传感器的接线盒', '完成', null, '1');</br>
INSERT INTO `检修项目` VALUES ('7', '检查防潮加热器的接线盒', '完成', null, '1');</br>
<p></p>
DROP TABLE IF EXISTS `类别`;</br>
CREATE TABLE `类别` (</br>
  `类别ID` int(11) NOT NULL AUTO_INCREMENT,</br>
  `设备类别` varchar(255) NOT NULL,</br>
  `保养类别` varchar(255) NOT NULL,</br>
  `保养周期（天）` int(11) NOT NULL,</br>
  PRIMARY KEY (`类别ID`),</br>
  KEY `设备类别` (`设备类别`)</br>
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;</br>
INSERT INTO `类别` VALUES ('1', '6000V及以上电机', '年检', '365');</br>
<p></p>
DROP TABLE IF EXISTS `设备`;</br>
CREATE TABLE `设备` (</br>
  `设备ID` varchar(11) NOT NULL,</br>
  `FF类型ID` int(11) NOT NULL,</br>
  `F记录ID` int(11) NOT NULL,</br>
  `最近一次保养时间` date NOT NULL,</br>
  PRIMARY KEY (`设备ID`),</br>
  KEY `设备类型` (`F记录ID`),</br>
  KEY `设备类别` (`FF类型ID`),</br>
  CONSTRAINT `记录ID` FOREIGN KEY (`F记录ID`) REFERENCES `保养记录` (`记录ID`) ON DELETE CASCADE ON UPDATE CASCADE,</br>
  CONSTRAINT `设备类别` FOREIGN KEY (`FF类型ID`) REFERENCES `类别` (`类别ID`) ON DELETE CASCADE ON UPDATE CASCADE</br>
) ENGINE=InnoDB DEFAULT CHARSET=utf8;</br>
INSERT INTO `设备` VALUES ('000001', '1', '1', '2015-10-01');</br>
<p></p>
DROP TABLE IF EXISTS `消耗记录`;</br>
CREATE TABLE `消耗记录` (</br>
  `消耗ID` int(11) NOT NULL AUTO_INCREMENT,</br>
  `修理内容` varchar(255) NOT NULL,</br>
  `消耗材料` varchar(255) NOT NULL,</br>
  `消耗数量` int(11) NOT NULL,</br>
  `剩余数量` int(11) NOT NULL,</br>
  `F检修项目ID` int(11) DEFAULT NULL,</br>
  KEY `消耗ID` (`消耗ID`),</br>
  KEY `检修项目ID` (`F检修项目ID`),</br>
  CONSTRAINT `检修项目ID` FOREIGN KEY (`F检修项目ID`) REFERENCES `检修项目` (`检修项目ID`)</br>
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;</br>
INSERT INTO `消耗记录` VALUES ('1', '更换端子', '端子', '1', '10', '1');</br>
<p></p>
### 查询</br>
use 电气设备保养;</br>
select 设备.设备ID,类别.设备类别,类别.保养类别,保养记录.保养时间,保养记录.说明,</br>
保养人信息.保养人,保养人信息.班组,检修项目.保养内容,检修项目.保养情况,检修项目.备注,</br>
消耗记录.修理内容,消耗记录.消耗材料,消耗记录.消耗数量,消耗记录.剩余数量</br>
from 设备</br>
left join 类别</br>
on 设备.FF类型ID=类别.类别ID</br>
left join 保养记录</br>
on 设备.F记录ID=保养记录.记录ID</br>
left join 保养人信息</br>
on 保养记录.F保养人ID=保养人信息.保养人ID</br>
left join 检修项目</br>
on 类别.类别ID=检修项目.F类别ID</br>
left join 消耗记录</br>
on 检修项目.检修项目ID=消耗记录.F检修项目ID</br>
where 设备ID="000001"</br>
![查询设备信息](http://a.hiphotos.baidu.com/image/pic/item/14ce36d3d539b6009a428951e150352ac75cb74c.jpg)
<p></p>
select 设备.设备ID,设备.最近一次保养时间, 类别.保养类别</br>
from 设备</br>
left join 类别</br>
on 设备.FF类型ID=类别.类别ID</br>
where exists ( select 保养周期（天） from 类别,设备 where 设备.FF类型ID=类别.类别ID) - datediff( now(), (select 最近一次保养时间 from 设备 ) ) < 20</br>
![设备预警](http://b.hiphotos.baidu.com/image/pic/item/8b82b9014a90f6033a861da13112b31bb051ed26.jpg)
<p></p>
### ER图</br>
![ER图](http://d.hiphotos.baidu.com/image/pic/item/6c224f4a20a446238aab20849022720e0df3d7f7.jpg)
<p></p>
### Axure网站链接</br>
http://pb7bz9.axshare.com
### Axure原型链接</br>
http://pan.baidu.com/s/1boLM6nH</br>
### 数据库链接</br>
http://pan.baidu.com/s/1eSfZmng</br>
