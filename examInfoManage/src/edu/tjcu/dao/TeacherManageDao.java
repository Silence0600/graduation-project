package edu.tjcu.dao;

import java.util.List;

import org.hibernate.Query;

import edu.tjcu.entities.ExamRoom;
import edu.tjcu.entities.Teacher;

public class TeacherManageDao extends BaseDao{
	public List<Teacher> queryAllTeacher() {
		// TODO Auto-generated method stub
		String hql = "from Teacher";
		Query query = getSession().createQuery(hql);
		List<Teacher> teachers = query.list();
		return teachers;
	}

	public List<Teacher> query(Integer teacherNum, String teacherName) {
		String hql = "from Teacher where teacherNum = ? or teacherName=?";
		Query q = getSession().createQuery(hql);
		q.setParameter(0, teacherNum);
		q.setParameter(1,teacherName);
		List<Teacher> Teacher = q.list();
		return Teacher;
	}

	public void saveTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		getSession().save(teacher);
	}

	public void updateTeacher(Teacher teacher) {
		String hql = "update Teacher set teacherNum=?,teacherName=?,age=?,sex=? where teacherId = ?";
		Query q = getSession().createQuery(hql);
		q.setParameter(0, teacher.getTeacherNum());
		q.setParameter(1,teacher.getTeacherName());
		q.setParameter(2,teacher.getAge());
		q.setParameter(3,teacher.getSex());
		q.setParameter(4,teacher.getTeacherId());
		//返回值为1,执行成功
		int ret=q.executeUpdate();
	}

	public void deleteTeacher(Integer teacherId) {
		// TODO Auto-generated method stub
		Teacher teacher = new Teacher();
		teacher.setTeacherId(teacherId);
		getSession().delete(teacher);
		
	}	
}
