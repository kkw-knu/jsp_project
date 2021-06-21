create table notice(
	notice_num number primary key, --key
	notice_title varchar2(50) not null, -- qna ����
	notice_content varchar2(2048) not null, -- qna ����
	notice_writer varchar2(20) not null, --qna �ۼ���
	notice_readcount number default 0, --qna ��ȸ��
	notice_reg_date date not null, --�ۼ���
	notice_del char(1) default 'n' --qna ��������
);
SELECT *
FROM (SELECT * FROM notice ORDER BY notice_reg_date desc)
WHERE rownum <= 3;