package review;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DB.*;
import bean.*;

public class review_DAO {

	// ��ü�� �Ű������� �޴´�.
	// �����ۼ�
	public static void review_write(review_Bean bean) {

		try {

			// DB����
			Connection conn = DBConnector.getConnection();

			// SQL ��
			String sql = "INSERT INTO REVIEW_TABLE(review_num, user_id, review_title,review_thema, review_place,review_content, review_cnt, review_star, review_regdate)"
					+ " VALUES(review_num.nextval, ?, ?, ?,?, ?, 0, ?,  sysdate)";

			PreparedStatement psmt = conn.prepareStatement(sql);

			psmt.setString(1, bean.getUser_id());
			psmt.setString(2, bean.getReview_title()); 
			psmt.setString(3, bean.getReview_thema());
			psmt.setString(4,bean.getReview_place());
			psmt.setString(5, bean.getReview_content());
			psmt.setInt(6, bean.getReview_star());
			

			// SQL ����
			psmt.execute();

			// DB ���� ����
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	} // review_write()

	// ��� ����۵��� �ҷ��´�.
	public static ArrayList<review_Bean> review_get(int start, int end) {

		// Arraylist ����
		// ��ü�� ���� arraylist
		ArrayList<review_Bean> list = new ArrayList<review_Bean>();

		try {

		
			// DB����
			Connection conn = DBConnector.getConnection();

			// SQL
			// ����Խ��ǿ� ��� �����͸� �ҷ��´�.
			String sql =  "select * from "
						 + "(select rownum as rnum, a1.* from "
					     + "(select review_num, user_id, review_title, review_thema, review_place,review_content, review_cnt, review_star, review_regdate FROM REVIEW_TABLE ORDER BY review_num DESC) a1) a2 "
						 + "where a2.rnum >= ? and a2.rnum <=?";

			//Statement stmt = conn.createStatement();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			// SQL ����
			ResultSet rs = pstmt.executeQuery();

			// rs.next() ���� ������ ���縦 ��ȯ.
			while (rs.next()) {

				int review_num = rs.getInt("REVIEW_NUM"); // �� ��ȣ
				String user_id = rs.getString("USER_ID"); // �ۼ��� ID
				String review_title = rs.getString("REVIEW_TITLE"); // ���� ����
				String review_thema = rs.getString("REVIEW_THEMA"); // �׸�
				String review_place = rs.getString("REVIEW_PLACE"); //������
				String review_content = rs.getString("REVIEW_CONTENT"); // ���� ����
				int review_cnt = rs.getInt("REVIEW_CNT"); // ��ȸ��
				int review_star = rs.getInt("REVIEW_STAR"); // ����
				Date review_regdate = rs.getDate("REVIEW_REGDATE"); // ���� �ۼ���

				// ��ü ����
				review_Bean bean = new review_Bean();

				bean.setReview_num(review_num);
				bean.setUser_id(user_id);
				bean.setReview_title(review_title);
				bean.setReview_thema(review_thema);
				bean.setReview_place(review_place);
				bean.setReview_content(review_content);
				bean.setReview_cnt(review_cnt);
				bean.setReview_star(review_star);
				bean.setReview_regdate(review_regdate);

				list.add(bean);
			}

			// DB ���� ����
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	// ������ ���� ���ϴ� �޼���
	// �� ���ڵ��(�Խñ� ��)�� ����.
	public static int review_getPageCount() throws Exception {

		Connection conn = DBConnector.getConnection();

		// ������
		String sql = "SELECT COUNT(*) FROM " + "REVIEW_TABLE";

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();

		// ��ü ���� ������ �����´�.
		int cnt = rs.getInt(1);

		
		conn.close();

		// �� ������ ���� ����
		return cnt;

	}

	// ������� �о���� �޼���
	public static review_Bean review_read(int num) throws Exception {

		// ��ü ����
		review_Bean bean = new review_Bean();

		// DB ����
		Connection conn = DBConnector.getConnection();

		// SQL
		String sql = "SELECT * FROM REVIEW_TABLE WHERE REVIEW_NUM=" + num;

		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {

			int review_num = rs.getInt("REVIEW_NUM"); // �� ��ȣ
			String user_id = rs.getString("USER_ID"); // �ۼ��� ID
			String review_title = rs.getString("REVIEW_TITLE"); // ���� ����
			String review_thema = rs.getString("REVIEW_THEMA"); // �׸�
			String review_place = rs.getString("REVIEW_PLACE"); //������
			String review_content = rs.getString("REVIEW_CONTENT"); // ���� ����
			int review_cnt = rs.getInt("REVIEW_CNT"); // ��ȸ��
			int review_star = rs.getInt("REVIEW_STAR"); // ����
			Date review_regdate = rs.getDate("REVIEW_REGDATE"); // ���� �ۼ���

			bean.setReview_num(review_num);
			bean.setUser_id(user_id);
			bean.setReview_title(review_title);
			bean.setReview_thema(review_thema);
			bean.setReview_place(review_place);
			bean.setReview_content(review_content);
			bean.setReview_cnt(review_cnt);
			bean.setReview_star(review_star);
			bean.setReview_regdate(review_regdate);

		}

		conn.close();

		return bean;

	}
	
	
	public static void review_delete(int num) throws Exception{
		
		Connection conn = DBConnector.getConnection();

		// SQL
		String sql = "DELETE FROM REVIEW_TABLE WHERE REVIEW_NUM=" + num;

		Statement stmt = conn.createStatement();
		stmt.executeQuery(sql);
		
		conn.close();
	
		
	}

	

}
