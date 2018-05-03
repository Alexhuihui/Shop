drop database if exists shopbase;
create database shopbase character set utf8 collate utf8_general_ci;
use shopbase;

CREATE TABLE tb_role
(
	roleid bigint auto_increment PRIMARY KEY,
	rolename varchar(32) NOT NULL,
	remark varchar(256)
);

CREATE TABLE tb_gender
(
	genderid bigint auto_increment PRIMARY KEY,
	gender varchar(16) NOT NULL
);

CREATE TABLE tb_user
(
	userid bigint auto_increment PRIMARY KEY,
	createtime bigint NOT NULL,
	telnum bigint NOT NULL,
	passwd varchar(32) NOT NULL,
	username varchar(64) NOT NULL,
	genderid bigint DEFAULT 1,
	address varchar(256) NOT NULL,
	roleid bigint DEFAULT 1,
	remark varchar(256),
	unique(telnum)
);

CREATE TABLE tb_classifyone
(
	classifyoneid bigint auto_increment PRIMARY KEY,
	classifyonename varchar(128) NOT NULL,
	unique(classifyonename)
);

CREATE TABLE tb_classifytwo
(
	classifytwoid bigint auto_increment PRIMARY KEY,
	classifytwoname varchar(128) NOT NULL,
	classifyoneid bigint NOT NULL,
	unique(classifytwoname)
);

CREATE TABLE tb_goods
(
	goodsid bigint auto_increment PRIMARY KEY,
	goodsname varchar(128) NOT NULL,
	goodsimage varchar(128) NOT NULL,
	goodsprice bigint NOT NULL,
	classifyoneid bigint NOT NULL,
	classifytwoid bigint NOT NULL,
	unique(goodsname)
);

CREATE TABLE tb_order
(
	orderid bigint auto_increment PRIMARY KEY,
	goodsid bigint NOT NULL,
	userid bigint NOT NULL,
	createtime bigint NOT NULL,
	foreign key(userid) references tb_user(userid) on delete cascade
);

CREATE TABLE tb_orderitem
(
	orderid bigint auto_increment PRIMARY KEY,
	goodsid bigint NOT NULL,
	userid bigint NOT NULL,
	createtime bigint NOT NULL,
	foreign key(userid) references tb_user(userid) on delete cascade
);

insert into tb_gender values (NULL, 'UNKNOWN');
insert into tb_gender values (NULL, 'MALE');
insert into tb_gender values (NULL, 'FEMALE');
insert into tb_role values (NULL, 'user', 'ordinary user');
insert into tb_role values (NULL, 'super', 'super role');
insert into tb_user values (NULL, '0' ,'18579056029', 'jwxadmin', 'lisisi', 1, "jiangxinanchang", 2, 'super role');
insert into tb_user values (NULL, '0' ,'17770848782', 'shop', '汪永晖', 2, "南昌", 1, 'ordinary role');
insert into tb_user values (NULL, '0' ,'17770848781', 'shop', '吴辉', 2, "南昌", 1, 'ordinary role');
insert into tb_classifyone values (NULL, 'food');
insert into tb_classifyone values (NULL, 'clothing');
insert into tb_classifyone values (NULL, 'numeral');
insert into tb_classifytwo values (NULL, 'fruit', 1);	
insert into tb_classifytwo values (NULL, 'frock', 2);	
insert into tb_classifytwo values (NULL, 'phone', 3);	
insert into tb_goods values (NULL, 'apple' ,'c:/', 10, 1, 1);
insert into tb_goods values (NULL, 'shirt' ,'c:/', 100, 2, 2);
insert into tb_goods values (NULL, 'mi' ,'c:/', 1000, 1, 1);	
