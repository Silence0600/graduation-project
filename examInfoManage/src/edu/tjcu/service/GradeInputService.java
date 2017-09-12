package edu.tjcu.service;

import java.util.ArrayList;
import java.util.List;

import edu.tjcu.dao.GradeInputDao;
import edu.tjcu.entities.Course;
import edu.tjcu.entities.Grade;
import edu.tjcu.entities.Student;

public class GradeInputService {
	private GradeInputDao gradeInputDao;

	
	public GradeInputDao getGradeInputDao() {
		return gradeInputDao;
	}


	public void setGradeInputDao(GradeInputDao gradeInputDao) {
		this.gradeInputDao = gradeInputDao;
	}


	public List<Course> getCourses(Integer teacherId){
		return gradeInputDao.getCourses(teacherId);
	}


	public ArrayList<Student> getStudents(Integer taeId, String course) {
		// TODO Auto-generated method stub
		return gradeInputDao.getStudents(taeId,course);
	}
	public Course getCourse(Integer taeId, String course){
		return gradeInputDao.getCourse(taeId, course);
	}


	public void saveGrade(Grade grade) {
		// TODO Auto-generated method stub
		gradeInputDao.saveGrade(grade);
	}
}
