create table review(
review_num NUMBER PRIMARY KEY NOT NULL, --review ����
review_id VARCHAR2(20) NOT NULL, --���� ���̵� 
review_travel VARCHAR2(50) NOT NULL, --���� ������
review_title VARCHAR2(50) NOT NULL, --���� ����
review_content VARCHAR2(200) NOT NULL, --���� ����
review_star NUMBER NOT NULL, --���� �� ����
review_reg_date DATE NOT NULL --���� �ۼ���
);

alter table REVIEW_TABLE modify review_place varchar2(50);

drop table REVIEW_TABLE;

select * from REVIEW_TABLE;