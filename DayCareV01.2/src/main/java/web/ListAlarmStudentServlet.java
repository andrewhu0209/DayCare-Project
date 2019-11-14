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

public class ListAlarmStudentServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 處理表單中文參數值的問題
		request.setCharacterEncoding("utf-8"); // 對post有效
		response.setContentType("text/html;charset=utf-8");
		
		Integer teacherId = null;
		try {
			teacherId = Integer.parseInt(request.getParameter("teacherId"));
		} catch (Exception e) {
				teacherId = 0;
		}


		StudentDAO dao = new StudentDAO();

		try {
			List<Student> students = dao.findAll();
			//先判斷老師 
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
			//再判斷疫苗
			List<Student> alarmStudents = new ArrayList<Student>();			
			for (int i = 0; i < students.size(); i++) {
				Student s = students.get(i);
				if(s.getHib6().equals("n")) {
					alarmStudents.add(s);
				}

			}

			request.setAttribute("alarmStudents", alarmStudents);
			request.setAttribute("teacherId", teacherId);
			RequestDispatcher rd = request.getRequestDispatcher("listAlarmStudent.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("系統繁忙，稍後重試");
		}
	}

}
