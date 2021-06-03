package jsp_project.controller;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.HashMap;

import java.util.Iterator;

import java.util.Map;

import java.util.Properties;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletConfig;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebInitParam;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

 

import jsp_project.service.CommandProcess; 

@WebServlet(urlPatterns="*.do",	

	initParams={@WebInitParam(name="config",value="/WEB-INF/command.properties")})

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Map<String, Object> commandMap = new HashMap<>();

	public void init(ServletConfig config) throws ServletException { 

	   	String props = config.getInitParameter("config");

	   	// props : "/WEB-INF/command.properties"

	   	Properties pr = new Properties();

	   	// Java 11�� PropertiesŬ������ Ư¡ Ű=���� ���� Map�� ����

	    FileInputStream f = null;

	    try {

	          String configFilePath = 

	         		config.getServletContext().getRealPath(props);

	          // configFilePath ���� ����� ��ġ�� �ִ� �̸�

	          f = new FileInputStream(configFilePath);

	          pr.load(f);

	          // pr���� command.properties��� file�� �����͸� ���

	          // =�տ� �ִ� message.do�� key

	          // =�ڿ� �ִ� ch13.service.Message�� ��

	    } catch (IOException e) { throw new ServletException(e);

	     } finally {

	          if (f != null) try { f.close(); } catch(IOException ex) {}

	     }

	     Iterator<Object> keyIter = pr.keySet().iterator();

	     // message.do, color.do

	     while( keyIter.hasNext() ) {

	          String command = (String)keyIter.next(); 

	          // command : message.do

	          String className = pr.getProperty(command); 

	          // className : ch13.service.Message����

	          try {

	               Class<?> commandClass = Class.forName(className);

	               // commandClass : service.Message Ŭ����

	               Object commandInstance = commandClass.newInstance();

	               // commandInstance : service.Message��ü

	               commandMap.put(command, commandInstance);

	               // commnadMap����

	               // key�� message.do

	               // ���� Message��ü

	          } catch (Exception e) {

	               throw new ServletException(e);

	          }

	     }

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)

	    throws ServletException, IOException {

		String view = null;

	    CommandProcess com=null;

	    try { 

	    	  String command = request.getRequestURI();

	    	  // command : /ch13/message.do

	    	  // request.getContextPath() : /ch13

	    	  // request.getContextPath().length()+1 : 6

		      command = command.substring(
 
		    		 request.getContextPath().length()+1); 

		      // command : message.do

	          com = (CommandProcess)commandMap.get(command); 

	          // com : service.Message��ü�� CommandProcess�� ����ȯ

	          // �ڽ� �� Message��ü�� requestPro()�޼ҵ� ����

	          view = com.requestPro(request, response);

	          // view�� "message.jsp" ����

	    } catch(Throwable e) { throw new ServletException(e); } 

	    RequestDispatcher dispatcher =

	      	request.getRequestDispatcher(view);

	   dispatcher.forward(request, response);

	}
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)

	    throws ServletException, IOException {

    		request.setCharacterEncoding("utf-8");

    		doGet(request, response);

	}

}