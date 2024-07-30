SET FOREIGN_KEY_CHECKS = 0;

/*==============================================================*/
/* User: OM                                               */
/*==============================================================*/
CREATE DATABASE OM;

create user OM;

GRANT all ON OM.* TO 'OM'@'%';

use OM;


drop table if exists OM_CODE;

drop table if exists OM_DUTY;

drop table if exists OM_EMP;

drop table if exists OM_EMP_RELATION;

drop table if exists OM_LOG;

drop table if exists OM_MAIN_SERVER;

drop table if exists OM_MIRROR_SERVER;

drop table if exists OM_ORG;

drop table if exists OM_ORGN_SET;

drop table if exists OM_POSI;

drop table if exists OM_POSI_EMP;

drop table if exists OM_TAG;


/*==============================================================*/
/* Table: OM_CODE                                               */
/*==============================================================*/
create table OM_CODE
(
   CODE_ID_             varchar(40) not null comment '代码ID',
   PARENT_CODE_ID_      varchar(40) comment '上级代码ID',
   CATEGORY_            varchar(20) not null comment '分类',
   CODE_                varchar(60) not null comment '代码',
   NAME_                varchar(60) comment '名称',
   EXT_ATTR_1_          varchar(60) comment '扩展属性1',
   EXT_ATTR_2_          varchar(60) comment '扩展属性2',
   EXT_ATTR_3_          varchar(60) comment '扩展属性3',
   EXT_ATTR_4_          varchar(60) comment '扩展属性4',
   EXT_ATTR_5_          varchar(60) comment '扩展属性5',
   EXT_ATTR_6_          varchar(60) comment '扩展属性6',
   ORDER_               numeric(8,0) comment '排序',
   primary key (CODE_ID_),
   key UQ_OM_CODE (CATEGORY_, CODE_)
);

alter table OM_CODE comment '代码';

/*==============================================================*/
/* Table: OM_DUTY                                               */
/*==============================================================*/
create table OM_DUTY
(
   ORGN_SET_ID_         varchar(40) not null comment '组织架构套ID',
   DUTY_ID_             varchar(40) not null comment '职务ID',
   DUTY_CODE_           varchar(60) not null comment '职务编码',
   DUTY_NAME_           varchar(60) not null comment '职务名称',
   DUTY_CATEGORY_       varchar(20) not null comment '职务分类',
   MEMO_                varchar(300) comment '备注',
   DUTY_TAG_            varchar(120) comment '职务标签',
   DUTY_EXT_ATTR_1_     varchar(120) comment '职务扩展属性1',
   DUTY_EXT_ATTR_2_     varchar(120) comment '职务扩展属性2',
   DUTY_EXT_ATTR_3_     varchar(120) comment '职务扩展属性3',
   DUTY_EXT_ATTR_4_     varchar(120) comment '职务扩展属性4',
   DUTY_EXT_ATTR_5_     varchar(120) comment '职务扩展属性5',
   DUTY_EXT_ATTR_6_     varchar(120) comment '职务扩展属性6',
   DUTY_EXT_ATTR_7_     varchar(120) comment '职务扩展属性7',
   DUTY_EXT_ATTR_8_     varchar(120) comment '职务扩展属性8',
   ORDER_               numeric(8,0) comment '排序',
   DUTY_STATUS_         varchar(20) not null comment '职务状态',
   CREATION_DATE_       datetime comment '创建日期',
   UPDATE_DATE_         datetime comment '修改日期',
   OPERATOR_ID_         varchar(40) comment '操作人员ID',
   OPERATOR_NAME_       varchar(60) comment '操作人员名称',
   primary key (ORGN_SET_ID_, DUTY_ID_),
   key UQ_OM_DUTY_CODE (ORGN_SET_ID_, DUTY_CODE_)
);

alter table OM_DUTY comment '职务';

/*==============================================================*/
/* Table: OM_EMP                                                */
/*==============================================================*/
create table OM_EMP
(
   ORGN_SET_ID_         varchar(40) not null comment '组织架构套ID',
   EMP_ID_              varchar(40) not null comment '人员ID',
   ORG_ID_              varchar(40) not null comment '机构ID',
   EMP_CODE_            varchar(60) not null comment '人员编码',
   EMP_NAME_            varchar(60) not null comment '人员名称',
   PASSWORD_            varchar(40) comment '密码',
   PASSWORD_RESET_REQ_  varchar(20) not null comment '密码重置',
   PARTY_               varchar(20) comment '政治面貌',
   EMP_LEVEL_           varchar(20) comment '职级',
   GENDER_              varchar(20) comment '性别',
   BIRTH_DATE_          datetime comment '出生日期',
   TEL_                 varchar(60) comment '电话',
   EMAIL_               varchar(60) comment '电子邮箱',
   IN_DATE_             datetime comment '入职日期',
   OUT_DATE_            datetime comment '离职日期',
   EMP_CATEGORY_        varchar(20) not null comment '人员分类',
   MEMO_                varchar(300) comment '备注',
   EMP_TAG_             varchar(120) comment '人员标签',
   EMP_EXT_ATTR_1_      varchar(120) comment '人员扩展属性1',
   EMP_EXT_ATTR_2_      varchar(120) comment '人员扩展属性2',
   EMP_EXT_ATTR_3_      varchar(120) comment '人员扩展属性3',
   EMP_EXT_ATTR_4_      varchar(120) comment '人员扩展属性4',
   EMP_EXT_ATTR_5_      varchar(120) comment '人员扩展属性5',
   EMP_EXT_ATTR_6_      varchar(120) comment '人员扩展属性6',
   EMP_EXT_ATTR_7_      varchar(120) comment '人员扩展属性7',
   EMP_EXT_ATTR_8_      varchar(120) comment '人员扩展属性8',
   ORDER_               numeric(8,0) comment '排序',
   EMP_STATUS_          varchar(20) not null comment '人员状态',
   CREATION_DATE_       datetime comment '创建日期',
   UPDATE_DATE_         datetime comment '更新日期',
   OPERATOR_ID_         varchar(40) comment '操作人员ID',
   OPERATOR_NAME_       varchar(60) comment '操作人员名称',
   primary key (ORGN_SET_ID_, EMP_ID_),
   key UQ_OM_EMP_CODE (ORGN_SET_ID_, EMP_CODE_)
);

alter table OM_EMP comment '人员';

/*==============================================================*/
/* Index: IX_OM_EMP_ORDER                                       */
/*==============================================================*/
create index IX_OM_EMP_ORDER on OM_EMP
(
   ORDER_
);

/*==============================================================*/
/* Table: OM_EMP_RELATION                                       */
/*==============================================================*/
create table OM_EMP_RELATION
(
   ORGN_SET_ID_         varchar(40) not null comment '组织架构套ID',
   EMP_RELATION_ID_     varchar(40) not null comment '人员关系ID',
   UPPER_EMP_ID_        varchar(40) not null comment '上级人员ID',
   LOWER_EMP_ID_        varchar(40) not null comment '下级人员ID',
   EMP_RELATION_        varchar(20) not null comment '人员关系',
   EMP_RELATION_CATEGORY_ varchar(20) comment '人员关系分类',
   MEMO_                varchar(300) comment '备注',
   EMP_RELATION_TAG_    varchar(120) comment '人员关系标签',
   EMP_RELATION_EXT_ATTR_1_ varchar(120) comment '人员关系扩展属性1',
   EMP_RELATION_EXT_ATTR_2_ varchar(120) comment '人员关系扩展属性2',
   EMP_RELATION_EXT_ATTR_3_ varchar(120) comment '人员关系扩展属性3',
   EMP_RELATION_EXT_ATTR_4_ varchar(120) comment '人员关系扩展属性4',
   EMP_RELATION_EXT_ATTR_5_ varchar(120) comment '人员关系扩展属性5',
   EMP_RELATION_EXT_ATTR_6_ varchar(120) comment '人员关系扩展属性6',
   EMP_RELATION_EXT_ATTR_7_ varchar(120) comment '人员关系扩展属性7',
   EMP_RELATION_EXT_ATTR_8_ varchar(120) comment '人员关系扩展属性8',
   ORDER_               numeric(8,0) comment '排序',
   EMP_RELATION_STATUS_ varchar(20) not null comment '人员关系状态',
   CREATION_DATE_       datetime comment '创建日期',
   UPDATE_DATE_         datetime comment '修改日期',
   OPERATOR_ID_         varchar(40) comment '操作人员ID',
   OPERATOR_NAME_       varchar(60) comment '操作人员名称',
   primary key (ORGN_SET_ID_, EMP_RELATION_ID_),
   key UQ_OM_EMP_RELATION (ORGN_SET_ID_, UPPER_EMP_ID_, LOWER_EMP_ID_, EMP_RELATION_)
);

