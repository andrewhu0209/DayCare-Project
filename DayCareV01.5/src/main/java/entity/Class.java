package entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dao.ClassDAO;
import dao.TeacherDAO;

public class Class {
	private int classId;
	private int C_capacity;
	private int C_maxCapacity;
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public int getC_capacity() {
		return C_capacity;
	}
	public void setC_capacity(int c_capacity) {
		C_capacity = c_capacity;
	}
	public int getC_maxCapacity() {
		return C_maxCapacity;
	}
	public void setC_maxCapacity(int c_maxCapacity) {
		C_maxCapacity = c_maxCapacity;
	}
	@Override
	public String toString() {
		return "Class [classId=" + classId + ", C_capacity=" + C_capacity + ", C_maxCapacity=" + C_maxCapacity + "]";
	}
	
	public static void resetAssignClassRoom() throws Exception {
		TeacherDAO tDao = new TeacherDAO();
		List<Teacher> teachers = tDao.findAll();
		for (Teacher t : teachers) {
			tDao.resetClassRoom(t);
		}
		ClassDAO cDao = new ClassDAO();
		List<entity.Class> cla = cDao.findAll();
		for (entity.Class c : cla) {
			cDao.resetCapacity(c);
		}
		
	}
	
	public static List<entity.Class> assignClass() throws Exception{
		TeacherDAO teaDao = new TeacherDAO();
		ClassDAO classDao = new ClassDAO();
		List<Teacher> tea = new LinkedList<Teacher>();
		List<entity.Class> c = new ArrayList<entity.Class>();
		c = classDao.findAll();
		tea = teaDao.findAll();
		
		//遍历老师，将老师分配给班级。分配标准：
		//1. 每个老师都固定了grade，根据grade分配
		//2. 动态增加每个班当前capacity
		for (entity.Class	class1: c) {
			int capacity = class1.getC_capacity();
			int maxCapacity = class1.getC_maxCapacity();
			int classId = class1.getClassId();
			
			for (Teacher teacher: tea) {
				int grade = teacher.getGrade();
				
				//当前老师已经被分配
				if(teacher.getClassRoom() != 0) {
					continue;
				}
				
				//当前课堂人数已经满了
				if(class1.getC_capacity() > class1.getC_maxCapacity()) {
					break;
				}
				

				//将班级id设置为老师的classroom,实现将老师分配给班级
				if(grade == 1 && capacity < maxCapacity) {
					teacher.setClassRoom(classId);
					capacity++;
					break;
				}else if(grade == 2 && capacity < maxCapacity) {
					teacher.setClassRoom(classId);
					capacity++;
					break;
				}else if(grade == 3 && capacity < maxCapacity) {
					teacher.setClassRoom(classId);
					capacity++;
					break;
				}else if(grade == 4 && capacity < maxCapacity) {
					teacher.setClassRoom(classId);
					capacity++;
					break;
				}else if(grade == 5 && capacity < maxCapacity) {
					teacher.setClassRoom(classId);
					capacity++;
					break;
				}else if(grade == 6 && capacity < maxCapacity) {
					teacher.setClassRoom(classId);
					capacity++;
					break;
				}
			}
		}
		
		//save teacher data
		for(Teacher t : tea) {
			teaDao.updateClassRoom(t);
		}
		//save class data
		for(entity.Class x : c) {
			classDao.updateCapacity(x);
		}
		
		return c;
		
	}
	
	
	
}
