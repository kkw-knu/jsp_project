package bean;

import java.util.Date;

public class review_Bean {

	private int review_num; // �� ��ȣ
	private String user_id; // �ۼ��� ID
	private String review_title; // ���� ����
	private String review_thema; //�׸�
	private String review_place; //������
	private String review_content; // ���� ����
	private int review_cnt; // ��ȸ��
	private int review_star; // ����
	private Date review_regdate; // ���� �ۼ���
	public int getReview_num() {
		return review_num;
	}
	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getReview_title() {
		return review_title;
	}
	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}
	public String getReview_thema() {
		return review_thema;
	}
	public void setReview_thema(String review_thema) {
		this.review_thema = review_thema;
	}
	public String getReview_place() {
		return review_place;
	}
	public void setReview_place(String review_place) {
		this.review_place = review_place;
	}

	public String getReview_content() {
		return review_content;
	}
	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}
	public int getReview_cnt() {
		return review_cnt;
	}
	public void setReview_cnt(int review_cnt) {
		this.review_cnt = review_cnt;
	}
	public int getReview_star() {
		return review_star;
	}
	public void setReview_star(int review_star) {
		this.review_star = review_star;
	}
	public Date getReview_regdate() {
		return review_regdate;
	}
	public void setReview_regdate(Date review_regdate) {
		this.review_regdate = review_regdate;
	}

	
}