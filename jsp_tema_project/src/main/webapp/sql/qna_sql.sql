create table qna(
	qna_num number primary key, --key
	qna_title varchar2(50) not null, -- qna ����
	qna_content varchar2(2048) not null, -- qna ����
	qna_writer varchar2(20) not null, --qna �ۼ���
	qna_readcount number default 0, --qna ��ȸ��
	qna_ref number not null, --�亯�� �׷�
	qna_re_step number not null, --ref�� ����
	qna_re_level number not null, --�鿩����
	qna_reg_date date not null, --�ۼ���
	qna_del char(1) default 'n' --qna ��������
);