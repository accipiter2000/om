prompt PL/SQL Developer Export User Objects for user OM@OM
prompt Created by Administrator on 2023年8月10日
set define off
spool 1.log

prompt
prompt Creating table OM_CODE
prompt ======================
prompt
create table OM_CODE
(
  code_id_        VARCHAR2(40) not null,
  parent_code_id_ VARCHAR2(40),
  category_       VARCHAR2(20) not null,
  code_           VARCHAR2(60) not null,
  name_           VARCHAR2(60),
  ext_attr_1_     VARCHAR2(60),
  ext_attr_2_     VARCHAR2(60),
  ext_attr_3_     VARCHAR2(60),
  ext_attr_4_     VARCHAR2(60),
  ext_attr_5_     VARCHAR2(60),
  ext_attr_6_     VARCHAR2(60),
  order_          INTEGER
)
;
comment on table OM_CODE
  is '代码';
comment on column OM_CODE.code_id_
  is '代码ID';
comment on column OM_CODE.parent_code_id_
  is '上级代码ID';
comment on column OM_CODE.category_
  is '分类';
comment on column OM_CODE.code_
  is '代码';
comment on column OM_CODE.name_
  is '名称';
comment on column OM_CODE.ext_attr_1_
  is '扩展属性1';
comment on column OM_CODE.ext_attr_2_
  is '扩展属性2';
comment on column OM_CODE.ext_attr_3_
  is '扩展属性3';
comment on column OM_CODE.ext_attr_4_
  is '扩展属性4';
comment on column OM_CODE.ext_attr_5_
  is '扩展属性5';
comment on column OM_CODE.ext_attr_6_
  is '扩展属性6';
comment on column OM_CODE.order_
  is '排序';
alter table OM_CODE
  add constraint PK_OM_CODE primary key (CODE_ID_);
alter table OM_CODE
  add constraint UQ_OM_CODE unique (CATEGORY_, CODE_);
alter table OM_CODE
  add constraint FK_OM_CODE foreign key (PARENT_CODE_ID_)
  references OM_CODE (CODE_ID_);

prompt
prompt Creating table OM_ORGN_SET
prompt ==========================
prompt
create table OM_ORGN_SET
(
  orgn_set_id_        VARCHAR2(40) not null,
  parent_orgn_set_id_ VARCHAR2(40),
  orgn_set_code_      VARCHAR2(60) not null,
  orgn_set_name_      VARCHAR2(60) not null,
  allow_sync_         VARCHAR2(20) not null,
  memo_               VARCHAR2(300),
  order_              INTEGER,
  orgn_set_status_    VARCHAR2(20) not null,
  creation_date_      TIMESTAMP(6),
  update_date_        TIMESTAMP(6),
  operator_id_        VARCHAR2(40),
  operator_name_      VARCHAR2(60)
)
;
comment on table OM_ORGN_SET
  is '组织架构套';
comment on column OM_ORGN_SET.orgn_set_id_
  is '组织架构套ID';
comment on column OM_ORGN_SET.parent_orgn_set_id_
  is '上级组织架构套ID';
comment on column OM_ORGN_SET.orgn_set_code_
  is '组织架构套编码';
comment on column OM_ORGN_SET.orgn_set_name_
  is '组织架构套名称';
comment on column OM_ORGN_SET.allow_sync_
  is '允许同步';
comment on column OM_ORGN_SET.memo_
  is '备注';
comment on column OM_ORGN_SET.order_
  is '排序';
comment on column OM_ORGN_SET.orgn_set_status_
  is '组织架构套状态';
comment on column OM_ORGN_SET.creation_date_
  is '创建日期';
comment on column OM_ORGN_SET.update_date_
  is '修改日期';
comment on column OM_ORGN_SET.operator_id_
  is '操作人员ID';
comment on column OM_ORGN_SET.operator_name_
  is '操作人员名称';
alter table OM_ORGN_SET
  add constraint PK_OM_ORGN_SET primary key (ORGN_SET_ID_);
alter table OM_ORGN_SET
  add constraint UQ_OM_ORGN_SET_CODE unique (ORGN_SET_CODE_);
alter table OM_ORGN_SET
  add constraint FK_OM_ORGN_SET_PARENT foreign key (PARENT_ORGN_SET_ID_)
  references OM_ORGN_SET (ORGN_SET_ID_);

prompt
prompt Creating table OM_DUTY
prompt ======================
prompt
create table OM_DUTY
(
  orgn_set_id_     VARCHAR2(40) not null,
  duty_id_         VARCHAR2(40) not null,
  duty_code_       VARCHAR2(60) not null,
  duty_name_       VARCHAR2(60) not null,
  duty_category_   VARCHAR2(20) not null,
  memo_            VARCHAR2(300),
  duty_tag_        VARCHAR2(120),
  duty_ext_attr_1_ VARCHAR2(120),
  duty_ext_attr_2_ VARCHAR2(120),
  duty_ext_attr_3_ VARCHAR2(120),
  duty_ext_attr_4_ VARCHAR2(120),
  duty_ext_attr_5_ VARCHAR2(120),
  duty_ext_attr_6_ VARCHAR2(120),
  duty_ext_attr_7_ VARCHAR2(120),
  duty_ext_attr_8_ VARCHAR2(120),
  order_           INTEGER,
  duty_status_     VARCHAR2(20) not null,
  creation_date_   TIMESTAMP(6),
  update_date_     TIMESTAMP(6),
  operator_id_     VARCHAR2(40),
  operator_name_   VARCHAR2(60)
)
;
comment on table OM_DUTY
  is '职务';
