package jsp_project.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import jsp_project.model.Member;
public class MemberDao {
	//singleton
	private static MemberDao instance = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() {
		return instance;
	}
	private static SqlSession session;
	static {
		try {
			Reader reader = Resources.getResourceAsReader("configuration.xml");
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader);
			//true�ؾ� �Է�/����/���� �̤��� commit ����
			session = ssf.openSession(true);
		} catch (Exception e) {
			System.out.println("���� : "+e.getMessage());
		}
	}
	
	public Member select(String user_id) {
		return (Member)session.selectOne("memberns.select", user_id); 
	}
	
	public int insert(Member member) {
		return session.insert("memberns.insert",member);
	}
	//�⺻ ���� Ʋ
	public int update(Member member) {
		return session.update("memberns.update",member);
	}
}