alter table OM_EMP_RELATION comment '人员关系';

/*==============================================================*/
/* Table: OM_LOG                                                */
/*==============================================================*/
create table OM_LOG
(
   LOG_ID_              varchar(40) not null comment '日志ID',
   CATEGORY_            varchar(60) comment '分类',
   IP_                  varchar(60) comment 'IP',
   USER_AGENT_          varchar(200) comment '用户代理',
   URL_                 text comment '调用URL',
   ACTION_              varchar(200) comment '调用控制层接口',
   PARAMETER_MAP_       text comment '调用参数',
   BUSINESS_KEY_        varchar(40) comment '业务主键',
   ERROR_               varchar(20) comment '错误',
   MESSAGE_             text comment '信息',
   ORG_ID_              varchar(40) comment '机构ID',
   ORG_NAME_            varchar(60) comment '机构名称',
   POSI_ID_             varchar(40) comment '岗位ID',
   POSI_NAME_           varchar(60) comment '岗位名称',
   EMP_ID_              varchar(40) comment '人员ID',
   EMP_NAME_            varchar(60) comment '人员名称',
   CREATION_DATE_       datetime not null comment '创建日期',
   primary key (LOG_ID_)
);

alter table OM_LOG comment '日志';

/*==============================================================*/
/* Table: OM_MAIN_SERVER                                        */
/*==============================================================*/
create table OM_MAIN_SERVER
(
   MAIN_SERVER_ID_      varchar(40) not null comment '主服务器ID',
   MAIN_SERVER_NAME_    varchar(60) not null comment '主服务器名称',
   DRIVER_CLASS_NAME_   varchar(100) not null comment '驱动类名称',
   URL_                 varchar(200) not null comment '链接',
   USERNAME_            varchar(40) not null comment '用户名',
   PASSWORD_            varchar(40) not null comment '密码',
   MEMO_                varchar(300) comment '备注',
   LAST_SYNC_DATE_      datetime comment '上次同步日期',
   ORDER_               numeric(8,0) comment '排序',
   MAIN_SERVER_STATUS_  varchar(20) not null comment '主服务器状态',
   CREATION_DATE_       datetime comment '创建日期',
   UPDATE_DATE_         datetime comment '修改日期',
   OPERATOR_ID_         varchar(40) comment '操作人员ID',
   OPERATOR_NAME_       varchar(60) comment '操作人员名称',
   primary key (MAIN_SERVER_ID_),
   key UQ_OM_MAIN_SERVER_NAME (MAIN_SERVER_NAME_)
);

alter table OM_MAIN_SERVER comment '主服务器';

/*==============================================================*/
/* Table: OM_MIRROR_SERVER                                      */
/*==============================================================*/
create table OM_MIRROR_SERVER
(
   MIRROR_SERVER_ID_    varchar(40) not null comment '镜像服务器ID',
   MIRROR_SERVER_NAME_  varchar(60) not null comment '镜像服务器名称',
   DRIVER_CLASS_NAME_   varchar(100) not null comment '驱动类名称',
   URL_                 varchar(200) not null comment '链接',
   USERNAME_            varchar(40) not null comment '用户名',
   PASSWORD_            varchar(40) not null comment '密码',
   MEMO_                varchar(300) comment '备注',
   LAST_SYNC_DATE_      datetime comment '上次同步日期',
   ORDER_               numeric(8,0) comment '排序',
   MIRROR_SERVER_STATUS_ varchar(20) not null comment '镜像服务器状态',
   CREATION_DATE_       datetime comment '创建日期',
   UPDATE_DATE_         datetime comment '修改日期',
   OPERATOR_ID_         varchar(40) comment '操作人员ID',
   OPERATOR_NAME_       varchar(60) comment '操作人员名称',
   primary key (MIRROR_SERVER_ID_),
   key UQ_OM_MIRROR_SERVER_NAME (MIRROR_SERVER_NAME_)
);

alter table OM_MIRROR_SERVER comment '镜像服务器';

/*==============================================================*/
/* Table: OM_ORG                                                */
/*==============================================================*/
create table OM_ORG
(
   ORGN_SET_ID_         varchar(40) not null comment '组织架构套ID',
   ORG_ID_              varchar(40) not null comment '机构ID',
   PARENT_ORG_ID_       varchar(40) comment '上级机构ID',
   ORG_CODE_            varchar(60) not null comment '机构编码',
   ORG_NAME_            varchar(60) not null comment '机构名称',
   ORG_ABBR_NAME_       varchar(60) comment '机构简称',
   ORG_TYPE_            varchar(20) not null comment '机构类型',
   ORG_CATEGORY_        varchar(20) not null comment '机构分类',
   MEMO_                varchar(300) comment '备注',
   ORG_TAG_             varchar(120) comment '机构标签',
   ORG_EXT_ATTR_1_      varchar(120) comment '机构扩展属性1',
   ORG_EXT_ATTR_2_      varchar(120) comment '机构扩展属性2',
   ORG_EXT_ATTR_3_      varchar(120) comment '机构扩展属性3',
   ORG_EXT_ATTR_4_      varchar(120) comment '机构扩展属性4',
   ORG_EXT_ATTR_5_      varchar(120) comment '机构扩展属性5',
   ORG_EXT_ATTR_6_      varchar(120) comment '机构扩展属性6',
   ORG_EXT_ATTR_7_      varchar(120) comment '机构扩展属性7',
   ORG_EXT_ATTR_8_      varchar(120) comment '机构扩展属性8',
   ORDER_               numeric(8,0) comment '排序',
   ORG_STATUS_          varchar(20) not null comment '机构状态',
   CREATION_DATE_       datetime comment '创建日期',
   UPDATE_DATE_         datetime comment '修改日期',
   OPERATOR_ID_         varchar(40) comment '操作人员ID',
   OPERATOR_NAME_       varchar(60) comment '操作人员名称',
   primary key (ORGN_SET_ID_, ORG_ID_),
   key UQ_OM_ORG_CODE (ORGN_SET_ID_, ORG_CODE_)
);

alter table OM_ORG comment '机构';

/*==============================================================*/
/* Index: IX_OM_ORG_ORDER                                       */
/*==============================================================*/
create index IX_OM_ORG_ORDER on OM_ORG
(
   ORDER_
);

/*==============================================================*/
/* Table: OM_ORGN_SET                                           */
/*==============================================================*/
create table OM_ORGN_SET
(
   ORGN_SET_ID_         varchar(40) not null comment '组织架构套ID',
   PARENT_ORGN_SET_ID_  varchar(40) comment '上级组织架构套ID',
   ORGN_SET_CODE_       varchar(60) not null comment '组织架构套编码',
   ORGN_SET_NAME_       varchar(60) not null comment '组织架构套名称',
   ALLOW_SYNC_          varchar(20) not null comment '允许同步',
   MEMO_                varchar(300) comment '备注',
   ORDER_               numeric(8,0) comment '排序',
   ORGN_SET_STATUS_     varchar(20) not null comment '组织架构套状态',
   CREATION_DATE_       datetime comment '创建日期',
   UPDATE_DATE_         datetime comment '修改日期',
   OPERATOR_ID_         varchar(40) comment '操作人员ID',
   OPERATOR_NAME_       varchar(60) comment '操作人员名称',
   primary key (ORGN_SET_ID_),
   key UQ_OM_ORGN_SET_CODE (ORGN_SET_CODE_)
);

alter table OM_ORGN_SET comment '组织架构套';

