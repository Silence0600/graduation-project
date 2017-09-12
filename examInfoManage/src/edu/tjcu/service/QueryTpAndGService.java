package edu.tjcu.service;

import java.util.List;

import edu.tjcu.dao.QueryTpAndGDao;
import edu.tjcu.entities.Grade;
import edu.tjcu.entities.Student;
import edu.tjcu.entities.Teacher;

public class QueryTpAndGService {
	private QueryTpAndGDao queryTpAndGDao;

	public QueryTpAndGDao getQueryTpAndGDao() {
		return queryTpAndGDao;
	}

	public void setQueryTpAndGDao(QueryTpAndGDao queryTpAndGDao) {
		this.queryTpAndGDao = queryTpAndGDao;
	}

	public List queryTp(String gjz) {
		return queryTpAndGDao.queryTp(gjz);
		// TODO Auto-generated method stub
		
	}

	public List queryGrade(Integer studentNum) {
		// TODO Auto-generated method stub
		
		return queryTpAndGDao.queryGrade(studentNum);
	}

	public List queryAllTp() {
		
		return queryTpAndGDao.queryAllTp();
	}

	public Student getStudent(Integer studentId) {
		// TODO Auto-generated method stub
		return queryTpAndGDao.getStudnent(studentId);
	}

	public List queryMyTp(String clazz) {
		// TODO Auto-generated method stub
		return queryTpAndGDao.queryMyTp(clazz);
	}

	public List queryMyGrade(Integer studentId) {
		
		return queryTpAndGDao.queryMyGrade(studentId);
	}

	public List getTeacherTPList(String teacherName) {
		// TODO Auto-generated method stub
		return queryTpAndGDao.getTeacherTPList(teacherName);
	}

	public Teacher getTeacherById(Integer teacherId) {
		
		return queryTpAndGDao.getTeacherById(teacherId);
	}

	public List getTeacherTPList2(String teacherName) {
		// TODO Auto-generated method stub
		return queryTpAndGDao.getTeacherTPList2(teacherName);
	}

}