comment on column OM_DUTY.orgn_set_id_
  is '组织架构套ID';
comment on column OM_DUTY.duty_id_
  is '职务ID';
comment on column OM_DUTY.duty_code_
  is '职务编码';
comment on column OM_DUTY.duty_name_
  is '职务名称';
comment on column OM_DUTY.duty_category_
  is '分类';
comment on column OM_DUTY.memo_
  is '备注';
comment on column OM_DUTY.duty_tag_
  is '职务标签';
comment on column OM_DUTY.duty_ext_attr_1_
  is '职务扩展属性1';
comment on column OM_DUTY.duty_ext_attr_2_
  is '职务扩展属性2';
comment on column OM_DUTY.duty_ext_attr_3_
  is '职务扩展属性3';
comment on column OM_DUTY.duty_ext_attr_4_
  is '职务扩展属性4';
comment on column OM_DUTY.duty_ext_attr_5_
  is '职务扩展属性5';
comment on column OM_DUTY.duty_ext_attr_6_
  is '职务扩展属性6';
comment on column OM_DUTY.duty_ext_attr_7_
  is '职务扩展属性7';
comment on column OM_DUTY.duty_ext_attr_8_
  is '职务扩展属性8';
comment on column OM_DUTY.order_
  is '排序';
comment on column OM_DUTY.duty_status_
  is '职务状态';
comment on column OM_DUTY.creation_date_
  is '创建日期';
comment on column OM_DUTY.update_date_
  is '修改日期';
comment on column OM_DUTY.operator_id_
  is '操作人员ID';
comment on column OM_DUTY.operator_name_
  is '操作人员名称';
alter table OM_DUTY
  add constraint OK_OM_DUTY primary key (ORGN_SET_ID_, DUTY_ID_);
alter table OM_DUTY
  add constraint UQ_OM_DUTY_CODE unique (ORGN_SET_ID_, DUTY_CODE_);
alter table OM_DUTY
  add constraint FK_OM_DUTY_ORGN_SET foreign key (ORGN_SET_ID_)
  references OM_ORGN_SET (ORGN_SET_ID_);

prompt
prompt Creating table OM_ORG
prompt =====================
prompt
create table OM_ORG
(
  orgn_set_id_    VARCHAR2(40) not null,
  org_id_         VARCHAR2(40) not null,
  parent_org_id_  VARCHAR2(40),
  org_code_       VARCHAR2(60) not null,
  org_name_       VARCHAR2(60) not null,
  org_abbr_name_  VARCHAR2(60),
  org_type_       VARCHAR2(20) not null,
  org_category_   VARCHAR2(20) not null,
  memo_           VARCHAR2(300),
  org_tag_        VARCHAR2(120),
  org_ext_attr_1_ VARCHAR2(120),
  org_ext_attr_2_ VARCHAR2(120),
  org_ext_attr_3_ VARCHAR2(120),
  org_ext_attr_4_ VARCHAR2(120),
  org_ext_attr_5_ VARCHAR2(120),
  org_ext_attr_6_ VARCHAR2(120),
  org_ext_attr_7_ VARCHAR2(120),
  org_ext_attr_8_ VARCHAR2(120),
  order_          INTEGER,
  org_status_     VARCHAR2(20) not null,
  creation_date_  TIMESTAMP(6),
  update_date_    TIMESTAMP(6),
  operator_id_    VARCHAR2(40),
  operator_name_  VARCHAR2(60)
)
;
comment on table OM_ORG
  is '机构';
comment on column OM_ORG.orgn_set_id_
  is '组织架构套ID';
comment on column OM_ORG.org_id_
  is '机构ID';
comment on column OM_ORG.parent_org_id_
  is '上级机构ID';
comment on column OM_ORG.org_code_
  is '机构编码';
comment on column OM_ORG.org_name_
  is '机构名称';
comment on column OM_ORG.org_abbr_name_
  is '机构简称';
comment on column OM_ORG.org_type_
  is '机构类型';
comment on column OM_ORG.org_category_
  is '分类';
comment on column OM_ORG.memo_
  is '备注';
comment on column OM_ORG.org_tag_
  is '机构标签';
comment on column OM_ORG.org_ext_attr_1_
  is '机构扩展属性1';
comment on column OM_ORG.org_ext_attr_2_
  is '机构扩展属性2';
comment on column OM_ORG.org_ext_attr_3_
  is '机构扩展属性3';
comment on column OM_ORG.org_ext_attr_4_
  is '机构扩展属性4';
comment on column OM_ORG.org_ext_attr_5_
  is '机构扩展属性5';
comment on column OM_ORG.org_ext_attr_6_
  is '机构扩展属性6';
comment on column OM_ORG.org_ext_attr_7_
  is '机构扩展属性7';
comment on column OM_ORG.org_ext_attr_8_
  is '机构扩展属性8';
comment on column OM_ORG.order_
  is '排序';
comment on column OM_ORG.org_status_
  is '机构状态';
comment on column OM_ORG.creation_date_
  is '创建日期';
comment on column OM_ORG.update_date_
  is '修改日期';
comment on column OM_ORG.operator_id_
  is '操作人员ID';
comment on column OM_ORG.operator_name_
  is '操作人员名称';
create index IX_OM_ORG_ORDER on OM_ORG (ORDER_);
alter table OM_ORG
  add constraint PK_OM_ORG primary key (ORGN_SET_ID_, ORG_ID_);
alter table OM_ORG
  add constraint UQ_OM_ORG_CODE unique (ORGN_SET_ID_, ORG_CODE_);