/*==============================================================*/
/* Table: OM_POSI                                               */
/*==============================================================*/
create table OM_POSI
(
   ORGN_SET_ID_         varchar(40) not null comment '组织架构套ID',
   POSI_ID_             varchar(40) not null comment '岗位ID',
   ORG_ID_              varchar(40) not null comment '机构ID',
   DUTY_ID_             varchar(40) comment '职务ID',
   POSI_CODE_           varchar(60) comment '岗位编码',
   POSI_NAME_           varchar(60) not null comment '岗位名称',
   ORG_LEADER_TYPE_     varchar(20) comment '机构领导类型',
   POSI_CATEGORY_       varchar(20) not null comment '岗位分类',
   MEMO_                varchar(300) comment '备注',
   POSI_TAG_            varchar(120) comment '岗位标签',
   POSI_EXT_ATTR_1_     varchar(120) comment '岗位扩展属性1',
   POSI_EXT_ATTR_2_     varchar(120) comment '岗位扩展属性2',
   POSI_EXT_ATTR_3_     varchar(120) comment '岗位扩展属性3',
   POSI_EXT_ATTR_4_     varchar(120) comment '岗位扩展属性4',
   POSI_EXT_ATTR_5_     varchar(120) comment '岗位扩展属性5',
   POSI_EXT_ATTR_6_     varchar(120) comment '岗位扩展属性6',
   POSI_EXT_ATTR_7_     varchar(120) comment '岗位扩展属性7',
   POSI_EXT_ATTR_8_     varchar(120) comment '岗位扩展属性8',
   ORDER_               numeric(8,0) comment '排序',
   POSI_STATUS_         varchar(20) not null comment '岗位状态',
   CREATION_DATE_       datetime comment '创建日期',
   UPDATE_DATE_         datetime comment '修改日期',
   OPERATOR_ID_         varchar(40) comment '操作人员ID',
   OPERATOR_NAME_       varchar(60) comment '操作人员名称',
   primary key (ORGN_SET_ID_, POSI_ID_),
   key UQ_OM_POSI_CODE (ORGN_SET_ID_, POSI_CODE_)
);

alter table OM_POSI comment '岗位';

/*==============================================================*/
/* Table: OM_POSI_EMP                                           */
/*==============================================================*/
create table OM_POSI_EMP
(
   ORGN_SET_ID_         varchar(40) not null comment '组织架构套ID',
   POSI_EMP_ID_         varchar(40) not null comment '岗位人员ID',
   POSI_ID_             varchar(40) not null comment '岗位ID',
   EMP_ID_              varchar(40) not null comment '人员ID',
   MAIN_                varchar(20) not null comment '主岗位',
   POSI_EMP_CATEGORY_   varchar(20) comment '岗位人员分类',
   MEMO_                varchar(300) comment '备注',
   POSI_EMP_TAG_        varchar(120) comment '岗位人员标签',
   POSI_EMP_EXT_ATTR_1_ varchar(120) comment '岗位人员扩展属性1',
   POSI_EMP_EXT_ATTR_2_ varchar(120) comment '岗位人员扩展属性2',
   POSI_EMP_EXT_ATTR_3_ varchar(120) comment '岗位人员扩展属性3',
   POSI_EMP_EXT_ATTR_4_ varchar(120) comment '岗位人员扩展属性4',
   POSI_EMP_EXT_ATTR_5_ varchar(120) comment '岗位人员扩展属性5',
   POSI_EMP_EXT_ATTR_6_ varchar(120) comment '岗位人员扩展属性6',
   POSI_EMP_EXT_ATTR_7_ varchar(120) comment '岗位人员扩展属性7',
   POSI_EMP_EXT_ATTR_8_ varchar(120) comment '岗位人员扩展属性8',
   ORDER_               numeric(8,0) comment '排序',
   POSI_EMP_STATUS_     varchar(20) not null comment '岗位人员状态',
   CREATION_DATE_       datetime comment '创建日期',
   UPDATE_DATE_         datetime comment '更新日期',
   OPERATOR_ID_         varchar(40) comment '操作人员ID',
   OPERATOR_NAME_       varchar(60) comment '操作人员名称',
   primary key (ORGN_SET_ID_, POSI_EMP_ID_),
   key UQ_OM_POSI_EMP (ORGN_SET_ID_, POSI_ID_, EMP_ID_)
);

alter table OM_POSI_EMP comment '岗位人员';

/*==============================================================*/
/* Index: IX_POSI_EMP_EMP                                       */
/*==============================================================*/
create index IX_POSI_EMP_EMP on OM_POSI_EMP
(
   EMP_ID_
);

/*==============================================================*/
/* Index: IX_POSI_EMP_POSI                                      */
/*==============================================================*/
create index IX_POSI_EMP_POSI on OM_POSI_EMP
(
   POSI_ID_
);

/*==============================================================*/
/* Table: OM_TAG                                                */
/*==============================================================*/
create table OM_TAG
(
   ORGN_SET_ID_         varchar(40) not null comment '组织架构套ID',
   TAG_ID_              varchar(40) not null comment '标签ID',
   OBJ_ID_              varchar(40) not null comment '对象ID',
   OBJ_TYPE_            varchar(60) comment '对象类型',
   TAG_                 varchar(60) not null comment '标签',
   primary key (ORGN_SET_ID_, TAG_ID_)
);

alter table OM_TAG comment '标签';

alter table OM_CODE add constraint FK_OM_CODE foreign key (PARENT_CODE_ID_)
      references OM_CODE (CODE_ID_) on update restrict;

alter table OM_DUTY add constraint FK_OM_DUTY_ORGN_SET foreign key (ORGN_SET_ID_)
      references OM_ORGN_SET (ORGN_SET_ID_) on update restrict;

alter table OM_EMP add constraint FK_OM_EMP_ORG foreign key (ORGN_SET_ID_, ORG_ID_)
      references OM_ORG (ORGN_SET_ID_, ORG_ID_) on update restrict;

alter table OM_EMP add constraint FK_OM_EMP_ORGN_SET foreign key (ORGN_SET_ID_)
      references OM_ORGN_SET (ORGN_SET_ID_) on update restrict;

alter table OM_EMP_RELATION add constraint FK_OM_EMP_RELATION_LOWER_EMP foreign key (ORGN_SET_ID_, LOWER_EMP_ID_)
      references OM_EMP (ORGN_SET_ID_, EMP_ID_) on update restrict;

alter table OM_EMP_RELATION add constraint FK_OM_EMP_RELATION_ORNG_SET foreign key (ORGN_SET_ID_)
      references OM_ORGN_SET (ORGN_SET_ID_) on update restrict;

alter table OM_EMP_RELATION add constraint FK_OM_EMP_RELATION_UPPER_EMP foreign key (ORGN_SET_ID_, UPPER_EMP_ID_)
      references OM_EMP (ORGN_SET_ID_, EMP_ID_) on update restrict;

alter table OM_ORG add constraint FK_OM_ORG_ORGN_SET foreign key (ORGN_SET_ID_)
      references OM_ORGN_SET (ORGN_SET_ID_) on update restrict;

alter table OM_ORG add constraint FK_OM_ORG_PARENT foreign key (ORGN_SET_ID_, PARENT_ORG_ID_)
      references OM_ORG (ORGN_SET_ID_, ORG_ID_) on update restrict;

alter table OM_ORGN_SET add constraint FK_OM_ORGN_SET_PARENT foreign key (PARENT_ORGN_SET_ID_)
      references OM_ORGN_SET (ORGN_SET_ID_) on update restrict;

alter table OM_POSI add constraint FK_OM_POSI_DUTY foreign key (ORGN_SET_ID_, DUTY_ID_)
      references OM_DUTY (ORGN_SET_ID_, DUTY_ID_) on update restrict;

alter table OM_POSI add constraint FK_OM_POSI_ORG foreign key (ORGN_SET_ID_, ORG_ID_)
      references OM_ORG (ORGN_SET_ID_, ORG_ID_) on update restrict;

alter table OM_POSI add constraint FK_OM_POSI_ORGN_SET foreign key (ORGN_SET_ID_)
      references OM_ORGN_SET (ORGN_SET_ID_) on update restrict;

alter table OM_POSI_EMP add constraint FK_OM_POSI_EMP_EMP foreign key (ORGN_SET_ID_, EMP_ID_)
      references OM_EMP (ORGN_SET_ID_, EMP_ID_) on update restrict;

alter table OM_POSI_EMP add constraint FK_OM_POSI_EMP_ORGN_SET foreign key (ORGN_SET_ID_)
      references OM_ORGN_SET (ORGN_SET_ID_) on update restrict;

alter table OM_POSI_EMP add constraint FK_OM_POSI_EMP_POSI foreign key (ORGN_SET_ID_, POSI_ID_)
      references OM_POSI (ORGN_SET_ID_, POSI_ID_) on update restrict;

