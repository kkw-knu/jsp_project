create table travel(
	travel_num number primary key,
	travel_name varchar2(50) not null,
	travel_img varchar2(200) not null,
	travel_local varchar2(50) not null,
	travel_content varchar2(2048) not null,
	travel_mini varchar2(50) not null,
	travel_q1 varchar2(50) not null,
	travel_q2 varchar2(50) not null,
	travel_q3 varchar2(50) not null,
	travel_q4 varchar2(50) not null,
	travel_star number not null --���� ����
);
/*�ʿ��Ѱ� �������� �̹������ ���� ���� ���� */
/*
 * ����, 1��2��, 3��4��, ���
 * ��, ����, ����, �ܿ�
 * ķ��, ��, �ٴ�, �׸�
 * ȥ��, Ŀ��, ����
 * 
 */
drop table travel;