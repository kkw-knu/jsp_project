-- alt + s : ���ٽ���
-- ���� �����ϰ� alt + x : ������ ����

create user scott identified by 1234;
alter user scott account unlock;
grant connect to scott;
grant resource to scott;
/*scott����ڰ��� ���� �� ���� �ο�*/

create table admin(
	admin_id varchar2(20) primary key,
	admin_password varchar2(20) not null
);
-- admin table ����

insert into admin values ('admin', '1234');
-- admin ���� ����

create table member(
	user_id varchar2(20) primary key,
	user_password varchar2(20) not null,
	user_name varchar2(20) not null,
	user_tel varchar2(20) not null,
	user_address varchar2(20) not null,
	user_email varchar2(40) not null,
	user_date date not null,
	user_del varchar2(20) not null
);

drop table member;