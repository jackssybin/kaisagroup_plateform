
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kaisagroup_micro_msg` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `kaisagroup_micro_msg`;

DROP TABLE IF EXISTS `tb_msg_email`;

CREATE TABLE `tb_msg_email` (
  `tid` varchar(32) NOT NULL,
  `serial_no` varchar(16) DEFAULT NULL COMMENT '流水号',
  `from_user` varchar(30) DEFAULT NULL COMMENT '发送者',
  `to_user` varchar(1000) DEFAULT NULL COMMENT '接收者',
  `cc_user` varchar(1000) DEFAULT NULL COMMENT '抄送',
  `bcc_user` varchar(1000) DEFAULT NULL COMMENT '密送',
  `priority` varchar(30) DEFAULT NULL COMMENT '优先级',
  `template_id` varchar(30) DEFAULT NULL COMMENT '模板id',
  `receive_param` varchar(30) DEFAULT NULL COMMENT '接收参数',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_by` varchar(32) DEFAULT NULL,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `state` int(2) DEFAULT '1',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='邮件发送相关信息';

DROP TABLE IF EXISTS `tb_msg_template`;

CREATE TABLE `tb_msg_template` (
  `tid` varchar(32) NOT NULL,
  `subject` varchar(30) DEFAULT NULL COMMENT '邮件标题',
  `template_id` varchar(30) DEFAULT NULL COMMENT '模板id',
  `text_content` varchar(30) DEFAULT NULL COMMENT '模板内容',
  `is_html` varchar(30) DEFAULT NULL COMMENT '内容是否时html模板',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_by` varchar(32) DEFAULT NULL,
  `update_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_by` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='邮件发送相关信息';


DROP TABLE IF EXISTS `tb_mail_log`;

CREATE TABLE `tb_mail_log` (
  `tid` varchar(32) NOT NULL,
  `from_user` varchar(30) DEFAULT NULL COMMENT '发送者',
  `to_user` varchar(1000) DEFAULT NULL COMMENT '接收者',
  `cc_user` varchar(1000) DEFAULT NULL COMMENT '抄送',
  `bcc_user` varchar(1000) DEFAULT NULL COMMENT '密送',
  `priority` varchar(30) DEFAULT NULL COMMENT '优先级',
  `subject` varchar(30) DEFAULT NULL COMMENT '邮件标题',
  `template_id` varchar(30) DEFAULT NULL COMMENT '模板id',
  `text_content` varchar(30) DEFAULT NULL COMMENT '模板内容',
  `receive_param` varchar(100) DEFAULT NULL COMMENT '接收参数',
  `error_detail` varchar(200) DEFAULT NULL COMMENT '错误详情',
  `state` int(2) DEFAULT '1',
  `create_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `create_by` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='邮件日志';
