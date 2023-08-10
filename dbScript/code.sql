prompt PL/SQL Developer Export Tables for user OM@OM
prompt Created by Administrator on 2023年8月10日
set feedback off
set define off

prompt Disabling triggers for OM_CODE...
alter table OM_CODE disable all triggers;
prompt Disabling foreign key constraints for OM_CODE...
alter table OM_CODE disable constraint FK_OM_CODE;
prompt Loading OM_CODE...
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('5117b02153454202a9243e2e8543a7fa', null, 'CATEGORY', '0', '正常', null, null, null, null, null, null, 0);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('1512f698c21a4e8299f49adb1ea1c831', null, 'CATEGORY', '1', '系统', null, null, null, null, null, null, 1);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('0863534f48734ec3aa43fb11ab9e469f', null, 'CATEGORY', '2', '外部', null, null, null, null, null, null, 2);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('4f59c166a29d449598c020a32d36882c', null, 'EMP_LEVEL', '200', '职工', null, null, null, null, null, null, 200);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('f1448051a8b24a80be4ca10d7d36c40a', null, 'EMP_LEVEL', '110', '部级', null, null, null, null, null, null, 110);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('6231742f12024d0b9809004b0d294614', null, 'EMP_LEVEL', '140', '副处级', null, null, null, null, null, null, 140);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('75d7e40a563e486e9fe54bb5891267d1', null, 'EMP_LEVEL', '160', '副科级', null, null, null, null, null, null, 160);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('7783becd619d486b93fc8f0a9b03bdd5', null, 'EMP_LEVEL', '170', '一般干部', null, null, null, null, null, null, 170);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('08713f1bf0144a15bcd8a05e235d404d', null, 'EMP_LEVEL', '150', '科级', null, null, null, null, null, null, 150);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('f0fd53361f684c80ab359abca2f92641', null, 'ORG_LEADER_TYPE', '9', '职员', null, null, null, null, null, null, 9);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('6e9915a60c994145a596db9baf53e178', null, 'EMP_RELATION', '1.2', '领导-人力资源领导', null, null, null, null, null, null, 12);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('6785a8f89a7649afb609468fc887da71', null, 'EMP_RELATION', '1.1', '领导-业务领导', null, null, null, null, null, null, 11);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('d879e829e4ca4168b8945e229be25a5e', null, 'ORG_LEADER_TYPE', '1', '正职领导', null, null, null, null, null, null, 1);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('6b03bb7d991948d5b5eb76a2ce3fd694', null, 'EMP_LEVEL', '120', '副部级', null, null, null, null, null, null, 120);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('ecac371e0f144ca0a8ebc8c156ffd0b4', null, 'EMP_LEVEL', '130', '处级', null, null, null, null, null, null, 130);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('bb3ae43db64f42ffa93d47f999ef50f6', null, 'ORG_LEADER_TYPE', '2', '副职领导', null, null, null, null, null, null, 2);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('06642c3551454a1a8744e08f56f83ea9', null, 'GENDER', '1', '男', null, null, null, null, null, null, 1);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('bcd737c3ed274758ba3cf252d6b23b84', null, 'GENDER', '0', '女', null, null, null, null, null, null, 2);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('9bf936814482430ca02dd842c14d8dfa', null, 'ORG_TYPE', '1', '总公司', null, null, null, null, null, null, 1);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('86f4d7e51eec498b8903e7e19d5828f1', null, 'ORG_TYPE', '2', '公司直属机构', null, null, null, null, null, null, 2);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('02f11dbe1f664c08a72c2265b068d49a', null, 'ORG_TYPE', '3', '独立处室', null, null, null, null, null, null, 3);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('720b7b2b11cf42aa842f845fedf47f7a', null, 'ORG_TYPE', '4', '分公司', null, null, null, null, null, null, 4);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('30f80cc593bf4822bd2b9f118324b222', null, 'ORG_TYPE', '5', '工厂', null, null, null, null, null, null, 5);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('a28b192c845546e3a3197f711b376a2f', null, 'ORG_TYPE', '9', '一般机构', null, null, null, null, null, null, 9);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('9b91591adfa34685b814bf2af361af6c', null, 'ORG_LEADER_TYPE', '3', '高管', null, null, null, null, null, null, 3);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('06c0c73bbfb14509809f362336d29c90', null, 'BOOLEAN', '1', '是', null, null, null, null, null, null, 1);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('86c1b27aa7454d92aae95f45c2b5d674', null, 'BOOLEAN', '0', '否', null, null, null, null, null, null, 2);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('bffd5233b0a14f0aa0068c191e53a37c', null, 'STATUS', '1', '生效', null, null, null, null, null, null, 1);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('51fb2b2afde24460b0ebf100829ab4d1', null, 'STATUS', '0', '失效', null, null, null, null, null, null, 2);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('123451b2f5334014825c26325d191df5', null, 'ORG_TYPE', '98', '虚拟机构', null, null, null, null, null, null, 98);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('048651b2f5334014825c26325d191df7', null, 'ORG_TYPE', '99', '相关其它单位', null, null, null, null, null, null, 99);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('0ae4aace47c2424f85eeb2fbda9d7915', null, 'OPERATION', 'INSERT', '新增', null, null, null, null, null, null, 1);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('c92155483f7e42fab9f8f0dd088a811b', null, 'OPERATION', 'UPDATE', '修改', null, null, null, null, null, null, 2);
insert into OM_CODE (code_id_, parent_code_id_, category_, code_, name_, ext_attr_1_, ext_attr_2_, ext_attr_3_, ext_attr_4_, ext_attr_5_, ext_attr_6_, order_)
values ('4f6513737d82417183b3922a5f3b4525', null, 'OPERATION', 'DELETE', '删除', null, null, null, null, null, null, 3);
commit;
prompt 38 records loaded
prompt Enabling foreign key constraints for OM_CODE...
alter table OM_CODE enable constraint FK_OM_CODE;
prompt Enabling triggers for OM_CODE...
alter table OM_CODE enable all triggers;

set feedback on
set define on
prompt Done
