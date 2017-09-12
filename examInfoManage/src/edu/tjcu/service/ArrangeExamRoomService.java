package edu.tjcu.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.tjcu.dao.ArrangeExamRoomDao;
import edu.tjcu.entities.ClassAndStuNum;
import edu.tjcu.entities.Course;
import edu.tjcu.entities.ExamRoom;
import edu.tjcu.entities.ExamRoomTime;

public class ArrangeExamRoomService {
	private ArrangeExamRoomDao arrangeExamRoomDao;
	public ArrangeExamRoomDao getArrangeExamRoomDao() {
		return arrangeExamRoomDao;
	}
	public void setArrangeExamRoomDao(ArrangeExamRoomDao arrangeExamRoomDao) {
		this.arrangeExamRoomDao = arrangeExamRoomDao;
	}
	
	public void save(ExamRoomTime ert) {
		arrangeExamRoomDao.save(ert);
	}
	public int queryStudentNum(Integer teacherId, String course) {
		
		return arrangeExamRoomDao.queryStudentNum(teacherId,course);
	}
	public List getAccList(Date date) {
		// TODO Auto-generated method stub
		return arrangeExamRoomDao.getAccList(date);
	}
	public List getGoodExamRoom(ArrayList<Integer> goodRoomComb) {
		// TODO Auto-generated method stub
		return arrangeExamRoomDao.getGoodExamRoom(goodRoomComb);
	}
	public void insertExamRoomTome(ExamRoomTime ert) {
		// TODO Auto-generated method stub
		arrangeExamRoomDao.insertExamRoomTome(ert);
	}
	public List<Course> getCourses(Integer teacherId) {
		// TODO Auto-generated method stub
		return arrangeExamRoomDao.getCourses(teacherId);
	}
	public Course getCourse(Integer teacherId, String courName) {
		// TODO Auto-generated method stub
		return arrangeExamRoomDao.getCourse(teacherId, courName);
	}
	public ArrayList<ExamRoomTime> getCurrentScheduleList(Integer teacherId, Date date) {
		// TODO Auto-generated method stub
		return arrangeExamRoomDao.getCurrentScheduleList(teacherId, date);
	}
	public ArrayList queryClassAndStuNum(Integer teacherId, String course) {
		return arrangeExamRoomDao.queryClassAndStuNum(teacherId, course);
	}
	public ExamRoom getExamRoom(List<Integer> examRoomIds, Integer stuNum) {
		// TODO Auto-generated method stub
		return arrangeExamRoomDao.getExamRoom(examRoomIds,stuNum);
	}
}
