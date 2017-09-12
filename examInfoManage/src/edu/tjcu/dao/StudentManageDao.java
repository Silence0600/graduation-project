package edu.tjcu.dao;

import java.util.List;

import org.hibernate.Query;

import edu.tjcu.entities.ExamRoom;
import edu.tjcu.entities.Student;
import edu.tjcu.entities.Teacher;

public class StudentManageDao extends BaseDao{
	public List<Student> queryAllStudents() {
		// TODO Auto-generated method stub
		String hql = "from Student";
		Query query = getSession().createQuery(hql);
		List<Student> students = query.list();
		return students;
	}

	public List<Student> queryStudent(Integer studentNum) {
		// TODO Auto-generated method stub
		String hql = "from Student where studentNub = ?";
		Query query = getSession().createQuery(hql);
		query.setParameter(0, studentNum);
		List<Student> student = query.list();
		return student;
	}

	public void saveStudent(Student student) {
		getSession().save(student);
		
	}

	public void deleteStudentById(Integer studentId) {
		Student student = new Student();
		student.setStudentId(studentId);
		getSession().delete(student);
	}

	public void updateStudent(Student student) {
		String hql = "update Student set studentNub=?,name=?,clazz=?,sex=? where studentId = ?";
		Query q = getSession().createQuery(hql);
		q.setParameter(0, student.getStudentNub());
		q.setParameter(1,student.getName());
		q.setParameter(2,student.getClazz());
		q.setParameter(3,student.getSex());
		q.setParameter(4,student.getStudentId());
		//返回值为1,执行成功
		int ret=q.executeUpdate();
		System.out.println(ret);
		
	}
}
