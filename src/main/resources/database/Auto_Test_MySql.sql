CREATE DATABASE `tzj_auto_test`;

USE `tzj_auto_test`;

DROP TABLE IF EXISTS `test_project`;
CREATE TABLE `test_project` (
  `project_id`   INT(20)     NOT NULL                   AUTO_INCREMENT
  COMMENT '测试项目编号',
  `project_name` VARCHAR(64) NOT NULL
  COMMENT '测试项目名称',
  `create_user`  VARCHAR(64)                            DEFAULT NULL
  COMMENT '创建人',
  `create_time`  TIMESTAMP   NULL                       DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `update_time`  TIMESTAMP   NULL                       DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '更新时间',

  PRIMARY KEY (`project_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '测试项目表';


USE `tzj_auto_test`;
DROP TABLE IF EXISTS `test_case`;
CREATE TABLE `test_case` (
  `case_id`          INT(20)     NOT NULL                   AUTO_INCREMENT
  COMMENT '测试用例编号',
  `case_name`        VARCHAR(64) NOT NULL
  COMMENT '测试用例名称',
  `project_id`       INT(10)     NOT NULL
  COMMENT '测试项目编号',
  `case_description` VARCHAR(255)                           DEFAULT NULL
  COMMENT '测试用例描述',
  `test_result`      SMALLINT(1)                            DEFAULT NULL
  COMMENT '测试结果,1表示执行成功，0表示测试失败',
  `create_time`      TIMESTAMP   NULL                       DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `update_time`      TIMESTAMP   NULL                       DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '更新时间',

  PRIMARY KEY (`case_id`)

)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '测试用例表';


DROP TABLE IF EXISTS `test_step`;
USE `tzj_auto_test`;
CREATE TABLE `test_step` (
  `step_id`           INT(20)     NOT NULL                    AUTO_INCREMENT
  COMMENT '测试步骤编号',
  `step_name`         VARCHAR(64) NOT NULL
  COMMENT '测试步骤名称',
  `case_id`           INT(20)     NOT NULL
  COMMENT '测试用例编号',
  `request_path`      VARCHAR(64) NOT NULL
  COMMENT '请求路径,包含服务名称,例如new_partner.svc/api/',
  `request_method`    VARCHAR(32) NOT NULL
  COMMENT '请求方法',
  `request_parms`     VARCHAR(255)                            DEFAULT NULL
  COMMENT '请求参数',
  `need_transfer`     INT(10)                                 DEFAULT NULL
  COMMENT '是否传递返回值的参数',
  `need_verify_value` INT(10)                                 DEFAULT NULL
  COMMENT '是否校验返回值',
  `transfer_params`   VARCHAR(255)                            DEFAULT NULL
  COMMENT '保存的参数',
  `verify_code`       INT(20)                                 DEFAULT NULL
  COMMENT '验证响应码',
  `check_string`      VARCHAR(64)                             DEFAULT NULL
  COMMENT '校验返回值',
  `respone_body`      VARCHAR(1000)                           DEFAULT NULL
  COMMENT '保存响应记录',
  `test_result`       SMALLINT(1)                             DEFAULT NULL
  COMMENT '测试结果,1表示执行成功，0表示测试失败',
  `create_time`       TIMESTAMP   NULL                        DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `update_time`       TIMESTAMP   NULL                        DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '更新时间',

  PRIMARY KEY (`step_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '测试步骤表';


DROP TABLE IF EXISTS `test_task`;
CREATE TABLE `test_task` (
  `task_id`             INT(20)     NOT NULL                      AUTO_INCREMENT
  COMMENT '测试任务编号',
  `task_name`           VARCHAR(64) NOT NULL
  COMMENT '测试任务名称',
  `case_id`             INT(20)     NOT NULL
  COMMENT '测试用例编号',
  `task_status`         INT(10) UNSIGNED ZEROFILL                 DEFAULT NULL
  COMMENT '测试任务状态',
  `basic_url`           VARCHAR(255)                              DEFAULT NULL
  COMMENT '主机域名或IP地址+端口',
  `is_settime_task`     INT(10) UNSIGNED ZEROFILL                 DEFAULT NULL
  COMMENT '是否设置定时任务',
  `settime_task_status` INT(10) UNSIGNED ZEROFILL                 DEFAULT NULL
  COMMENT '定时任务的状态',
  `start_time`          VARCHAR(255)                              DEFAULT NULL
  COMMENT '定时任务开始时间',
  `run_time`            VARCHAR(255)                              DEFAULT NULL
  COMMENT '测试任务运行时间',
  `pass`                INT(10)                                   DEFAULT NULL
  COMMENT '测试用例通过数量',
  `fail`                INT(10)                                   DEFAULT NULL
  COMMENT '测试用例失败数量',
  `sum`                 INT(10)                                   DEFAULT NULL
  COMMENT '测试用例总数',
  `pass_rate`           INT(10)                                   DEFAULT NULL
  COMMENT '测试用例的通过率',
  `create_user`         VARCHAR(64)                               DEFAULT NULL
  COMMENT '创建人',
  `create_time`         TIMESTAMP   NULL                          DEFAULT CURRENT_TIMESTAMP
  COMMENT '创建时间',
  `update_time`         TIMESTAMP   NULL                          DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
  COMMENT '更新时间',

  PRIMARY KEY (`task_id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  COMMENT '测试任务表'