alter table OM_ORG
  add constraint FK_OM_ORG_ORGN_SET foreign key (ORGN_SET_ID_)
  references OM_ORGN_SET (ORGN_SET_ID_);
alter table OM_ORG
  add constraint FK_OM_ORG_PARENT foreign key (ORGN_SET_ID_, PARENT_ORG_ID_)
  references OM_ORG (ORGN_SET_ID_, ORG_ID_);

prompt
prompt Creating table OM_EMP
prompt =====================
prompt
create table OM_EMP
(
  orgn_set_id_        VARCHAR2(40) not null,
  emp_id_             VARCHAR2(40) not null,
  org_id_             VARCHAR2(40) not null,
  emp_code_           VARCHAR2(60) not null,
  emp_name_           VARCHAR2(60) not null,
  password_           VARCHAR2(40),
  password_reset_req_ VARCHAR2(20) not null,
  party_              VARCHAR2(20),
  emp_level_          VARCHAR2(20),
  gender_             VARCHAR2(20),
  birth_date_         TIMESTAMP(6),
  tel_                VARCHAR2(60),
  email_              VARCHAR2(60),
  in_date_            TIMESTAMP(6),
  out_date_           TIMESTAMP(6),
  emp_category_       VARCHAR2(20) not null,
  memo_               VARCHAR2(300),
  emp_tag_            VARCHAR2(120),
  emp_ext_attr_1_     VARCHAR2(120),
  emp_ext_attr_2_     VARCHAR2(120),
  emp_ext_attr_3_     VARCHAR2(120),
  emp_ext_attr_4_     VARCHAR2(120),
  emp_ext_attr_5_     VARCHAR2(120),
  emp_ext_attr_6_     VARCHAR2(120),
  emp_ext_attr_7_     VARCHAR2(120),
  emp_ext_attr_8_     VARCHAR2(120),
  order_              INTEGER,
  emp_status_         VARCHAR2(20) not null,
  creation_date_      TIMESTAMP(6),
  update_date_        TIMESTAMP(6),
  operator_id_        VARCHAR2(40),
  operator_name_      VARCHAR2(60)
)
;
comment on table OM_EMP
  is '人员';
comment on column OM_EMP.orgn_set_id_
  is '组织架构套ID';
comment on column OM_EMP.emp_id_
  is '人员ID';
comment on column OM_EMP.org_id_
  is '机构ID';
comment on column OM_EMP.emp_code_
  is '人员编码';
comment on column OM_EMP.emp_name_
  is '人员名称';
comment on column OM_EMP.password_
  is '密码';
comment on column OM_EMP.password_reset_req_
  is '密码重置';
comment on column OM_EMP.party_
  is '政治面貌';
comment on column OM_EMP.emp_level_
  is '职级';
comment on column OM_EMP.gender_
  is '性别';
comment on column OM_EMP.birth_date_
  is '出生日期';
comment on column OM_EMP.tel_
  is '电话';
comment on column OM_EMP.email_
  is '电子邮箱';
comment on column OM_EMP.in_date_
  is '入职日期';
comment on column OM_EMP.out_date_
  is '离职日期';
comment on column OM_EMP.emp_category_
  is '分类';
comment on column OM_EMP.memo_
  is '备注';
comment on column OM_EMP.emp_tag_
  is '人员标签';
comment on column OM_EMP.emp_ext_attr_1_
  is '人员扩展属性1';
comment on column OM_EMP.emp_ext_attr_2_
  is '人员扩展属性2';
comment on column OM_EMP.emp_ext_attr_3_
  is '人员扩展属性3';
comment on column OM_EMP.emp_ext_attr_4_
  is '人员扩展属性4';
comment on column OM_EMP.emp_ext_attr_5_
  is '人员扩展属性5';
comment on column OM_EMP.emp_ext_attr_6_
  is '人员扩展属性6';
comment on column OM_EMP.emp_ext_attr_7_
  is '人员扩展属性7';
comment on column OM_EMP.emp_ext_attr_8_
  is '人员扩展属性8';
comment on column OM_EMP.order_
  is '排序';
comment on column OM_EMP.emp_status_
  is '人员状态';
comment on column OM_EMP.creation_date_
  is '创建日期';
comment on column OM_EMP.update_date_
  is '更新日期';
comment on column OM_EMP.operator_id_
  is '操作人员ID';
comment on column OM_EMP.operator_name_
  is '操作人员名称';
create index IX_OM_EMP_ORDER on OM_EMP (ORDER_);
alter table OM_EMP
  add constraint PK_OM_EMP primary key (ORGN_SET_ID_, EMP_ID_);
alter table OM_EMP
  add constraint UQ_OM_EMP_CODE unique (ORGN_SET_ID_, EMP_CODE_);
alter table OM_EMP
  add constraint FK_OM_EMP_ORG foreign key (ORGN_SET_ID_, ORG_ID_)
  references OM_ORG (ORGN_SET_ID_, ORG_ID_);
alter table OM_EMP
  add constraint FK_OM_EMP_ORGN_SET foreign key (ORGN_SET_ID_)
  references OM_ORGN_SET (ORGN_SET_ID_);

