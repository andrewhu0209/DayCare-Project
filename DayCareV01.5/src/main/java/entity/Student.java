package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import dao.StudentDAO;

public class Student {
	private Integer studentId;
	private String name;
	private int age;
	private String parentsName;
	private String address;
	private String phone;
	private Integer teacherId;
	private String enrollDay;
	private String nextEnrollDay;
	private String enrollStatus;
	private String hib6;
	private String dtap6;
	private String dtap15;
	private String polio6;
	private String polio15;
	private String hepb6;
	private String mmr12;
	private String var12;
	
	public Student() {
		
	}
	
	
	public Student(int studentId, String name, int age, String parentsName, String address, String phone, int teacherId,
			String enrollDay, String nextEnrollDay, String enrollStatus, String hib6, String dtap6, String dtap15,
			String polio6, String polio15, String hepb6, String mmr12, String var12) throws ParseException {
		super();
		this.studentId = studentId;
		this.name = name;
		this.age = age;
		this.parentsName = parentsName;
		this.address = address;
		this.phone = phone;
		this.teacherId = teacherId;
		this.enrollDay = enrollDay;
		if(enrollDay!=null) {
			this.nextEnrollDay = plusOneYear(enrollDay);
		}
		else {
			this.nextEnrollDay = nextEnrollDay;
		}
		this.enrollStatus = enrollStatus;
		this.hib6 = hib6;
		this.dtap6 = dtap6;
		this.dtap15 = dtap15;
		this.polio6 = polio6;
		this.polio15 = polio15;
		this.hepb6 = hepb6;
		this.mmr12 = mmr12;
		this.var12 = var12;
	}
	
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getParentsName() {
		return parentsName;
	}
	public void setParentsName(String parentName) {
		this.parentsName = parentName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getEnrollDay() {
		return enrollDay;
	}
	public void setEnrollDay(String enrollDat) {
		this.enrollDay = enrollDat;
	}
	
	
	

	
	public String getNextEnrollDay() {
		return nextEnrollDay;
	}
	public void setNextEnrollDay(String nextEnrollDay) {
		this.nextEnrollDay = nextEnrollDay;
	}
	public String getEnrollStatus() {
		return enrollStatus;
	}
	public void setEnrollStatus(String enrollStatus) {
		this.enrollStatus = enrollStatus;
	}
	//疫苗
	public String getHib6() {
		return hib6;
	}
	public void setHib6(String hib6) {
		this.hib6 = hib6;
	}
	public String getDtap6() {
		return dtap6;
	}
	public void setDtap6(String dtap6) {
		this.dtap6 = dtap6;
	}
	public String getDtap15() {
		return dtap15;
	}
	public void setDtap15(String dtap15) {
		this.dtap15 = dtap15;
	}
	public String getPolio6() {
		return polio6;
	}
	public void setPolio6(String polio6) {
		this.polio6 = polio6;
	}
	public String getPolio15() {
		return polio15;
	}
	public void setPolio15(String polio15) {
		this.polio15 = polio15;
	}
	public String getHepb6() {
		return hepb6;
	}
	public void setHepb6(String hepb6) {
		this.hepb6 = hepb6;
	}
	public String getMmr12() {
		return mmr12;
	}
	public void setMmr12(String mmr12) {
		this.mmr12 = mmr12;
	}
	public String getVar12() {
		return var12;
	}
	public void setVar12(String var12) {
		this.var12 = var12;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", age=" + age + ", parentsName=" + parentsName
				+ ", address=" + address + ", phone=" + phone + ", teacherId=" + teacherId + ", enrollDay=" + enrollDay
				+ ", nextEnrollDay=" + nextEnrollDay + ", enrollStatus=" + enrollStatus + ", hib6=" + hib6 + ", dtap6="
				+ dtap6 + ", dtap15=" + dtap15 + ", polio6=" + polio6 + ", polio15=" + polio15 + ", hepb6=" + hepb6
				+ ", mmr12=" + mmr12 + ", var12=" + var12 + "]";
	}
	
	public static List<Student> getImmuFail() throws Exception{
		  StudentDAO dao = new StudentDAO();
		  List<Student> students = dao.findAll();
		  List<Student> f = new ArrayList<Student>();
		  
		  for (Student s : students) {
		   int age = s.getAge();
		   if ((s.getDtap6().equals("n")||s.getPolio6() .equals("n")||s.getHepb6().equals("n")||s.getHib6().equals("n") ) && age < 12) {
		    f.add(s);
		   }else if (age >= 12 && age < 15 && (s.getMmr12().equals("n") || s.getVar12().equals("n"))) {
		    f.add(s);
		   }else if (age >= 15 && (s.getDtap15().equals("n") || s.getPolio15().equals("n"))) {
		    f.add(s);
		   }
		  }
		  return f;
		 }
	
	public static String plusOneYear(String d) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(d);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, 1);
		date = cal.getTime();
		return sdf.format(date).toString();
	}

}
