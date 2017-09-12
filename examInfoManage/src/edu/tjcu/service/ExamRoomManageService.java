package edu.tjcu.service;

import java.util.List;

import edu.tjcu.dao.ExamRoomManageDao;
import edu.tjcu.entities.ExamRoom;

public class ExamRoomManageService {
	private ExamRoomManageDao examRoomManageDao;

	public ExamRoomManageDao getExamRoomManageDao() {
		return examRoomManageDao;
	}

	public void setExamRoomManageDao(ExamRoomManageDao examRoomManageDao) {
		this.examRoomManageDao = examRoomManageDao;
	}

	public List<ExamRoom> queryAll() {
		// TODO Auto-generated method stub
		return examRoomManageDao.queryAll();
	}

	public void addExamRoom(ExamRoom examRoom) {
		// TODO Auto-generated method stub
		examRoomManageDao.addExamRoom(examRoom);
	}

	public List<ExamRoom> query(Integer examRoomNumInt, String examRoomName) {
		// TODO Auto-generated method stub
		return examRoomManageDao.query(examRoomNumInt,examRoomName);
	}

	public void delete(Integer examRoomId) {
		// TODO Auto-generated method stub
		examRoomManageDao.delete(examRoomId);
	}

	public void update(Integer examRoomId, Integer examRoomNum, String examRoomName, Integer accommodateNum) {
		// TODO Auto-generated method stub
		examRoomManageDao.update(examRoomId,examRoomNum,examRoomName,accommodateNum);
	}
}
