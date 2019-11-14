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

import dao.StudentDAO;
import entity.Student;

public class ListStudentServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 處理表單中文參數值的問題
		request.setCharacterEncoding("utf-8"); //對post有效
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		Integer teacherId = Integer.parseInt(request.getParameter("teacherId"));

		

		//查詢出所有用戶的信息
		StudentDAO dao = new StudentDAO();
		try {
			List<Student> students = dao.findAll();
			//判斷老師ID
			if(teacherId!=0) {
				List<Student> sTemp = new ArrayList<Student>();
				for(int i=0;i<students.size();i++) {
					Student s = students.get(i);
					if(s.getTeacherId()==teacherId) {
						sTemp.add(s);
					}
				}
				students = sTemp;
		
			}

			request.setAttribute("students", students);
			request.setAttribute("teacherId", teacherId);
			RequestDispatcher rd = request.getRequestDispatcher("listStudent.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("We encounter some problems. Please Try Agian!");
		}
	}
	

}