prompt
prompt Creating table OM_EMP_RELATION
prompt ==============================
prompt
create table OM_EMP_RELATION
(
  orgn_set_id_             VARCHAR2(40) not null,
  emp_relation_id_         VARCHAR2(40) not null,
  upper_emp_id_            VARCHAR2(40) not null,
  lower_emp_id_            VARCHAR2(40) not null,
  emp_relation_            VARCHAR2(20) not null,
  emp_relation_category_   VARCHAR2(20),
  memo_                    VARCHAR2(300),
  emp_relation_tag_        VARCHAR2(120),
  emp_relation_ext_attr_1_ VARCHAR2(120),
  emp_relation_ext_attr_2_ VARCHAR2(120),
  emp_relation_ext_attr_3_ VARCHAR2(120),
  emp_relation_ext_attr_4_ VARCHAR2(120),
  emp_relation_ext_attr_5_ VARCHAR2(120),
  emp_relation_ext_attr_6_ VARCHAR2(120),
  emp_relation_ext_attr_7_ VARCHAR2(120),
  emp_relation_ext_attr_8_ VARCHAR2(120),
  order_                   INTEGER,
  emp_relation_status_     VARCHAR2(20) not null,
  creation_date_           TIMESTAMP(6),
  update_date_             TIMESTAMP(6),
  operator_id_             VARCHAR2(40),
  operator_name_           VARCHAR2(60)
)
;
comment on table OM_EMP_RELATION
  is '人员关系';
comment on column OM_EMP_RELATION.orgn_set_id_
  is '组织架构套ID';
comment on column OM_EMP_RELATION.emp_relation_id_
  is '人员关系ID';
comment on column OM_EMP_RELATION.upper_emp_id_
  is '上级人员ID';
comment on column OM_EMP_RELATION.lower_emp_id_
  is '下级人员ID';
comment on column OM_EMP_RELATION.emp_relation_
  is '人员关系';
comment on column OM_EMP_RELATION.emp_relation_category_
  is '分类';
comment on column OM_EMP_RELATION.memo_
  is '备注';
comment on column OM_EMP_RELATION.emp_relation_tag_
  is '人员关系标签';
comment on column OM_EMP_RELATION.emp_relation_ext_attr_1_
  is '人员关系扩展属性1';
comment on column OM_EMP_RELATION.emp_relation_ext_attr_2_
  is '人员关系扩展属性2';
comment on column OM_EMP_RELATION.emp_relation_ext_attr_3_
  is '人员关系扩展属性3';
comment on column OM_EMP_RELATION.emp_relation_ext_attr_4_
  is '人员关系扩展属性4';
comment on column OM_EMP_RELATION.emp_relation_ext_attr_5_
  is '人员关系扩展属性5';
comment on column OM_EMP_RELATION.emp_relation_ext_attr_6_
  is '人员关系扩展属性6';
comment on column OM_EMP_RELATION.emp_relation_ext_attr_7_
  is '人员关系扩展属性7';
comment on column OM_EMP_RELATION.emp_relation_ext_attr_8_
  is '人员关系扩展属性8';
comment on column OM_EMP_RELATION.order_
  is '排序';
comment on column OM_EMP_RELATION.emp_relation_status_
  is '人员关系状态';
comment on column OM_EMP_RELATION.creation_date_
  is '创建日期';
comment on column OM_EMP_RELATION.update_date_
  is '修改日期';
comment on column OM_EMP_RELATION.operator_id_
  is '操作人员ID';
comment on column OM_EMP_RELATION.operator_name_
  is '操作人员名称';
alter table OM_EMP_RELATION
  add constraint PK_OM_EMP_RELATION primary key (ORGN_SET_ID_, EMP_RELATION_ID_);
alter table OM_EMP_RELATION
  add constraint UQ_OM_EMP_RELATION unique (ORGN_SET_ID_, UPPER_EMP_ID_, LOWER_EMP_ID_, EMP_RELATION_);
alter table OM_EMP_RELATION
  add constraint FK_OM_EMP_RELATION_LOWER_EMP foreign key (ORGN_SET_ID_, LOWER_EMP_ID_)
  references OM_EMP (ORGN_SET_ID_, EMP_ID_);
alter table OM_EMP_RELATION
  add constraint FK_OM_EMP_RELATION_ORNG_SET foreign key (ORGN_SET_ID_)
  references OM_ORGN_SET (ORGN_SET_ID_);
alter table OM_EMP_RELATION
  add constraint FK_OM_EMP_RELATION_UPPER_EMP foreign key (ORGN_SET_ID_, UPPER_EMP_ID_)
  references OM_EMP (ORGN_SET_ID_, EMP_ID_);

prompt
prompt Creating table OM_LOG
prompt =====================
prompt
create table OM_LOG
(
  log_id_        VARCHAR2(40) not null,
  category_      VARCHAR2(60),
  ip_            VARCHAR2(60),
  user_agent_    VARCHAR2(200),
  url_           CLOB,
  action_        VARCHAR2(200),
  parameter_map_ CLOB,
  business_key_  VARCHAR2(40),
  error_         VARCHAR2(20),
  message_       CLOB,
  org_id_        VARCHAR2(40),
  org_name_      VARCHAR2(60),
  posi_id_       VARCHAR2(40),
  posi_name_     VARCHAR2(60),
  emp_id_        VARCHAR2(40),
  emp_name_      VARCHAR2(60),
  creation_date_ TIMESTAMP(6) not null
)
;
comment on table OM_LOG
  is '日志';
comment on column OM_LOG.log_id_
  is '日志ID';
comment on column OM_LOG.category_
  is '分类';
comment on column OM_LOG.ip_
  is 'IP';
comment on column OM_LOG.user_agent_
  is '用户代理';
comment on column OM_LOG.url_
  is '调用URL';
comment on column OM_LOG.action_
  is '调用控制层接口';
comment on column OM_LOG.parameter_map_
  is '调用参数';
