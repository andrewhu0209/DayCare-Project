package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Teacher;
import entity.User;
import util.DBUtils;

public class TeacherDAO {
	public List<Teacher> findAll() throws Exception{
		List<Teacher> teachers = new ArrayList<Teacher>();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql="select * from Teacher";
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			
			while(rs.next()) {
				
				int teacherId = rs.getInt("teacherId");
				String name = rs.getString("teacherName");
							
				Teacher teacher = new Teacher();
				teacher.setTeacherId(teacherId);
				teacher.setName(name);
				
				teachers.add(teacher);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, rs);
		}
		return teachers;
	}

}
