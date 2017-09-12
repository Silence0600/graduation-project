package edu.tjcu.dao;

import java.util.List;

import org.hibernate.Query;

import edu.tjcu.entities.Grade;
import edu.tjcu.entities.Student;
import edu.tjcu.entities.Teacher;
import edu.tjcu.entities.TestProcess;

public class QueryTpAndGDao extends BaseDao{

	public List queryTp(String gjz) {
		// TODO Auto-generated method stub
		String sql = "select distinct c.courseName as courseName,t.teacherName as teacherName,ert.examTime as examTime,er.examRoomName as examRoomName,ert.invigilator as invigilator from studentCourse sc inner join examRoomTime ert on sc.courseId=ert.courseId inner join Student s on sc.studentId=s.studentId inner join Course c on ert.courseId=c.courseId inner join teacher t on ert.teacherId=t.teacherId inner join ExamRoom er on ert.examRoomId=er.examRoomId where s.name=? or ert.invigilator like ? or c.courseName=?";
		Query q = getSession().createSQLQuery(sql);
		q.setParameter(0, gjz);
		q.setParameter(1, "%"+gjz+"%");
		q.setParameter(2, gjz);
		List TpList = q.list();
		return TpList;
	}

	public List queryGrade(Integer studentNum) {
		String sql= "select s.clazz,s.name,c.courseName,t.teacherName,g.peaceTimeGrade,g.finalGrade,g.totalGrade from Grade g left join Student s on g.studentId=s.studentId left join Course c on g.courseId=c.courseId left join Teacher t on t.teacherId=g.teacherId where studentNub=?";
		Query q = getSession().createSQLQuery(sql);
		q.setParameter(0, studentNum);
		List gradeList = q.list();
		return gradeList;
	}

	public List queryAllTp() {
		String sql = "select distinct c.courseName as courseName,t.teacherName as teacherName,ert.examTime as examTime,er.examRoomName as examRoomName,ert.invigilator as invigilator from studentCourse sc inner join examRoomTime ert on sc.courseId=ert.courseId inner join Student s on sc.studentId=s.studentId inner join Course c on ert.courseId=c.courseId inner join teacher t on ert.teacherId=t.teacherId inner join ExamRoom er on ert.examRoomId=er.examRoomId";
		Query q = getSession().createSQLQuery(sql);
		List allTpList = q.list();
		return allTpList;
	}

	public Student getStudnent(Integer studentId) {
		String hql = "from Student where studentId = ?";
		Query q = getSession().createQuery(hql);
		q.setParameter(0, studentId);
		return (Student) q.list().get(0);
	}

	public List queryMyTp(String clazz) {
		String sql = "select distinct c.courseName as courseName,t.teacherName as teacherName,ert.examTime as examTime,er.examRoomName as examRoomName,ert.invigilator as invigilator from studentCourse sc inner join examRoomTime ert on sc.courseId=ert.courseId inner join Student s on sc.studentId=s.studentId inner join Course c on ert.courseId=c.courseId inner join teacher t on ert.teacherId=t.teacherId inner join ExamRoom er on ert.examRoomId=er.examRoomId where status=?";
		Query q = getSession().createSQLQuery(sql);
		q.setParameter(0, clazz);
		return q.list();
	}

	public List queryMyGrade(Integer studentId) {
		String sql= "select s.clazz,s.name,c.courseName,t.teacherName,g.peaceTimeGrade,g.finalGrade,g.totalGrade from Grade g left join Student s on g.studentId=s.studentId left join Course c on g.courseId=c.courseId left join Teacher t on t.teacherId=g.teacherId where s.studentId=?";
		Query q = getSession().createSQLQuery(sql);
		q.setParameter(0, studentId);
		List gradeList = q.list();
		return gradeList;
	}

	public List getTeacherTPList(String teacherName) {
		String sql = "select distinct c.courseName as courseName,t.teacherName as teacherName,ert.examTime as examTime,er.examRoomName as examRoomName,ert.invigilator as invigilator from studentCourse sc inner join examRoomTime ert on sc.courseId=ert.courseId inner join Student s on sc.studentId=s.studentId inner join Course c on ert.courseId=c.courseId inner join teacher t on ert.teacherId=t.teacherId inner join ExamRoom er on ert.examRoomId=er.examRoomId where ert.invigilator like ? and ert.examTime < NOW() order by ert.examTime asc";
		Query q = getSession().createSQLQuery(sql);
		q.setParameter(0, "%"+teacherName+"%");
		List TpList = q.list();
		return TpList;
	}

	public Teacher getTeacherById(Integer teacherId) {
		String hql = "from Teacher where teacherId = ?";
		Query q = getSession().createQuery(hql);
		q.setParameter(0, teacherId);		
		return (Teacher)q.list().get(0);
	}

	public List getTeacherTPList2(String teacherName) {
		String sql = "select distinct c.courseName as courseName,t.teacherName as teacherName,ert.examTime as examTime,er.examRoomName as examRoomName,ert.invigilator as invigilator from studentCourse sc inner join examRoomTime ert on sc.courseId=ert.courseId inner join Student s on sc.studentId=s.studentId inner join Course c on ert.courseId=c.courseId inner join teacher t on ert.teacherId=t.teacherId inner join ExamRoom er on ert.examRoomId=er.examRoomId where ert.invigilator like ? and ert.examTime > NOW() order by ert.examTime asc";
		Query q = getSession().createSQLQuery(sql);
		q.setParameter(0, "%"+teacherName+"%");
		List TpList = q.list();
		return TpList;
	}

}