comment on column OM_LOG.business_key_
  is '业务主键';
comment on column OM_LOG.error_
  is '错误';
comment on column OM_LOG.message_
  is '信息';
comment on column OM_LOG.org_id_
  is '机构ID';
comment on column OM_LOG.org_name_
  is '机构名称';
comment on column OM_LOG.posi_id_
  is '岗位ID';
comment on column OM_LOG.posi_name_
  is '岗位名称';
comment on column OM_LOG.emp_id_
  is '人员ID';
comment on column OM_LOG.emp_name_
  is '人员名称';
comment on column OM_LOG.creation_date_
  is '创建日期';
alter table OM_LOG
  add constraint PK_OM_LOG primary key (LOG_ID_);

prompt
prompt Creating table OM_MAIN_SERVER
prompt =============================
prompt
create table OM_MAIN_SERVER
(
  main_server_id_     VARCHAR2(40) not null,
  main_server_name_   VARCHAR2(60) not null,
  driver_class_name_  VARCHAR2(100) not null,
  url_                VARCHAR2(200) not null,
  username_           VARCHAR2(40) not null,
  password_           VARCHAR2(40) not null,
  memo_               VARCHAR2(300),
  last_sync_date_     TIMESTAMP(6),
  order_              INTEGER,
  main_server_status_ VARCHAR2(20) not null,
  creation_date_      TIMESTAMP(6),
  update_date_        TIMESTAMP(6),
  operator_id_        VARCHAR2(40),
  operator_name_      VARCHAR2(60)
)
;
comment on table OM_MAIN_SERVER
  is '主服务器';
comment on column OM_MAIN_SERVER.main_server_id_
  is '主服务器ID';
comment on column OM_MAIN_SERVER.main_server_name_
  is '主服务器名称';
comment on column OM_MAIN_SERVER.driver_class_name_
  is '驱动类名称';
comment on column OM_MAIN_SERVER.url_
  is '链接';
comment on column OM_MAIN_SERVER.username_
  is '用户名';
comment on column OM_MAIN_SERVER.password_
  is '密码';
comment on column OM_MAIN_SERVER.memo_
  is '备注';
comment on column OM_MAIN_SERVER.last_sync_date_
  is '上次同步日期';
comment on column OM_MAIN_SERVER.order_
  is '排序';
comment on column OM_MAIN_SERVER.main_server_status_
  is '主服务器状态';
comment on column OM_MAIN_SERVER.creation_date_
  is '创建日期';
comment on column OM_MAIN_SERVER.update_date_
  is '修改日期';
comment on column OM_MAIN_SERVER.operator_id_
  is '操作人员ID';
comment on column OM_MAIN_SERVER.operator_name_
  is '操作人员名称';
alter table OM_MAIN_SERVER
  add constraint PK_OM_MAIN_SERVER primary key (MAIN_SERVER_ID_);
alter table OM_MAIN_SERVER
  add constraint UQ_OM_MAIN_SERVER_NAME unique (MAIN_SERVER_NAME_);

prompt
prompt Creating table OM_MIRROR_SERVER
prompt ===============================
prompt
create table OM_MIRROR_SERVER
(
  mirror_server_id_     VARCHAR2(40) not null,
  mirror_server_name_   VARCHAR2(60) not null,
  driver_class_name_    VARCHAR2(100) not null,
  url_                  VARCHAR2(200) not null,
  username_             VARCHAR2(40) not null,
  password_             VARCHAR2(40) not null,
  memo_                 VARCHAR2(300),
  last_sync_date_       TIMESTAMP(6),
  order_                INTEGER,
  mirror_server_status_ VARCHAR2(20) not null,
  creation_date_        TIMESTAMP(6),
  update_date_          TIMESTAMP(6),
  operator_id_          VARCHAR2(40),
  operator_name_        VARCHAR2(60)
)
;
comment on table OM_MIRROR_SERVER
  is '镜像服务器';
comment on column OM_MIRROR_SERVER.mirror_server_id_
  is '镜像服务器ID';
comment on column OM_MIRROR_SERVER.mirror_server_name_
  is '镜像服务器名称';
comment on column OM_MIRROR_SERVER.driver_class_name_
  is '驱动类名称';
comment on column OM_MIRROR_SERVER.url_
  is '链接';
comment on column OM_MIRROR_SERVER.username_
  is '用户名';
comment on column OM_MIRROR_SERVER.password_
  is '密码';
comment on column OM_MIRROR_SERVER.memo_
  is '备注';
comment on column OM_MIRROR_SERVER.last_sync_date_
  is '上次同步日期';
comment on column OM_MIRROR_SERVER.order_
  is '排序';
comment on column OM_MIRROR_SERVER.mirror_server_status_
  is '镜像服务器状态';
comment on column OM_MIRROR_SERVER.creation_date_
  is '创建日期';
comment on column OM_MIRROR_SERVER.update_date_
  is '修改日期';
comment on column OM_MIRROR_SERVER.operator_id_
  is '操作人员ID';
comment on column OM_MIRROR_SERVER.operator_name_
  is '操作人员名称';
alter table OM_MIRROR_SERVER
  add constraint PK_OM_MIRROR_SERVER primary key (MIRROR_SERVER_ID_);
alter table OM_MIRROR_SERVER
  add constraint UQ_OM_MIRROR_SERVER_NAME unique (MIRROR_SERVER_NAME_);