alter table OM_TAG add constraint FK_OM_TAG_ORGN_SET foreign key (ORGN_SET_ID_)
      references OM_ORGN_SET (ORGN_SET_ID_) on update restrict;


create or replace view OMV_CODE as
select CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_ from OM_CODE;

create or replace view OMV_DUTY as
select ORGN_SET.ORGN_SET_ID_, ORGN_SET.ORGN_SET_CODE_, ORGN_SET.ORGN_SET_NAME_, D.DUTY_ID_, D.DUTY_CODE_, D.DUTY_NAME_, D.DUTY_CATEGORY_, D.MEMO_, D.DUTY_TAG_, D.DUTY_EXT_ATTR_1_, D.DUTY_EXT_ATTR_2_, D.DUTY_EXT_ATTR_3_, D.DUTY_EXT_ATTR_4_, D.DUTY_EXT_ATTR_5_, D.DUTY_EXT_ATTR_6_, D.DUTY_EXT_ATTR_7_, D.DUTY_EXT_ATTR_8_, D.ORDER_, D.DUTY_STATUS_, D.CREATION_DATE_, D.UPDATE_DATE_, D.OPERATOR_ID_, D.OPERATOR_NAME_ from OM_DUTY D inner join OM_ORGN_SET ORGN_SET on ORGN_SET.ORGN_SET_ID_ = D.ORGN_SET_ID_;

create or replace view OMV_EMP as
select ORGN_SET.ORGN_SET_ID_, ORGN_SET.ORGN_SET_CODE_, ORGN_SET.ORGN_SET_NAME_, E.EMP_ID_, E.EMP_CODE_, E.EMP_NAME_, E.PASSWORD_RESET_REQ_, E.PARTY_, E.EMP_LEVEL_, E.GENDER_, E.BIRTH_DATE_, E.TEL_, E.EMAIL_, E.IN_DATE_, E.OUT_DATE_, E.EMP_CATEGORY_, E.MEMO_, E.EMP_TAG_, E.EMP_EXT_ATTR_1_, E.EMP_EXT_ATTR_2_, E.EMP_EXT_ATTR_3_, E.EMP_EXT_ATTR_4_, E.EMP_EXT_ATTR_5_, E.EMP_EXT_ATTR_6_, E.EMP_EXT_ATTR_7_, E.EMP_EXT_ATTR_8_, E.ORDER_, E.EMP_STATUS_, E.CREATION_DATE_, E.UPDATE_DATE_, E.OPERATOR_ID_, E.OPERATOR_NAME_, O1.ORG_ID_, O1.PARENT_ORG_ID_, O1.ORG_CODE_, O1.ORG_NAME_, O1.ORG_ABBR_NAME_, O1.ORG_TYPE_, O1.ORG_CATEGORY_, O1.ORG_TAG_, O1.ORG_EXT_ATTR_1_, O1.ORG_EXT_ATTR_2_, O1.ORG_EXT_ATTR_3_, O1.ORG_EXT_ATTR_4_, O1.ORG_EXT_ATTR_5_, O1.ORG_EXT_ATTR_6_, O1.ORG_EXT_ATTR_7_, O1.ORG_EXT_ATTR_8_, O1.ORG_STATUS_, O2.ORG_CODE_ as PARENT_ORG_CODE_, O2.ORG_NAME_ as PARENT_ORG_NAME_
  from OM_EMP E
 inner join OM_ORGN_SET ORGN_SET
    on ORGN_SET.ORGN_SET_ID_ = E.ORGN_SET_ID_
  left outer join OM_ORG O1
    on O1.ORGN_SET_ID_ = E.ORGN_SET_ID_
   and O1.ORG_ID_ = E.ORG_ID_
  left outer join OM_ORG O2
    on O2.ORGN_SET_ID_ = O1.ORGN_SET_ID_
   and O2.ORG_ID_ = O1.PARENT_ORG_ID_;

