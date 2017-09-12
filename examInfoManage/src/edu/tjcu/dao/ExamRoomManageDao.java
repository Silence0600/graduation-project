package edu.tjcu.dao;

import java.util.List;

import org.hibernate.Query;

import edu.tjcu.entities.ExamRoom;

public class ExamRoomManageDao extends BaseDao{

	public List<ExamRoom> queryAll() {
		// TODO Auto-generated method stub
		String hql = "from ExamRoom";
		Query q = getSession().createQuery(hql);
		List<ExamRoom> examRooms = q.list();
		return examRooms;
	}

	public void addExamRoom(ExamRoom examRoom) {
		// TODO Auto-generated method stub
		getSession().save(examRoom);
	}

	public List<ExamRoom> query(Integer examRoomNumInt, String examRoomName) {
		// TODO Auto-generated method stub
		String hql = "from ExamRoom where examRoomNum = ? or examRoomName=?";
		Query q = getSession().createQuery(hql);
		q.setParameter(0, examRoomNumInt);
		q.setParameter(1,examRoomName);
		List<ExamRoom> examRooms = q.list();
		return examRooms;
	}

	public void delete(Integer examRoomId) {
		// TODO Auto-generated method stub
		ExamRoom examRoom = new ExamRoom();
		examRoom.setExamRoomId(examRoomId);
		getSession().delete(examRoom);
	}

	public void update(Integer examRoomId, Integer examRoomNum, String examRoomName, Integer accommodateNum) {
		// TODO Auto-generated method stub
		String hql = "update ExamRoom set examRoomNum=?,examRoomName=?,accommodateNum=? where examRoomId = ?";
		Query q = getSession().createQuery(hql);
		q.setParameter(0, examRoomNum);
		q.setParameter(1,examRoomName);
		q.setParameter(2,accommodateNum);
		q.setParameter(3,examRoomId);
		//返回值为1,执行成功
		int ret=q.executeUpdate();
		System.out.println(ret);
	}

}
