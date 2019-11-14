package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import entity.User;
import util.DBUtils;

public class LoginServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		request.setCharacterEncoding("utf-8"); //對post有效
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 讀取用戶信息 如果回傳是null代表打錯或沒有這個東西 如果是""空字符串，代表對方沒打東西
		String username =  request.getParameter("username");
		String pwd = request.getParameter("pwd");
	
		if(username == null || pwd == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		UserDAO dao = new UserDAO();	
		try {	
			int teacherId = dao.login(username, pwd);
			if(teacherId == -1) {
				request.setAttribute("msg", "User Not Exist!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("teacherId", teacherId);
				response.sendRedirect("listTeacher");
			}		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("We encounter some problems. Please Try Agian!");
		}

	}

}