create or replace view OMV_EMP_RELATION as
select ORGN_SET.ORGN_SET_ID_, ORGN_SET.ORGN_SET_CODE_, ORGN_SET.ORGN_SET_NAME_, ER.EMP_RELATION_ID_, ER.EMP_RELATION_, ER.EMP_RELATION_CATEGORY_, ER.MEMO_, ER.EMP_RELATION_TAG_, ER.EMP_RELATION_EXT_ATTR_1_, ER.EMP_RELATION_EXT_ATTR_2_, ER.EMP_RELATION_EXT_ATTR_3_, ER.EMP_RELATION_EXT_ATTR_4_, ER.EMP_RELATION_EXT_ATTR_5_, ER.EMP_RELATION_EXT_ATTR_6_, ER.EMP_RELATION_EXT_ATTR_7_, ER.EMP_RELATION_EXT_ATTR_8_, ER.ORDER_, ER.EMP_RELATION_STATUS_, ER.CREATION_DATE_, ER.UPDATE_DATE_, ER.OPERATOR_ID_, ER.OPERATOR_NAME_, UE.EMP_ID_ as UPPER_EMP_ID_, UE.EMP_CODE_ as UPPER_EMP_CODE_, UE.EMP_NAME_ as UPPER_EMP_NAME_, UE.PASSWORD_RESET_REQ_ as UPPER_PASSWORD_RESET_REQ_, UE.PARTY_ as UPPER_PARTY_, UE.EMP_LEVEL_ as UPPER_EMP_LEVEL_, UE.GENDER_ as UPPER_GENDER_, UE.BIRTH_DATE_ as UPPER_BIRTH_DATE_, UE.TEL_ as UPPER_TEL_, UE.EMAIL_ as UPPER_EMAIL_, UE.IN_DATE_ as UPPER_IN_DATE_, UE.OUT_DATE_ as UPPER_OUT_DATE_, UE.EMP_CATEGORY_ as UPPER_EMP_CATEGORY_, UE.EMP_TAG_ as UPPER_EMP_TAG_, UE.EMP_EXT_ATTR_1_ as UPPER_EMP_EXT_ATTR_1_, UE.EMP_EXT_ATTR_2_ as UPPER_EMP_EXT_ATTR_2_, UE.EMP_EXT_ATTR_3_ as UPPER_EMP_EXT_ATTR_3_, UE.EMP_EXT_ATTR_4_ as UPPER_EMP_EXT_ATTR_4_, UE.EMP_EXT_ATTR_5_ as UPPER_EMP_EXT_ATTR_5_, UE.EMP_EXT_ATTR_6_ as UPPER_EMP_EXT_ATTR_6_, UE.EMP_EXT_ATTR_7_ as UPPER_EMP_EXT_ATTR_7_, UE.EMP_EXT_ATTR_8_ as UPPER_EMP_EXT_ATTR_8_, UE.EMP_STATUS_ as UPPER_EMP_STATUS_, UO1.ORG_ID_ as UPPER_ORG_ID_, UO1.PARENT_ORG_ID_ as UPPER_PARENT_ORG_ID_, UO1.ORG_CODE_ as UPPER_ORG_CODE_, UO1.ORG_NAME_ as UPPER_ORG_NAME_, UO1.ORG_ABBR_NAME_ as UPPER_ORG_ABBR_NAME_, UO1.ORG_TYPE_ as UPPER_ORG_TYPE_, UO1.ORG_CATEGORY_ as UPPER_ORG_CATEGORY_, UO1.ORG_TAG_ as UPPER_ORG_TAG_, UO1.ORG_EXT_ATTR_1_ as UPPER_ORG_EXT_ATTR_1_, UO1.ORG_EXT_ATTR_2_ as UPPER_ORG_EXT_ATTR_2_, UO1.ORG_EXT_ATTR_3_ as UPPER_ORG_EXT_ATTR_3_, UO1.ORG_EXT_ATTR_4_ as UPPER_ORG_EXT_ATTR_4_, UO1.ORG_EXT_ATTR_5_ as UPPER_ORG_EXT_ATTR_5_, UO1.ORG_EXT_ATTR_6_ as UPPER_ORG_EXT_ATTR_6_, UO1.ORG_EXT_ATTR_7_ as UPPER_ORG_EXT_ATTR_7_, UO1.ORG_EXT_ATTR_8_ as UPPER_ORG_EXT_ATTR_8_, UO1.ORG_STATUS_ as UPPER_ORG_STATUS_, UO2.ORG_CODE_ as UPPER_PARENT_ORG_CODE_, UO2.ORG_NAME_ as UPPER_PARENT_ORG_NAME_, LE.EMP_ID_ as LOWER_EMP_ID_, LE.EMP_CODE_ as LOWER_EMP_CODE_, LE.EMP_NAME_ as LOWER_EMP_NAME_, LE.PASSWORD_RESET_REQ_ as LOWER_PASSWORD_RESET_REQ_, LE.PARTY_ as LOWER_PARTY_, LE.EMP_LEVEL_ as LOWER_EMP_LEVEL_, LE.GENDER_ as LOWER_GENDER_, LE.BIRTH_DATE_ as LOWER_BIRTH_DATE_, LE.TEL_ as LOWER_TEL_, LE.EMAIL_ as LOWER_EMAIL_, LE.IN_DATE_ as LOWER_IN_DATE_, LE.OUT_DATE_ as LOWER_OUT_DATE_, LE.EMP_CATEGORY_ as LOWER_EMP_CATEGORY_, LE.EMP_TAG_ as LOWER_EMP_TAG_, LE.EMP_EXT_ATTR_1_ as LOWER_EMP_EXT_ATTR_1_, LE.EMP_EXT_ATTR_2_ as LOWER_EMP_EXT_ATTR_2_, LE.EMP_EXT_ATTR_3_ as LOWER_EMP_EXT_ATTR_3_, LE.EMP_EXT_ATTR_4_ as LOWER_EMP_EXT_ATTR_4_, LE.EMP_EXT_ATTR_5_ as LOWER_EMP_EXT_ATTR_5_, LE.EMP_EXT_ATTR_6_ as LOWER_EMP_EXT_ATTR_6_, LE.EMP_EXT_ATTR_7_ as LOWER_EMP_EXT_ATTR_7_, LE.EMP_EXT_ATTR_8_ as LOWER_EMP_EXT_ATTR_8_, LE.EMP_STATUS_ as LOWER_EMP_STATUS_, LO1.ORG_ID_ as LOWER_ORG_ID_, LO1.PARENT_ORG_ID_ as LOWER_PARENT_ORG_ID_, LO1.ORG_CODE_ as LOWER_ORG_CODE_, LO1.ORG_NAME_ as LOWER_ORG_NAME_, LO1.ORG_ABBR_NAME_ as LOWER_ORG_ABBR_NAME_, LO1.ORG_TYPE_ as LOWER_ORG_TYPE_, LO1.ORG_CATEGORY_ as LOWER_ORG_CATEGORY_, LO1.ORG_TAG_ as LOWER_ORG_TAG_, LO1.ORG_EXT_ATTR_1_ as LOWER_ORG_EXT_ATTR_1_, LO1.ORG_EXT_ATTR_2_ as LOWER_ORG_EXT_ATTR_2_, LO1.ORG_EXT_ATTR_3_ as LOWER_ORG_EXT_ATTR_3_, LO1.ORG_EXT_ATTR_4_ as LOWER_ORG_EXT_ATTR_4_, LO1.ORG_EXT_ATTR_5_ as LOWER_ORG_EXT_ATTR_5_, LO1.ORG_EXT_ATTR_6_ as LOWER_ORG_EXT_ATTR_6_, LO1.ORG_EXT_ATTR_7_ as LOWER_ORG_EXT_ATTR_7_, LO1.ORG_EXT_ATTR_8_ as LOWER_ORG_EXT_ATTR_8_, LO1.ORG_STATUS_ as LOWER_ORG_STATUS_, LO2.ORG_CODE_ as LOWER_PARENT_ORG_CODE_, LO2.ORG_NAME_ as LOWER_PARENT_ORG_NAME_
  from OM_EMP_RELATION ER
 inner join OM_ORGN_SET ORGN_SET
    on ORGN_SET.ORGN_SET_ID_ = ER.ORGN_SET_ID_
 inner join OM_EMP UE
    on UE.ORGN_SET_ID_ = ER.ORGN_SET_ID_
   and UE.EMP_ID_ = ER.UPPER_EMP_ID_
 inner join OM_ORG UO1
    on UO1.ORGN_SET_ID_ = UE.ORGN_SET_ID_
   and UO1.ORG_ID_ = UE.ORG_ID_
  left outer join OM_ORG UO2
    on UO2.ORGN_SET_ID_ = UO1.ORGN_SET_ID_
   and UO2.ORG_ID_ = UO1.PARENT_ORG_ID_
 inner join OM_EMP LE
    on LE.ORGN_SET_ID_ = ER.ORGN_SET_ID_
   and LE.EMP_ID_ = ER.LOWER_EMP_ID_
 inner join OM_ORG LO1
    on LO1.ORGN_SET_ID_ = LE.ORGN_SET_ID_
   and LO1.ORG_ID_ = LE.ORG_ID_
  left outer join OM_ORG LO2
    on LO2.ORGN_SET_ID_ = LO1.ORGN_SET_ID_
   and LO2.ORG_ID_ = LO1.PARENT_ORG_ID_;

create or replace view OMV_LOG as
select LOG_ID_, CATEGORY_, IP_, USER_AGENT_, URL_, ACTION_, PARAMETER_MAP_, BUSINESS_KEY_, ERROR_, MESSAGE_, ORG_ID_, ORG_NAME_, POSI_ID_, POSI_NAME_, EMP_ID_, EMP_NAME_, CREATION_DATE_ from OM_LOG;

create or replace view OMV_MAIN_SERVER as
select MS.MAIN_SERVER_ID_, MS.MAIN_SERVER_NAME_, MS.DRIVER_CLASS_NAME_, MS.URL_, MS.USERNAME_, MS.PASSWORD_, MS.MEMO_, MS.LAST_SYNC_DATE_, MS.ORDER_, MS.MAIN_SERVER_STATUS_, MS.CREATION_DATE_, MS.UPDATE_DATE_, MS.OPERATOR_ID_, MS.OPERATOR_NAME_ from OM_MAIN_SERVER MS;

create or replace view OMV_MIRROR_SERVER as
select MS.MIRROR_SERVER_ID_, MS.MIRROR_SERVER_NAME_, MS.DRIVER_CLASS_NAME_, MS.URL_, MS.USERNAME_, MS.PASSWORD_, MS.MEMO_, MS.LAST_SYNC_DATE_, MS.ORDER_, MS.MIRROR_SERVER_STATUS_, MS.CREATION_DATE_, MS.UPDATE_DATE_, MS.OPERATOR_ID_, MS.OPERATOR_NAME_ from OM_MIRROR_SERVER MS;

create or replace view OMV_ORG as
select ORGN_SET.ORGN_SET_ID_, ORGN_SET.ORGN_SET_CODE_, ORGN_SET.ORGN_SET_NAME_, O1.ORG_ID_, O1.PARENT_ORG_ID_, O1.ORG_CODE_, O1.ORG_NAME_, O1.ORG_ABBR_NAME_, O1.ORG_TYPE_, O1.ORG_CATEGORY_, O1.MEMO_, O1.ORG_TAG_, O1.ORG_EXT_ATTR_1_, O1.ORG_EXT_ATTR_2_, O1.ORG_EXT_ATTR_3_, O1.ORG_EXT_ATTR_4_, O1.ORG_EXT_ATTR_5_, O1.ORG_EXT_ATTR_6_, O1.ORG_EXT_ATTR_7_, O1.ORG_EXT_ATTR_8_, O1.ORDER_, O1.ORG_STATUS_, O1.CREATION_DATE_, O1.UPDATE_DATE_, O1.OPERATOR_ID_, O1.OPERATOR_NAME_, O2.ORG_CODE_ as PARENT_ORG_CODE_, O2.ORG_NAME_ as PARENT_ORG_NAME_
  from OM_ORG O1
 inner join OM_ORGN_SET ORGN_SET
    on ORGN_SET.ORGN_SET_ID_ = O1.ORGN_SET_ID_
  left outer join OM_ORG O2
    on O2.ORGN_SET_ID_ = O1.ORGN_SET_ID_
   and O2.ORG_ID_ = O1.PARENT_ORG_ID_;

