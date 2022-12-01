package com.addrbook.controller;

import java.io.*;
import java.util.ArrayList;
import com.addrbook.model.*;
import com.addrbook.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addrbook_control
 */
@WebServlet("*.do")
public class Addrbook_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Addrbook_servlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
		
		actionDo(request,response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		if(command.equals("/insert.do")) {
			System.out.println("insert 진입");
			
			AddrDto dto = new AddrDto();
			dto.setAb_name(request.getParameter("ab_name"));
			dto.setAb_email(request.getParameter("ab_email"));
			dto.setAb_comdept(request.getParameter("ab_comdept"));
			dto.setAb_birth(request.getParameter("ab_birth"));
			dto.setAb_tel(request.getParameter("ab_tel"));
			dto.setAb_memo(request.getParameter("ab_memo"));
			
			request.setAttribute("dto", dto);
//			InsertService insertService = new InsertServicempl();
//			insertService.execute(request, response);
			AddrDao dao = new AddrDao();
			if (dao.insertDB(dto)) {
				response.sendRedirect("list.do");				
			}
			
		}else if(command.equals("/list.do")){
			System.out.println("리스트 진입");
			AddrDao dao = new AddrDao();
			request.setAttribute("datas", dao.getDBList());
			RequestDispatcher rd = request.getRequestDispatcher("addrbook/addrbook_list.jsp");
			rd.forward(request, response);
		}else if(command.equals("/edit.do")) {
			System.out.println("edit 진입");
			AddrDao dao = new AddrDao();
			AddrDto dto = new AddrDto();
			dto = dao.getDB(dto.getAb_id());
			PrintWriter out = response.getWriter();
			if(!request.getParameter("upasswd").equals("1234")){
				out.println("<script>alert('비밀번호가 틀렸습니다.!!'); history.go(-1);</script>");
			}else{
				request.setAttribute("dto", dto);
				RequestDispatcher rd = request.getRequestDispatcher("addrbook/addrbook_edit_form.jsp");
				rd.forward(request, response);
			}
			
		}
	}
}
