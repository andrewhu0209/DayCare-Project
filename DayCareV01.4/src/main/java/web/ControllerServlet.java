package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StudentDAO;
import dao.TeacherDAO;
import dao.UserDAO;
import entity.Student;
import entity.Teacher;

public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"), uri.lastIndexOf("."));
		//System.out.println("path:" + path);

		if ("/login".equals(path)) {
			// 處理登入請求
			processLogin(request, response);
		} else if ("/teacherList".equals(path)) {
			processTeacherList(request, response);
		} else if ("/studentList".equals(path)) {
			processStudentList(request, response);
		} else if ("/immuStudentList".equals(path)) {
			processImmuStudentList(request, response);
		}else if("/immuStudentNotYetList".equals(path)) {
			processImmuStudentNotYetList(request, response);
		}

	}

	
	
	
	
	
	
	private void processImmuStudentNotYetList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 檢查session 沒有session重定向到login
				HttpSession session = request.getSession();
				Object obj = session.getAttribute("teacherId");
				if (obj == null) {
					// 沒有登入，重定向到登入頁面
					response.sendRedirect("login.jsp");
					// 沒有必須向下執行
					return;
				}
				Integer teacherId = Integer.parseInt(request.getParameter("teacherId"));
				request.setCharacterEncoding("utf-8"); // 對post有效
				response.setContentType("text/html;charset=utf-8");
				PrintWriter out = response.getWriter();

			
				try {
					//獲取疫苗沒打的學生資料
					List<Student> students = Student.getImmuFail();

					if (teacherId != 0) {
						List<Student> sTemp = new ArrayList<Student>();
						for (int i = 0; i < students.size(); i++) {
							Student s = students.get(i);
							if (s.getTeacherId() == teacherId) {
								sTemp.add(s);
							}
						}
						students = sTemp;
					}
					request.setAttribute("students", students);
					request.setAttribute("teacherId", teacherId);

					RequestDispatcher rd = request.getRequestDispatcher("listImmuStudent.jsp");
					rd.forward(request, response);
					
				} catch (Exception e) {
					out.println("We encounter some problems. Please Try Agian!");
					e.printStackTrace();
				}
		
	}







	private void processImmuStudentList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 檢查session 沒有session重定向到login
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("teacherId");
		if (obj == null) {
			// 沒有登入，重定向到登入頁面
			response.sendRedirect("login.jsp");
			// 沒有必須向下執行
			return;
		}
		Integer teacherId = Integer.parseInt(request.getParameter("teacherId"));
		request.setCharacterEncoding("utf-8"); // 對post有效
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		StudentDAO dao = new StudentDAO();
		try {
			List<Student> students = dao.findAll();
			// 判斷老師ID
			if (teacherId != 0) {
				List<Student> sTemp = new ArrayList<Student>();
				for (int i = 0; i < students.size(); i++) {
					Student s = students.get(i);
					if (s.getTeacherId() == teacherId) {
						sTemp.add(s);
					}
				}
				students = sTemp;
			}
			request.setAttribute("students", students);
			request.setAttribute("teacherId", teacherId);

			RequestDispatcher rd = request.getRequestDispatcher("listImmuStudent.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			out.println("We encounter some problems. Please Try Agian!");
			e.printStackTrace();
		}

	}

	
	
	private void processStudentList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 處理表單中文參數值的問題
		request.setCharacterEncoding("utf-8"); // 對post有效
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		Integer teacherId = Integer.parseInt(request.getParameter("teacherId"));

		// 查詢出所有用戶的信息
		StudentDAO dao = new StudentDAO();
		try {
			List<Student> students = dao.findAll();
			// 判斷老師ID
			if (teacherId != 0) {
				List<Student> sTemp = new ArrayList<Student>();
				for (int i = 0; i < students.size(); i++) {
					Student s = students.get(i);
					if (s.getTeacherId() == teacherId) {
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

	
	
	private void processTeacherList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 檢查session 沒有session重定向到login
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("teacherId");
		if (obj == null) {
			// 沒有登入，重定向到登入頁面
			response.sendRedirect("login.jsp");
			// 沒有必須向下執行
			return;
		}

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		Integer teacherId = (Integer) obj;
		// 查詢出所有teacher的信息
		TeacherDAO dao = new TeacherDAO();
		try {
			List<Teacher> teachers = dao.findAll();
			if (teacherId != 0) {
				List<Teacher> temp = new ArrayList<Teacher>();
				for (Teacher t : teachers) {
					if (t.getTeacherId() == teacherId) {
						temp.add(t);
					}
				}
				teachers = temp;
			}
			// 把teachers轉發給 listTeacher.jsp
			if (teacherId == 0) {
				request.setAttribute("teachers", teachers);
				RequestDispatcher rd = request.getRequestDispatcher("listTeacherRoot.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("teachers", teachers);
				RequestDispatcher rd = request.getRequestDispatcher("listTeacher.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			out.println("We encounter some problems. Please Try Agian!");
		}

	}

	
	
	private void processLogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		request.setCharacterEncoding("utf-8"); // 對post有效
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		// 讀取用戶信息 如果回傳是null代表打錯或沒有這個東西 如果是""空字符串，代表對方沒打東西
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");

		if (username == null || pwd == null) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}

		UserDAO dao = new UserDAO();
		try {
			int teacherId = dao.login(username, pwd);
			if (teacherId == -1) {
				request.setAttribute("msg", "User Not Exist!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("teacherId", teacherId);
				response.sendRedirect("teacherList.do");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("We encounter some problems. Please Try Agian!");
		}

	}

}
