package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import entity.Student;

/**
 * Servlet implementation class ListImmuStudentServlet
 */
public class ListImmuStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //對post有效
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		StudentDAO dao = new StudentDAO();
		try {
			List<Student> students = dao.findAll();
			request.setAttribute("students", students);
			//wait for the jsp
			RequestDispatcher rd = request.getRequestDispatcher("listImmuStudent.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			out.println("We encounter some problems. Please Try Agian!");
			e.printStackTrace();
		}
		
	}

}