create or replace view OMV_ORGN_SET as
select OS1.ORGN_SET_ID_, OS1.PARENT_ORGN_SET_ID_, OS1.ORGN_SET_CODE_, OS1.ORGN_SET_NAME_, OS1.ALLOW_SYNC_, OS1.MEMO_, OS1.ORDER_, OS1.ORGN_SET_STATUS_, OS1.CREATION_DATE_, OS1.UPDATE_DATE_, OS1.OPERATOR_ID_, OS1.OPERATOR_NAME_, OS2.ORGN_SET_CODE_ as PARENT_ORGN_SET_CODE_, OS2.ORGN_SET_NAME_ as PARENT_ORGN_SET_NAME_ from OM_ORGN_SET OS1 left outer join OM_ORGN_SET OS2 on OS2.ORGN_SET_ID_ = OS1.PARENT_ORGN_SET_ID_;

create or replace view OMV_POSI as
select ORGN_SET.ORGN_SET_ID_, ORGN_SET.ORGN_SET_CODE_, ORGN_SET.ORGN_SET_NAME_, P.POSI_ID_, P.POSI_CODE_, P.POSI_NAME_, P.ORG_LEADER_TYPE_, P.POSI_CATEGORY_, P.MEMO_, P.POSI_TAG_, P.POSI_EXT_ATTR_1_, P.POSI_EXT_ATTR_2_, P.POSI_EXT_ATTR_3_, P.POSI_EXT_ATTR_4_, P.POSI_EXT_ATTR_5_, P.POSI_EXT_ATTR_6_, P.POSI_EXT_ATTR_7_, P.POSI_EXT_ATTR_8_, P.ORDER_, P.POSI_STATUS_, P.CREATION_DATE_, P.UPDATE_DATE_, P.OPERATOR_ID_, P.OPERATOR_NAME_, D.DUTY_ID_, D.DUTY_CODE_, D.DUTY_NAME_, D.DUTY_CATEGORY_, D.DUTY_TAG_, D.DUTY_EXT_ATTR_1_, D.DUTY_EXT_ATTR_2_, D.DUTY_EXT_ATTR_3_, D.DUTY_EXT_ATTR_4_, D.DUTY_EXT_ATTR_5_, D.DUTY_EXT_ATTR_6_, D.DUTY_EXT_ATTR_7_, D.DUTY_EXT_ATTR_8_, D.DUTY_STATUS_, O1.ORG_ID_, O1.PARENT_ORG_ID_, O1.ORG_CODE_, O1.ORG_NAME_, O1.ORG_ABBR_NAME_, O1.ORG_TYPE_, O1.ORG_CATEGORY_, O1.ORG_TAG_, O1.ORG_EXT_ATTR_1_, O1.ORG_EXT_ATTR_2_, O1.ORG_EXT_ATTR_3_, O1.ORG_EXT_ATTR_4_, O1.ORG_EXT_ATTR_5_, O1.ORG_EXT_ATTR_6_, O1.ORG_EXT_ATTR_7_, O1.ORG_EXT_ATTR_8_, O1.ORG_STATUS_, O2.ORG_CODE_ as PARENT_ORG_CODE_, O2.ORG_NAME_ as PARENT_ORG_NAME_
  from OM_POSI P
 inner join OM_ORGN_SET ORGN_SET
    on ORGN_SET.ORGN_SET_ID_ = P.ORGN_SET_ID_
  left outer join OM_DUTY D
    on D.ORGN_SET_ID_ = P.ORGN_SET_ID_
   and D.DUTY_ID_ = P.DUTY_ID_
 inner join OM_ORG O1
    on O1.ORGN_SET_ID_ = P.ORGN_SET_ID_
   and O1.ORG_ID_ = P.ORG_ID_
  left outer join OM_ORG O2
    on O2.ORGN_SET_ID_ = O1.ORGN_SET_ID_
   and O2.ORG_ID_ = O1.PARENT_ORG_ID_;

create or replace view OMV_POSI_EMP as
select ORGN_SET.ORGN_SET_ID_, ORGN_SET.ORGN_SET_CODE_, ORGN_SET.ORGN_SET_NAME_, PE.POSI_EMP_ID_, PE.MAIN_, PE.POSI_EMP_CATEGORY_, PE.MEMO_, PE.POSI_EMP_TAG_, PE.POSI_EMP_EXT_ATTR_1_, PE.POSI_EMP_EXT_ATTR_2_, PE.POSI_EMP_EXT_ATTR_3_, PE.POSI_EMP_EXT_ATTR_4_, PE.POSI_EMP_EXT_ATTR_5_, PE.POSI_EMP_EXT_ATTR_6_, PE.POSI_EMP_EXT_ATTR_7_, PE.POSI_EMP_EXT_ATTR_8_, PE.ORDER_, PE.POSI_EMP_STATUS_, PE.CREATION_DATE_, PE.UPDATE_DATE_, PE.OPERATOR_ID_, PE.OPERATOR_NAME_, E.EMP_ID_, E.EMP_CODE_, E.EMP_NAME_, E.PASSWORD_RESET_REQ_, E.PARTY_, E.EMP_LEVEL_, E.GENDER_, E.BIRTH_DATE_, E.TEL_, E.EMAIL_, E.IN_DATE_, E.OUT_DATE_, E.EMP_CATEGORY_, E.EMP_TAG_, E.EMP_EXT_ATTR_1_, E.EMP_EXT_ATTR_2_, E.EMP_EXT_ATTR_3_, E.EMP_EXT_ATTR_4_, E.EMP_EXT_ATTR_5_, E.EMP_EXT_ATTR_6_, E.EMP_EXT_ATTR_7_, E.EMP_EXT_ATTR_8_, E.EMP_STATUS_, P.POSI_ID_, P.POSI_CODE_, P.POSI_NAME_, P.ORG_LEADER_TYPE_, P.POSI_CATEGORY_, P.POSI_TAG_, P.POSI_EXT_ATTR_1_, P.POSI_EXT_ATTR_2_, P.POSI_EXT_ATTR_3_, P.POSI_EXT_ATTR_4_, P.POSI_EXT_ATTR_5_, P.POSI_EXT_ATTR_6_, P.POSI_EXT_ATTR_7_, P.POSI_EXT_ATTR_8_, P.POSI_STATUS_, D.DUTY_ID_, D.DUTY_CODE_, D.DUTY_NAME_, D.DUTY_CATEGORY_, D.DUTY_TAG_, D.DUTY_EXT_ATTR_1_, D.DUTY_EXT_ATTR_2_, D.DUTY_EXT_ATTR_3_, D.DUTY_EXT_ATTR_4_, D.DUTY_EXT_ATTR_5_, D.DUTY_EXT_ATTR_6_, D.DUTY_EXT_ATTR_7_, D.DUTY_EXT_ATTR_8_, D.DUTY_STATUS_, O1.ORG_ID_, O1.PARENT_ORG_ID_, O1.ORG_CODE_, O1.ORG_NAME_, O1.ORG_ABBR_NAME_, O1.ORG_TYPE_, O1.ORG_CATEGORY_, O1.ORG_TAG_, O1.ORG_EXT_ATTR_1_, O1.ORG_EXT_ATTR_2_, O1.ORG_EXT_ATTR_3_, O1.ORG_EXT_ATTR_4_, O1.ORG_EXT_ATTR_5_, O1.ORG_EXT_ATTR_6_, O1.ORG_EXT_ATTR_7_, O1.ORG_EXT_ATTR_8_, O1.ORG_STATUS_, O2.ORG_CODE_ as PARENT_ORG_CODE_, O2.ORG_NAME_ as PARENT_ORG_NAME_
  from OM_POSI_EMP PE
 inner join OM_ORGN_SET ORGN_SET
    on ORGN_SET.ORGN_SET_ID_ = PE.ORGN_SET_ID_
 inner join OM_EMP E
    on E.ORGN_SET_ID_ = PE.ORGN_SET_ID_
   and E.EMP_ID_ = PE.EMP_ID_
 inner join OM_POSI P
    on P.ORGN_SET_ID_ = PE.ORGN_SET_ID_
   and P.POSI_ID_ = PE.POSI_ID_
  left outer join OM_DUTY D
    on D.ORGN_SET_ID_ = P.ORGN_SET_ID_
   and D.DUTY_ID_ = P.DUTY_ID_
 inner join OM_ORG O1
    on O1.ORGN_SET_ID_ = P.ORGN_SET_ID_
   and O1.ORG_ID_ = P.ORG_ID_
  left outer join OM_ORG O2
    on O2.ORGN_SET_ID_ = O1.ORGN_SET_ID_
   and O2.ORG_ID_ = O1.PARENT_ORG_ID_;

