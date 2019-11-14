package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TeacherDAO;
import entity.Teacher;

public class ListTeacherServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 處理表單中文參數值的問題
		request.setCharacterEncoding("utf-8"); //對post有效
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//檢查session 沒有session重定向到login
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("teacherId");
		if(obj == null){
			//沒有登入，重定向到登入頁面
			response.sendRedirect("login.jsp");
			//沒有必須向下執行
			return;
		}
			
		Integer teacherId = (Integer) obj;
		//查詢出所有teacher的信息
		TeacherDAO dao = new TeacherDAO();
		try {
			List<Teacher> teachers = dao.findAll();	
			if(teacherId != 0) {
				List<Teacher> temp = new ArrayList<Teacher>();
				for(Teacher t : teachers) {	
					if(t.getTeacherId()==teacherId) {
						temp.add(t);
					}
				}
				teachers = temp;			
			}
			//把teachers轉發給 listTeacher.jsp
			if(teacherId == 0) {		
				request.setAttribute("teachers", teachers);
				RequestDispatcher rd = request.getRequestDispatcher("listTeacherRoot.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("teachers", teachers);
				RequestDispatcher rd = request.getRequestDispatcher("listTeacher.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.println("We encounter some problems. Please Try Agian!");
		}
	}
	

}
