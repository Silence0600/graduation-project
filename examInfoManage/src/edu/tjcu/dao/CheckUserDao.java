package edu.tjcu.dao;

import java.util.List;

import org.hibernate.Query;

import edu.tjcu.entities.Admin;
import edu.tjcu.entities.Student;
import edu.tjcu.entities.Teacher;
import edu.tjcu.entities.User;

public class CheckUserDao extends BaseDao {
//通过账号查询User 对象
	public User get(String accNub) {
		
		String hql = "from User where accNub = ?";
		Query q = getSession().createQuery(hql);
		q.setParameter(0, accNub);
		List<User> user = q.list();
		if (user.size() == 0) {
			return new User();
		}
		return user.get(0);
	}

	public List<Teacher> getTeacherByAccNum(Integer accNum) {
		String hql = "from Teacher where teacherNum = ?";
		Query q = getSession().createQuery(hql);
		q.setParameter(0,accNum);
		List<Teacher> teachers= q.list();
		return teachers;
	}

	public List<Admin> getAdminsByAccNum(String accNum) {
		// TODO Auto-generated method stub
		String hql = "from Admin where accNum = ?";
		Query q = getSession().createQuery(hql);
		q.setParameter(0,accNum);
		List<Admin> admins= q.list();
		return admins;
		
		
	}

	public List<Student> getStudentByStuNum(Integer stuNum) {
		String hql = "from Student where studentNub = ?";
		Query q = getSession().createQuery(hql);
		q.setParameter(0,stuNum);
		List<Student> students= q.list();
		return students;
	}
}
