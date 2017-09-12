package edu.tjcu.service;

import java.util.List;

import edu.tjcu.dao.TeacherManageDao;
import edu.tjcu.entities.ExamRoom;
import edu.tjcu.entities.Teacher;

public class TeacherManageService {
	private TeacherManageDao teacherManageDao;

	public TeacherManageDao getTeacherManageDao() {
		return teacherManageDao;
	}

	public void setTeacherManageDao(TeacherManageDao teacherManageDao) {
		this.teacherManageDao = teacherManageDao;
	}

	public List<Teacher> queryAllTeacher() {		
		return teacherManageDao.queryAllTeacher();
	}

	public List<Teacher> query(Integer teacherNum, String teacherName) {
		// TODO Auto-generated method stub
		return teacherManageDao.query(teacherNum,teacherName);
	}

	public void saveTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherManageDao.saveTeacher(teacher);
	}

	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		teacherManageDao.updateTeacher(teacher);
	}

	public void deleteTeacherById(Integer teacherId) {
		// TODO Auto-generated method stub
		teacherManageDao.deleteTeacher(teacherId);
	}
	
}
