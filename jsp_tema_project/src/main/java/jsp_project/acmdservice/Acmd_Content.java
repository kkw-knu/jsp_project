package jsp_project.acmdservice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp_project.dao.AcmdDao;
import jsp_project.dao.Review1Dao;
import jsp_project.model.Acmd;
import jsp_project.model.Review1;
import jsp_project.service.CommandProcess;

public class Acmd_Content implements CommandProcess {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) {
		final int ROW_PER_PAGE = 10;     // ���������� 10����
		final int PAGE_PER_BLOCK = 10;   // �Ѻ��� 10������
		String pageNum1 = request.getParameter("pageNum1");
		String pageNum = request.getParameter("pageNum");
		int acmd_num = Integer.parseInt(request.getParameter("acmd_num"));
		AcmdDao ad = AcmdDao.getInstance();
		Acmd acmd = ad.select(acmd_num);
		if (pageNum1 == null || pageNum1.equals("")) pageNum1 = "1";
		int currentPage1 = Integer.parseInt(pageNum1);
		Review1Dao rd = Review1Dao.getInstance();
		int total1 = rd.getTotal(acmd.getAcmd_name());  
		// ���۹�ȣ	(��������ȣ - 1) * �������� ����+ 1				
		int startRow1 = (currentPage1 - 1) * ROW_PER_PAGE + 1;
		// ����ȣ 	���۹�ȣ + �������簳�� - 1			
		int endRow1 = startRow1 + ROW_PER_PAGE - 1;
		List<Review1> list = rd.search(startRow1, endRow1, acmd.getAcmd_name()); 
		// ��ȣ�� ���� ���� ���� 
		int number1 = total1 - startRow1 + 1;
		int totalPage1 = (int)Math.ceil((double)total1/ROW_PER_PAGE);   // �� ������ ��
		// ����������	���������� - (���������� - 1)%10			
		int startPage1 = currentPage1 - (currentPage1 - 1)%PAGE_PER_BLOCK;
		// ��������	���������� + ��ϴ������� �� - 1
		int endPage1 = startPage1 + PAGE_PER_BLOCK - 1;
		// �� ���������� ū endPage���� �� ����
		if (endPage1 > totalPage1) endPage1 = totalPage1;
		
		request.setAttribute("currentPage1", currentPage1);
		request.setAttribute("PAGE_PER_BLOCK", PAGE_PER_BLOCK);
		request.setAttribute("number1", number1);
		request.setAttribute("list", list);
		request.setAttribute("startPage1", startPage1);
		request.setAttribute("endPage1", endPage1);
		request.setAttribute("totalPage1", totalPage1);
		
		
		request.setAttribute("acmd_num", acmd_num); 
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("acmd", acmd);
		return "acmd_content.jsp";
	}

}