prompt
prompt Creating table OM_POSI
prompt ======================
prompt
create table OM_POSI
(
  orgn_set_id_     VARCHAR2(40) not null,
  posi_id_         VARCHAR2(40) not null,
  org_id_          VARCHAR2(40) not null,
  duty_id_         VARCHAR2(40),
  posi_code_       VARCHAR2(60),
  posi_name_       VARCHAR2(60) not null,
  org_leader_type_ VARCHAR2(20),
  posi_category_   VARCHAR2(20) not null,
  memo_            VARCHAR2(300),
  posi_tag_        VARCHAR2(120),
  posi_ext_attr_1_ VARCHAR2(120),
  posi_ext_attr_2_ VARCHAR2(120),
  posi_ext_attr_3_ VARCHAR2(120),
  posi_ext_attr_4_ VARCHAR2(120),
  posi_ext_attr_5_ VARCHAR2(120),
  posi_ext_attr_6_ VARCHAR2(120),
  posi_ext_attr_7_ VARCHAR2(120),
  posi_ext_attr_8_ VARCHAR2(120),
  order_           INTEGER,
  posi_status_     VARCHAR2(20) not null,
  creation_date_   TIMESTAMP(6),
  update_date_     TIMESTAMP(6),
  operator_id_     VARCHAR2(40),
  operator_name_   VARCHAR2(60)
)
;
comment on table OM_POSI
  is '岗位';
comment on column OM_POSI.orgn_set_id_
  is '组织架构套ID';
comment on column OM_POSI.posi_id_
  is '岗位ID';
comment on column OM_POSI.org_id_
  is '机构ID';
comment on column OM_POSI.duty_id_
  is '职务ID';
comment on column OM_POSI.posi_code_
  is '岗位编码';
comment on column OM_POSI.posi_name_
  is '岗位名称';
comment on column OM_POSI.org_leader_type_
  is '机构领导类型';
comment on column OM_POSI.posi_category_
  is '分类';
comment on column OM_POSI.memo_
  is '备注';
comment on column OM_POSI.posi_tag_
  is '岗位标签';
comment on column OM_POSI.posi_ext_attr_1_
  is '岗位扩展属性1';
comment on column OM_POSI.posi_ext_attr_2_
  is '岗位扩展属性2';
comment on column OM_POSI.posi_ext_attr_3_
  is '岗位扩展属性3';
comment on column OM_POSI.posi_ext_attr_4_
  is '岗位扩展属性4';
comment on column OM_POSI.posi_ext_attr_5_
  is '岗位扩展属性5';
comment on column OM_POSI.posi_ext_attr_6_
  is '岗位扩展属性6';
comment on column OM_POSI.posi_ext_attr_7_
  is '岗位扩展属性7';
comment on column OM_POSI.posi_ext_attr_8_
  is '岗位扩展属性8';
comment on column OM_POSI.order_
  is '排序';
comment on column OM_POSI.posi_status_
  is '岗位状态';
comment on column OM_POSI.creation_date_
  is '创建日期';
comment on column OM_POSI.update_date_
  is '修改日期';
comment on column OM_POSI.operator_id_
  is '操作人员ID';
comment on column OM_POSI.operator_name_
  is '操作人员名称';
alter table OM_POSI
  add constraint PK_OM_POSI primary key (ORGN_SET_ID_, POSI_ID_);
alter table OM_POSI
  add constraint UQ_OM_POSI_CODE unique (ORGN_SET_ID_, POSI_CODE_)
  disable
  novalidate;
alter table OM_POSI
  add constraint FK_OM_POSI_DUTY foreign key (ORGN_SET_ID_, DUTY_ID_)
  references OM_DUTY (ORGN_SET_ID_, DUTY_ID_);
alter table OM_POSI
  add constraint FK_OM_POSI_ORG foreign key (ORGN_SET_ID_, ORG_ID_)
  references OM_ORG (ORGN_SET_ID_, ORG_ID_);
alter table OM_POSI
  add constraint FK_OM_POSI_ORGN_SET foreign key (ORGN_SET_ID_)
  references OM_ORGN_SET (ORGN_SET_ID_);

prompt
prompt Creating table OM_POSI_EMP
prompt ==========================
prompt
create table OM_POSI_EMP
(
  orgn_set_id_         VARCHAR2(40) not null,
  posi_emp_id_         VARCHAR2(40) not null,
  posi_id_             VARCHAR2(40) not null,
  emp_id_              VARCHAR2(40) not null,
  main_                VARCHAR2(20) not null,
  posi_emp_category_   VARCHAR2(20),
  memo_                VARCHAR2(300),
  posi_emp_tag_        VARCHAR2(120),
  posi_emp_ext_attr_1_ VARCHAR2(120),
  posi_emp_ext_attr_2_ VARCHAR2(120),
  posi_emp_ext_attr_3_ VARCHAR2(120),
  posi_emp_ext_attr_4_ VARCHAR2(120),
  posi_emp_ext_attr_5_ VARCHAR2(120),
  posi_emp_ext_attr_6_ VARCHAR2(120),
  posi_emp_ext_attr_7_ VARCHAR2(120),
  posi_emp_ext_attr_8_ VARCHAR2(120),
  order_               INTEGER,
  posi_emp_status_     VARCHAR2(20) not null,
  creation_date_       TIMESTAMP(6),
  update_date_         TIMESTAMP(6),
  operator_id_         VARCHAR2(40),
  operator_name_       VARCHAR2(60)
)
;
comment on table OM_POSI_EMP
  is '岗位人员';
comment on column OM_POSI_EMP.orgn_set_id_
  is '组织架构套ID';
comment on column OM_POSI_EMP.posi_emp_id_
  is '岗位人员ID';
