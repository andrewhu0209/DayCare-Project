package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Student;
import util.DBUtils;

public class StudentDAO {
	public List<Student> findAll() throws Exception{
		
		List<Student> Students = new ArrayList<Student>();
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConn();
			String sql="select * from Student";
			stat = conn.prepareStatement(sql);
			rs = stat.executeQuery();
			while(rs.next()) {
				
				int studentId = rs.getInt("studentId");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String parentsName = rs.getString("parentsName");
				String address = rs.getString("address");
				String phone= rs.getString("phone");
				int teacherId= rs.getInt("teacherId");
				String enrollDay= rs.getString("enrollDay");
				String hib6= rs.getString("Hib6");
				
				Student student = new Student();
				
				student.setStudentId(studentId);
				student.setName(name);
				student.setAge(age);
				student.setParentsName(parentsName);
				student.setAddress(address);
				student.setPhone(phone);
				student.setTeacherId(teacherId);
				student.setEnrollDay(enrollDay);
				
				student.setEnrollStatus(rs.getString("enrollStatus"));
				student.setNextEnrollDay(rs.getString("nextenrollDay"));
				
				student.setHib6(hib6);		
				student.setDtap6(rs.getString("Dtap6"));
				student.setDtap15(rs.getString("Dtap15"));
				student.setPolio6(rs.getString("Polio6"));
				student.setPolio15(rs.getString("Polio15"));
				student.setHepb6(rs.getString("Hepb6"));
				student.setMmr12(rs.getString("Mmr12"));
				student.setVar12(rs.getString("Var12"));
				
				Students.add(student);

				
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			DBUtils.close(conn, stat, rs);
		}
		return Students;
	}

}
