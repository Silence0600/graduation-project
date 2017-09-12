package edu.tjcu.service;

import java.util.List;
import edu.tjcu.dao.StudentManageDao;
import edu.tjcu.entities.Student;
public class StudentManageService {
	private StudentManageDao studentManageDao;
	public StudentManageDao getStudentManageDao() {
		return studentManageDao;
	}
	public void setStudentManageDao(StudentManageDao studentManageDao) {
		this.studentManageDao = studentManageDao;
	}
	
	public List<Student> queryAllStudent() {
		
		return studentManageDao.queryAllStudents();
	}
	public List<Student> queryStudent(Integer studentNum) {
		// TODO Auto-generated method stub
		return studentManageDao.queryStudent(studentNum);
	}
	public void saveStudent(Student student) {
		studentManageDao.saveStudent(student);
	}
	public void deleteStudentById(Integer studentId) {
		studentManageDao.deleteStudentById(studentId);
		
	}
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		studentManageDao.updateStudent(student);
	}
	
}