create or replace view OMV_TAG as
select T.ORGN_SET_ID_, T.TAG_ID_, T.OBJ_ID_, T.OBJ_TYPE_, T.TAG_, ORGN_SET.ORGN_SET_CODE_, ORGN_SET.ORGN_SET_NAME_ from OM_TAG T inner join OM_ORGN_SET ORGN_SET on ORGN_SET.ORGN_SET_ID_ = T.ORGN_SET_ID_;

insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('86c1b27aa7454d92aae95f45c2b5d674', null, 'BOOLEAN', '0', '否', null, null, null, null, null, null, 2);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('06c0c73bbfb14509809f362336d29c90', null, 'BOOLEAN', '1', '是', null, null, null, null, null, null, 1);

insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('0863534f48734ec3aa43fb11ab9e469f', null, 'CATEGORY', '2', '外部', null, null, null, null, null, null, 2);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('5117b02153454202a9243e2e8543a7fa', null, 'CATEGORY', '0', '正常', null, null, null, null, null, null, 0);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('1512f698c21a4e8299f49adb1ea1c831', null, 'CATEGORY', '1', '系统', null, null, null, null, null, null, 1);

insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('08713f1bf0144a15bcd8a05e235d404d', null, 'EMP_LEVEL', '150', '科级', null, null, null, null, null, null, 150);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('ecac371e0f144ca0a8ebc8c156ffd0b4', null, 'EMP_LEVEL', '130', '处级', null, null, null, null, null, null, 130);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('6b03bb7d991948d5b5eb76a2ce3fd694', null, 'EMP_LEVEL', '120', '副部级', null, null, null, null, null, null, 120);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('6231742f12024d0b9809004b0d294614', null, 'EMP_LEVEL', '140', '副处级', null, null, null, null, null, null, 140);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('f1448051a8b24a80be4ca10d7d36c40a', null, 'EMP_LEVEL', '110', '部级', null, null, null, null, null, null, 110);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('4f59c166a29d449598c020a32d36882c', null, 'EMP_LEVEL', '200', '职工', null, null, null, null, null, null, 200);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('75d7e40a563e486e9fe54bb5891267d1', null, 'EMP_LEVEL', '160', '副科级', null, null, null, null, null, null, 160);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('7783becd619d486b93fc8f0a9b03bdd5', null, 'EMP_LEVEL', '170', '一般干部', null, null, null, null, null, null, 170);

insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('6785a8f89a7649afb609468fc887da71', null, 'EMP_RELATION', '1.1', '领导-业务领导', null, null, null, null, null, null, 11);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('6e9915a60c994145a596db9baf53e178', null, 'EMP_RELATION', '1.2', '领导-人力资源领导', null, null, null, null, null, null, 12);

insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('06642c3551454a1a8744e08f56f83ea9', null, 'GENDER', '1', '男', null, null, null, null, null, null, 1);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('bcd737c3ed274758ba3cf252d6b23b84', null, 'GENDER', '0', '女', null, null, null, null, null, null, 2);

insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('0ae4aace47c2424f85eeb2fbda9d7915', null, 'OPERATION', 'INSERT', '新增', null, null, null, null, null, null, 1);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('c92155483f7e42fab9f8f0dd088a811b', null, 'OPERATION', 'UPDATE', '修改', null, null, null, null, null, null, 2);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('4f6513737d82417183b3922a5f3b4525', null, 'OPERATION', 'DELETE', '删除', null, null, null, null, null, null, 3);

insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('d879e829e4ca4168b8945e229be25a5e', null, 'ORG_LEADER_TYPE', '1', '正职领导', null, null, null, null, null, null, 1);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('9b91591adfa34685b814bf2af361af6c', null, 'ORG_LEADER_TYPE', '3', '高管', null, null, null, null, null, null, 3);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('f0fd53361f684c80ab359abca2f92641', null, 'ORG_LEADER_TYPE', '9', '职员', null, null, null, null, null, null, 9);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('bb3ae43db64f42ffa93d47f999ef50f6', null, 'ORG_LEADER_TYPE', '2', '副职领导', null, null, null, null, null, null, 2);

insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('a28b192c845546e3a3197f711b376a2f', null, 'ORG_TYPE', '9', '一般机构', null, null, null, null, null, null, 9);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('123451b2f5334014825c26325d191df5', null, 'ORG_TYPE', '98', '虚拟机构', null, null, null, null, null, null, 98);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('30f80cc593bf4822bd2b9f118324b222', null, 'ORG_TYPE', '5', '工厂', null, null, null, null, null, null, 5);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('9bf936814482430ca02dd842c14d8dfa', null, 'ORG_TYPE', '1', '总公司', null, null, null, null, null, null, 1);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('048651b2f5334014825c26325d191df7', null, 'ORG_TYPE', '99', '相关其它单位', null, null, null, null, null, null, 99);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('86f4d7e51eec498b8903e7e19d5828f1', null, 'ORG_TYPE', '2', '公司直属机构', null, null, null, null, null, null, 2);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('720b7b2b11cf42aa842f845fedf47f7a', null, 'ORG_TYPE', '4', '分公司', null, null, null, null, null, null, 4);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('02f11dbe1f664c08a72c2265b068d49a', null, 'ORG_TYPE', '3', '独立处室', null, null, null, null, null, null, 3);

insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('51fb2b2afde24460b0ebf100829ab4d1', null, 'STATUS', '0', '失效', null, null, null, null, null, null, 2);
insert into OM_CODE (CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_)
values ('bffd5233b0a14f0aa0068c191e53a37c', null, 'STATUS', '1', '生效', null, null, null, null, null, null, 1);

commit;

insert into OM_ORGN_SET (orgn_set_id_, parent_orgn_set_id_, orgn_set_code_, orgn_set_name_, allow_sync_, memo_, order_, orgn_set_status_, creation_date_, update_date_, operator_id_, operator_name_)
values ('75a4c87e7cdc4999b6f090344335a5fc', null, 'DEMO', 'DEMO', '1', null, 2, '1', null, null, null, null);
commit;

insert into OM_DUTY (orgn_set_id_, duty_id_, duty_code_, duty_name_, duty_category_, memo_, duty_tag_, duty_ext_attr_1_, duty_ext_attr_2_, duty_ext_attr_3_, duty_ext_attr_4_, duty_ext_attr_5_, duty_ext_attr_6_, duty_ext_attr_7_, duty_ext_attr_8_, order_, duty_status_, creation_date_, update_date_, operator_id_, operator_name_)
values ('75a4c87e7cdc4999b6f090344335a5fc', '87ba89fae2154cf38aa7a0ece2cff4ee', 'SYSADMIN', '系统管理员', '1', null, null, null, null, null, null, null, null, null, null, 0, '1', STR_TO_DATE('07-04-2022 11:49:07.226000', '%d-%m-%Y %H:%i:%s.%f'), STR_TO_DATE('07-04-2022 11:49:15.158000', '%d-%m-%Y %H:%i:%s.%f'), 'bc5ff1fdfea645d8b277f60091340084', '系统管理员');
insert into OM_DUTY (orgn_set_id_, duty_id_, duty_code_, duty_name_, duty_category_, memo_, duty_tag_, duty_ext_attr_1_, duty_ext_attr_2_, duty_ext_attr_3_, duty_ext_attr_4_, duty_ext_attr_5_, duty_ext_attr_6_, duty_ext_attr_7_, duty_ext_attr_8_, order_, duty_status_, creation_date_, update_date_, operator_id_, operator_name_)
values ('75a4c87e7cdc4999b6f090344335a5fc', 'c0da7bb7a5c24ed5887d79de4d20b937', 'SYS', '系统', '1', null, null, null, null, null, null, null, null, null, null, 1, '1', STR_TO_DATE('07-04-2022 11:51:20.791000', '%d-%m-%Y %H:%i:%s.%f'), STR_TO_DATE('07-04-2022 11:51:20.791000', '%d-%m-%Y %H:%i:%s.%f'), 'bc5ff1fdfea645d8b277f60091340084', '系统管理员');
commit;

