package edu.tjcu.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import edu.tjcu.entities.Course;
import edu.tjcu.entities.Grade;
import edu.tjcu.entities.Student;
import edu.tjcu.entities.StudentCourse;
import edu.tjcu.entities.User;

public class GradeInputDao extends BaseDao{
	//通过teacherId得到课程
	public List<Course> getCourses(Integer teacherId){
		String hql = "from Course where courseId not in (select courseId from Grade where teacherId=?)and teacherId=?";
		Query q = getSession().createQuery(hql);
		q.setParameter(0, teacherId);
		q.setParameter(1, teacherId);
		List<Course> courses = q.list();
		return courses;
	}

	public ArrayList<Student> getStudents(Integer taeId, String course) {
		// TODO Auto-generated method stub
		String hql = "from Student where studentId in (select studentId from StudentCourse where courseId in (select courseId from Course where teacherId=? and courseName=?))";
		Query q = getSession().createQuery(hql);
		q.setParameter(0, taeId);
		q.setParameter(1, course);
		ArrayList<Student> students =(ArrayList<Student>)q.list();			
		return students;
	}
	public Course getCourse(Integer taeId, String course){
		String hql2= "from Course where teacherId=? and courseName=?";
		Query q2 = getSession().createQuery(hql2);
		q2.setParameter(0, taeId);
		q2.setParameter(1, course);
		List<Course> course1 =(List<Course>)q2.list();		
		return course1.get(0);
	}

	public void saveGrade(Grade grade) {
		// TODO Auto-generated method stub
		getSession().save(grade);
	}
}