comment on column OM_POSI_EMP.posi_id_
  is '岗位ID';
comment on column OM_POSI_EMP.emp_id_
  is '人员ID';
comment on column OM_POSI_EMP.main_
  is '主岗位';
comment on column OM_POSI_EMP.posi_emp_category_
  is '分类';
comment on column OM_POSI_EMP.memo_
  is '备注';
comment on column OM_POSI_EMP.posi_emp_tag_
  is '岗位人员标签';
comment on column OM_POSI_EMP.posi_emp_ext_attr_1_
  is '岗位人员扩展属性1';
comment on column OM_POSI_EMP.posi_emp_ext_attr_2_
  is '岗位人员扩展属性2';
comment on column OM_POSI_EMP.posi_emp_ext_attr_3_
  is '岗位人员扩展属性3';
comment on column OM_POSI_EMP.posi_emp_ext_attr_4_
  is '岗位人员扩展属性4';
comment on column OM_POSI_EMP.posi_emp_ext_attr_5_
  is '岗位人员扩展属性5';
comment on column OM_POSI_EMP.posi_emp_ext_attr_6_
  is '岗位人员扩展属性6';
comment on column OM_POSI_EMP.posi_emp_ext_attr_7_
  is '岗位人员扩展属性7';
comment on column OM_POSI_EMP.posi_emp_ext_attr_8_
  is '岗位人员扩展属性8';
comment on column OM_POSI_EMP.order_
  is '排序';
comment on column OM_POSI_EMP.posi_emp_status_
  is '岗位人员状态';
comment on column OM_POSI_EMP.creation_date_
  is '创建日期';
comment on column OM_POSI_EMP.update_date_
  is '更新日期';
comment on column OM_POSI_EMP.operator_id_
  is '操作人员ID';
comment on column OM_POSI_EMP.operator_name_
  is '操作人员名称';
create index IX_POSI_EMP_EMP on OM_POSI_EMP (EMP_ID_);
create index IX_POSI_EMP_POSI on OM_POSI_EMP (POSI_ID_);
alter table OM_POSI_EMP
  add constraint PK_OM_POSI_EMP primary key (ORGN_SET_ID_, POSI_EMP_ID_);
alter table OM_POSI_EMP
  add constraint UQ_OM_POSI_EMP unique (ORGN_SET_ID_, POSI_ID_, EMP_ID_);
alter table OM_POSI_EMP
  add constraint FK_OM_POSI_EMP_EMP foreign key (ORGN_SET_ID_, EMP_ID_)
  references OM_EMP (ORGN_SET_ID_, EMP_ID_);
alter table OM_POSI_EMP
  add constraint FK_OM_POSI_EMP_ORGN_SET foreign key (ORGN_SET_ID_)
  references OM_ORGN_SET (ORGN_SET_ID_);
alter table OM_POSI_EMP
  add constraint FK_OM_POSI_EMP_POSI foreign key (ORGN_SET_ID_, POSI_ID_)
  references OM_POSI (ORGN_SET_ID_, POSI_ID_);

prompt
prompt Creating table OM_TAG
prompt =====================
prompt
create table OM_TAG
(
  orgn_set_id_ VARCHAR2(40) not null,
  tag_id_      VARCHAR2(40) not null,
  obj_id_      VARCHAR2(40) not null,
  obj_type_    VARCHAR2(60),
  tag_         VARCHAR2(60) not null
)
;
comment on table OM_TAG
  is '标签';
comment on column OM_TAG.orgn_set_id_
  is '组织架构套ID';
comment on column OM_TAG.tag_id_
  is '标签ID';
comment on column OM_TAG.obj_id_
  is '对象ID';
comment on column OM_TAG.obj_type_
  is '对象类型';
comment on column OM_TAG.tag_
  is '标签';
alter table OM_TAG
  add constraint PK_OM_TAG primary key (ORGN_SET_ID_, TAG_ID_);
alter table OM_TAG
  add constraint FK_OM_TAG_ORGN_SET foreign key (ORGN_SET_ID_)
  references OM_ORGN_SET (ORGN_SET_ID_);

prompt
prompt Creating view OMV_CODE
prompt ======================
prompt
create or replace force view omv_code as
select CODE_ID_, PARENT_CODE_ID_, CATEGORY_, CODE_, NAME_, EXT_ATTR_1_, EXT_ATTR_2_, EXT_ATTR_3_, EXT_ATTR_4_, EXT_ATTR_5_, EXT_ATTR_6_, ORDER_ from OM_CODE;

prompt
prompt Creating view OMV_DUTY
prompt ======================
prompt
create or replace force view omv_duty as
select ORGN_SET.ORGN_SET_ID_, ORGN_SET.ORGN_SET_CODE_, ORGN_SET.ORGN_SET_NAME_, D.DUTY_ID_, D.DUTY_CODE_, D.DUTY_NAME_, D.DUTY_CATEGORY_, D.MEMO_, D.DUTY_TAG_, D.DUTY_EXT_ATTR_1_, D.DUTY_EXT_ATTR_2_, D.DUTY_EXT_ATTR_3_, D.DUTY_EXT_ATTR_4_, D.DUTY_EXT_ATTR_5_, D.DUTY_EXT_ATTR_6_, D.DUTY_EXT_ATTR_7_, D.DUTY_EXT_ATTR_8_, D.ORDER_, D.DUTY_STATUS_, D.CREATION_DATE_, D.UPDATE_DATE_, D.OPERATOR_ID_, D.OPERATOR_NAME_ from OM_DUTY D inner join OM_ORGN_SET ORGN_SET on ORGN_SET.ORGN_SET_ID_ = D.ORGN_SET_ID_;

