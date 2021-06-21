package jsp_project.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jsp_project.dao.MemberDao;
import jsp_project.dao.Review1Dao;
import jsp_project.dao.ReviewDao;
import jsp_project.model.Member;
import jsp_project.model.Review;
import jsp_project.model.Review1;

public class Myreview implements CommandProcess {

	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if(session.getAttribute("user_id")!=null) {
			String user_id = (String)session.getAttribute("user_id");
			if(user_id.equals("master")) {
				MemberDao md = MemberDao.getInstance();
				Member member  = md.select(user_id);
				final int ROW_PER_PAGE = 10;     // ���������� 10����
				final int PAGE_PER_BLOCK = 10;   // �Ѻ��� 10������
				String pageNum = request.getParameter("pageNum");
				if (pageNum == null || pageNum.equals("")) pageNum = "1";
				int currentPage = Integer.parseInt(pageNum);
				ReviewDao rd = ReviewDao.getInstance();
				int total = rd.getManagerTotal();  
				// ���۹�ȣ	(��������ȣ - 1) * �������� ����+ 1				
				int startRow = (currentPage - 1) * ROW_PER_PAGE + 1;
				// ����ȣ 	���۹�ȣ + �������簳�� - 1			
				int endRow = startRow + ROW_PER_PAGE - 1;
				List<Review> list = rd.list(startRow, endRow); 
				// ��ȣ�� ���� ���� ���� 
				int number = total - startRow + 1;
				int totalPage = (int)Math.ceil((double)total/ROW_PER_PAGE);   // �� ������ ��
				// ����������	���������� - (���������� - 1)%10			
				int startPage = currentPage - (currentPage - 1)%PAGE_PER_BLOCK;
				// ��������	���������� + ��ϴ������� �� - 1
				int endPage = startPage + PAGE_PER_BLOCK - 1;
				// �� ���������� ū endPage���� �� ����
				if (endPage > totalPage) endPage = totalPage;
				
				String pageNum1 = request.getParameter("pageNum1");
				if (pageNum1 == null || pageNum1.equals("")) pageNum1 = "1";
				int currentPage1 = Integer.parseInt(pageNum1);
				Review1Dao rd1 = Review1Dao.getInstance();
				int total1 = rd1.getManagerTotal();  			
				int startRow1 = (currentPage1 - 1) * ROW_PER_PAGE + 1;			
				int endRow1 = startRow1 + ROW_PER_PAGE - 1;
				List<Review1> list1 = rd1.list(startRow1, endRow1); 
				int number1 = total1 - startRow1 + 1;
				int totalPage1 = (int)Math.ceil((double)total1/ROW_PER_PAGE);  	
				int startPage1 = currentPage1 - (currentPage1 - 1)%PAGE_PER_BLOCK;
				int endPage1 = startPage1 + PAGE_PER_BLOCK - 1;
				if (endPage1 > totalPage1) endPage1 = totalPage1;
				
				request.setAttribute("currentPage", currentPage);
				request.setAttribute("PAGE_PER_BLOCK", PAGE_PER_BLOCK);
				request.setAttribute("number", number);
				request.setAttribute("list", list);
				request.setAttribute("startPage", startPage);
				request.setAttribute("endPage", endPage);
				request.setAttribute("totalPage", totalPage);
				request.setAttribute("member", member);
				request.setAttribute("pageNum", pageNum);
				
				request.setAttribute("currentPage1", currentPage1);
				request.setAttribute("number1", number1);
				request.setAttribute("list1", list1);
				request.setAttribute("startPage1", startPage1);
				request.setAttribute("endPage1", endPage1);
				request.setAttribute("totalPage1", totalPage1);
				request.setAttribute("pageNum1", pageNum1);
				return "myreview.jsp";
			}else {
				MemberDao md = MemberDao.getInstance();
				Member member  = md.select(user_id);
				
				final int ROW_PER_PAGE = 10;     // ���������� 10����
				final int PAGE_PER_BLOCK = 10;   // �Ѻ��� 10������
				String pageNum = request.getParameter("pageNum");
				if (pageNum == null || pageNum.equals("")) pageNum = "1";
				int currentPage = Integer.parseInt(pageNum);
				ReviewDao rd = ReviewDao.getInstance();
				int total = rd.getMyTotal(user_id);  
				// ���۹�ȣ	(��������ȣ - 1) * �������� ����+ 1				
				int startRow = (currentPage - 1) * ROW_PER_PAGE + 1;
				// ����ȣ 	���۹�ȣ + �������簳�� - 1			
				int endRow = startRow + ROW_PER_PAGE - 1;
				List<Review> list = rd.Mylist(startRow, endRow,user_id); 
				// ��ȣ�� ���� ���� ���� 
				int number = total - startRow + 1;
				int totalPage = (int)Math.ceil((double)total/ROW_PER_PAGE);   // �� ������ ��
				// ����������	���������� - (���������� - 1)%10			
				int startPage = currentPage - (currentPage - 1)%PAGE_PER_BLOCK;
				// ��������	���������� + ��ϴ������� �� - 1
				int endPage = startPage + PAGE_PER_BLOCK - 1;
				// �� ���������� ū endPage���� �� ����
				if (endPage > totalPage) endPage = totalPage;
				
				String pageNum1 = request.getParameter("pageNum1");
				if (pageNum1 == null || pageNum1.equals("")) pageNum1 = "1";
				int currentPage1 = Integer.parseInt(pageNum1);
				Review1Dao rd1 = Review1Dao.getInstance();
				int total1 = rd1.getMyTotal(user_id);  			
				int startRow1 = (currentPage1 - 1) * ROW_PER_PAGE + 1;	
				int endRow1 = startRow1 + ROW_PER_PAGE - 1;
				List<Review1> list1 = rd1.Mylist(startRow1, endRow1, user_id); 
				int number1 = total1 - startRow1 + 1;
				int totalPage1 = (int)Math.ceil((double)total1/ROW_PER_PAGE);   // �� ������ ��		
				int startPage1 = currentPage1 - (currentPage1 - 1)%PAGE_PER_BLOCK;
				int endPage1 = startPage1 + PAGE_PER_BLOCK - 1;
				if (endPage1 > totalPage1) endPage1 = totalPage1;

				request.setAttribute("currentPage", currentPage);
				request.setAttribute("PAGE_PER_BLOCK", PAGE_PER_BLOCK);
				request.setAttribute("number", number);
				request.setAttribute("list", list);
				request.setAttribute("startPage", startPage);
				request.setAttribute("endPage", endPage);
				request.setAttribute("totalPage", totalPage);
				request.setAttribute("member", member);
				request.setAttribute("pageNum", pageNum);
				
				request.setAttribute("currentPage1", currentPage1);
				request.setAttribute("number1", number1);
				request.setAttribute("list1", list1);
				request.setAttribute("startPage1", startPage1);
				request.setAttribute("endPage1", endPage1);
				request.setAttribute("totalPage1", totalPage1);
				request.setAttribute("pageNum1", pageNum1);
				return "myreview.jsp";
			}
		}else {
			return "sessionChk.jsp";
		}
	}

}