insert into OM_ORG (orgn_set_id_, org_id_, parent_org_id_, org_code_, org_name_, org_abbr_name_, org_type_, org_category_, memo_, org_tag_, org_ext_attr_1_, org_ext_attr_2_, org_ext_attr_3_, org_ext_attr_4_, org_ext_attr_5_, org_ext_attr_6_, org_ext_attr_7_, org_ext_attr_8_, order_, org_status_, creation_date_, update_date_, operator_id_, operator_name_)
values ('75a4c87e7cdc4999b6f090344335a5fc', '35c600cf16384562bf756183cefcc10b', null, 'SYSTEM', '系统', null, '99', '1', null, null, null, null, null, null, null, null, null, null, 0, '1', STR_TO_DATE('07-04-2022 11:53:59.142000', '%d-%m-%Y %H:%i:%s.%f'), STR_TO_DATE('07-04-2022 11:53:59.142000', '%d-%m-%Y %H:%i:%s.%f'), 'bc5ff1fdfea645d8b277f60091340084', '系统管理员');
commit;

insert into OM_EMP (orgn_set_id_, emp_id_, org_id_, emp_code_, emp_name_, password_, password_reset_req_, party_, emp_level_, gender_, birth_date_, tel_, email_, in_date_, out_date_, emp_category_, memo_, emp_tag_, emp_ext_attr_1_, emp_ext_attr_2_, emp_ext_attr_3_, emp_ext_attr_4_, emp_ext_attr_5_, emp_ext_attr_6_, emp_ext_attr_7_, emp_ext_attr_8_, order_, emp_status_, creation_date_, update_date_, operator_id_, operator_name_)
values ('75a4c87e7cdc4999b6f090344335a5fc', 'e984ef803d2a4767a68c57fd968233dc', '35c600cf16384562bf756183cefcc10b', 'DEMO', 'DEMO', 'cfcd208495d565ef66e7dff9f98764da', '0', null, null, null, null, null, null, null, null, '1', null, null, null, null, null, null, null, null, null, null, 1, '1', STR_TO_DATE('07-04-2022 11:59:46.267000', '%d-%m-%Y %H:%i:%s.%f'), STR_TO_DATE('07-04-2022 11:59:46.267000', '%d-%m-%Y %H:%i:%s.%f'), 'bc5ff1fdfea645d8b277f60091340084', '系统管理员');
insert into OM_EMP (orgn_set_id_, emp_id_, org_id_, emp_code_, emp_name_, password_, password_reset_req_, party_, emp_level_, gender_, birth_date_, tel_, email_, in_date_, out_date_, emp_category_, memo_, emp_tag_, emp_ext_attr_1_, emp_ext_attr_2_, emp_ext_attr_3_, emp_ext_attr_4_, emp_ext_attr_5_, emp_ext_attr_6_, emp_ext_attr_7_, emp_ext_attr_8_, order_, emp_status_, creation_date_, update_date_, operator_id_, operator_name_)
values ('75a4c87e7cdc4999b6f090344335a5fc', 'ffd6576349e4426b8d79df9f180fdf99', '35c600cf16384562bf756183cefcc10b', 'SYSADMIN', '系统管理员', 'cfcd208495d565ef66e7dff9f98764da', '0', null, null, '1', null, null, null, null, null, '1', null, null, null, null, null, null, null, null, null, null, 0, '1', STR_TO_DATE('09-03-2022 19:34:48.046000', '%d-%m-%Y %H:%i:%s.%f'), STR_TO_DATE('10-06-2022 14:05:07.774000', '%d-%m-%Y %H:%i:%s.%f'), 'bc5ff1fdfea645d8b277f60091340084', '系统管理员');
commit;

insert into OM_POSI (orgn_set_id_, posi_id_, org_id_, duty_id_, posi_code_, posi_name_, org_leader_type_, posi_category_, memo_, posi_tag_, posi_ext_attr_1_, posi_ext_attr_2_, posi_ext_attr_3_, posi_ext_attr_4_, posi_ext_attr_5_, posi_ext_attr_6_, posi_ext_attr_7_, posi_ext_attr_8_, order_, posi_status_, creation_date_, update_date_, operator_id_, operator_name_)
values ('75a4c87e7cdc4999b6f090344335a5fc', '15c414e0d248443ea64073d2edca0dae', '35c600cf16384562bf756183cefcc10b', null, 'SYS', '系统', null, '1', null, null, null, null, null, null, null, null, null, null, 1, '1', STR_TO_DATE('07-04-2022 11:59:20.840000', '%d-%m-%Y %H:%i:%s.%f'), STR_TO_DATE('07-04-2022 11:59:20.840000', '%d-%m-%Y %H:%i:%s.%f'), 'bc5ff1fdfea645d8b277f60091340084', '系统管理员');
insert into OM_POSI (orgn_set_id_, posi_id_, org_id_, duty_id_, posi_code_, posi_name_, org_leader_type_, posi_category_, memo_, posi_tag_, posi_ext_attr_1_, posi_ext_attr_2_, posi_ext_attr_3_, posi_ext_attr_4_, posi_ext_attr_5_, posi_ext_attr_6_, posi_ext_attr_7_, posi_ext_attr_8_, order_, posi_status_, creation_date_, update_date_, operator_id_, operator_name_)
values ('75a4c87e7cdc4999b6f090344335a5fc', 'f1cb62f8d77449959d35779361f0ce1d', '35c600cf16384562bf756183cefcc10b', '87ba89fae2154cf38aa7a0ece2cff4ee', 'SYSADMIN', '系统管理员', null, '1', null, null, null, null, null, null, null, null, null, null, 0, '1', STR_TO_DATE('07-04-2022 11:56:13.534000', '%d-%m-%Y %H:%i:%s.%f'), STR_TO_DATE('07-04-2022 11:56:13.534000', '%d-%m-%Y %H:%i:%s.%f'), 'bc5ff1fdfea645d8b277f60091340084', '系统管理员');
commit;

insert into OM_POSI_EMP (orgn_set_id_, posi_emp_id_, posi_id_, emp_id_, main_, posi_emp_category_, memo_, posi_emp_tag_, posi_emp_ext_attr_1_, posi_emp_ext_attr_2_, posi_emp_ext_attr_3_, posi_emp_ext_attr_4_, posi_emp_ext_attr_5_, posi_emp_ext_attr_6_, posi_emp_ext_attr_7_, posi_emp_ext_attr_8_, order_, posi_emp_status_, creation_date_, update_date_, operator_id_, operator_name_)
values ('75a4c87e7cdc4999b6f090344335a5fc', 'fce3a7fa3a4140b6b3a2a1a38b077a7a', 'f1cb62f8d77449959d35779361f0ce1d', 'ffd6576349e4426b8d79df9f180fdf99', '1', null, null, null, null, null, null, null, null, null, null, null, null, '1', STR_TO_DATE('07-04-2022 11:57:25.641000', '%d-%m-%Y %H:%i:%s.%f'), STR_TO_DATE('07-04-2022 11:57:25.641000', '%d-%m-%Y %H:%i:%s.%f'), 'bc5ff1fdfea645d8b277f60091340084', '系统管理员');
insert into OM_POSI_EMP (orgn_set_id_, posi_emp_id_, posi_id_, emp_id_, main_, posi_emp_category_, memo_, posi_emp_tag_, posi_emp_ext_attr_1_, posi_emp_ext_attr_2_, posi_emp_ext_attr_3_, posi_emp_ext_attr_4_, posi_emp_ext_attr_5_, posi_emp_ext_attr_6_, posi_emp_ext_attr_7_, posi_emp_ext_attr_8_, order_, posi_emp_status_, creation_date_, update_date_, operator_id_, operator_name_)
values ('75a4c87e7cdc4999b6f090344335a5fc', '94e44e4f2f5146eca13a47673d3466b0', '15c414e0d248443ea64073d2edca0dae', 'e984ef803d2a4767a68c57fd968233dc', '0', null, null, null, null, null, null, null, null, null, null, null, null, '1', STR_TO_DATE('25-07-2023 23:01:53.220000', '%d-%m-%Y %H:%i:%s.%f'), STR_TO_DATE('25-07-2023 23:01:53.220000', '%d-%m-%Y %H:%i:%s.%f'), 'ffd6576349e4426b8d79df9f180fdf99', '系统管理员');
commit;

SET FOREIGN_KEY_CHECKS = 1;