prompt
prompt Creating view OMV_EMP
prompt =====================
prompt
create or replace force view omv_emp as
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

prompt
prompt Creating view OMV_EMP_RELATION
prompt ==============================
prompt
create or replace force view omv_emp_relation as
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

prompt
prompt Creating view OMV_LOG
prompt =====================
prompt
create or replace force view omv_log as
select LOG_ID_, CATEGORY_, IP_, USER_AGENT_, URL_, ACTION_, PARAMETER_MAP_, BUSINESS_KEY_, ERROR_, MESSAGE_, ORG_ID_, ORG_NAME_, POSI_ID_, POSI_NAME_, EMP_ID_, EMP_NAME_, CREATION_DATE_ from OM_LOG;

prompt
prompt Creating view OMV_MAIN_SERVER
prompt =============================
prompt
create or replace force view omv_main_server as
select MS.MAIN_SERVER_ID_, MS.MAIN_SERVER_NAME_, MS.DRIVER_CLASS_NAME_, MS.URL_, MS.USERNAME_, MS.PASSWORD_, MS.MEMO_, MS.LAST_SYNC_DATE_, MS.ORDER_, MS.MAIN_SERVER_STATUS_, MS.CREATION_DATE_, MS.UPDATE_DATE_, MS.OPERATOR_ID_, MS.OPERATOR_NAME_ from OM_MAIN_SERVER MS;

prompt
prompt Creating view OMV_MIRROR_SERVER
prompt ===============================
prompt
create or replace force view omv_mirror_server as
select MS.MIRROR_SERVER_ID_, MS.MIRROR_SERVER_NAME_, MS.DRIVER_CLASS_NAME_, MS.URL_, MS.USERNAME_, MS.PASSWORD_, MS.MEMO_, MS.LAST_SYNC_DATE_, MS.ORDER_, MS.MIRROR_SERVER_STATUS_, MS.CREATION_DATE_, MS.UPDATE_DATE_, MS.OPERATOR_ID_, MS.OPERATOR_NAME_ from OM_MIRROR_SERVER MS;

prompt
prompt Creating view OMV_ORG
prompt =====================
prompt
create or replace force view omv_org as
select ORGN_SET.ORGN_SET_ID_, ORGN_SET.ORGN_SET_CODE_, ORGN_SET.ORGN_SET_NAME_, O1.ORG_ID_, O1.PARENT_ORG_ID_, O1.ORG_CODE_, O1.ORG_NAME_, O1.ORG_ABBR_NAME_, O1.ORG_TYPE_, O1.ORG_CATEGORY_, O1.MEMO_, O1.ORG_TAG_, O1.ORG_EXT_ATTR_1_, O1.ORG_EXT_ATTR_2_, O1.ORG_EXT_ATTR_3_, O1.ORG_EXT_ATTR_4_, O1.ORG_EXT_ATTR_5_, O1.ORG_EXT_ATTR_6_, O1.ORG_EXT_ATTR_7_, O1.ORG_EXT_ATTR_8_, O1.ORDER_, O1.ORG_STATUS_, O1.CREATION_DATE_, O1.UPDATE_DATE_, O1.OPERATOR_ID_, O1.OPERATOR_NAME_, O2.ORG_CODE_ as PARENT_ORG_CODE_, O2.ORG_NAME_ as PARENT_ORG_NAME_
  from OM_ORG O1
 inner join OM_ORGN_SET ORGN_SET
    on ORGN_SET.ORGN_SET_ID_ = O1.ORGN_SET_ID_
  left outer join OM_ORG O2
    on O2.ORGN_SET_ID_ = O1.ORGN_SET_ID_
   and O2.ORG_ID_ = O1.PARENT_ORG_ID_;

prompt
prompt Creating view OMV_ORGN_SET
prompt ==========================
prompt
create or replace force view omv_orgn_set as
select OS1.ORGN_SET_ID_, OS1.PARENT_ORGN_SET_ID_, OS1.ORGN_SET_CODE_, OS1.ORGN_SET_NAME_, OS1.ALLOW_SYNC_, OS1.MEMO_, OS1.ORDER_, OS1.ORGN_SET_STATUS_, OS1.CREATION_DATE_, OS1.UPDATE_DATE_, OS1.OPERATOR_ID_, OS1.OPERATOR_NAME_, OS2.ORGN_SET_CODE_ as PARENT_ORGN_SET_CODE_, OS2.ORGN_SET_NAME_ as PARENT_ORGN_SET_NAME_ from OM_ORGN_SET OS1 left outer join OM_ORGN_SET OS2 on OS2.ORGN_SET_ID_ = OS1.PARENT_ORGN_SET_ID_;

prompt
prompt Creating view OMV_POSI
prompt ======================
prompt
create or replace force view omv_posi as
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

prompt
prompt Creating view OMV_POSI_EMP
prompt ==========================
prompt
create or replace force view omv_posi_emp as
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

prompt
prompt Creating view OMV_TAG
prompt =====================
prompt
create or replace force view omv_tag as
select T.ORGN_SET_ID_, T.TAG_ID_, T.OBJ_ID_, T.OBJ_TYPE_, T.TAG_, ORGN_SET.ORGN_SET_CODE_, ORGN_SET.ORGN_SET_NAME_ from OM_TAG T inner join OM_ORGN_SET ORGN_SET on ORGN_SET.ORGN_SET_ID_ = T.ORGN_SET_ID_;


prompt Done
spool off
set define on
