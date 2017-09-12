package edu.tjcu.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import edu.tjcu.entities.ClassAndStuNum;
import edu.tjcu.entities.Course;
import edu.tjcu.entities.ExamRoom;
import edu.tjcu.entities.ExamRoomTime;

public class ArrangeExamRoomDao extends BaseDao {

	public void save(ExamRoomTime ert) {
		getSession().save(ert);

	}

	public int queryStudentNum(Integer teacherId, String course) {
		String hql = "select count(*) as c from StudentCourse where courseId in (select courseId from Course where teacherId=? and courseName=?)";
		Query q = getSession().createQuery(hql);
		q.setParameter(0, teacherId);
		q.setParameter(1, course);
		return ((Number) q.uniqueResult()).intValue();
	}

	public List getAccList(Date date) {
		String hql = "from ExamRoom where examRoomId not in (select examRoomId from ExamRoomTime where examTime=?)";
		Query q = getSession().createQuery(hql);
		q.setParameter(0, date);
		return q.list();

	}

	// 得到符合条件的考场list
	public List getGoodExamRoom(ArrayList<Integer> goodRoomComb) {
		List<Integer> examRoomIds = new ArrayList<Integer>();
		examRoomIds.add(0);
		List<ExamRoom> examRoomList = new ArrayList<ExamRoom>();
		Iterator iterator = goodRoomComb.iterator();
		while (iterator.hasNext()) {
			String eri = "";
			if (examRoomIds.size() != 0) {
				for (int i = 0; i < examRoomIds.size(); i++) {
					if (i < examRoomIds.size() - 1) {
						eri += examRoomIds.get(i).toString() + ",";
					} else {
						eri += examRoomIds.get(i).toString();
					}
				}
			}
			String hql = "from ExamRoom where accommodateNum =? and examRoomId not in(" + eri + ")";
			System.out.println(hql);
			Query q = getSession().createQuery(hql);
			q.setParameter(0, (Integer) iterator.next());
			List<ExamRoom> list = q.list();
			// 将id都加进来,当查询的时候遍历一下.
			examRoomIds.add(list.get(0).getExamRoomId());
			examRoomList.add(list.get(0));
		}
		return examRoomList;
	}

	public void insertExamRoomTome(ExamRoomTime ert) {
		getSession().save(ert);
	}

	public List<Course> getCourses(Integer teacherId) {
		String hql = "from Course where courseId not in (select courseId from ExamRoomTime where teacherId=?)and teacherId=?";
		Query q = getSession().createQuery(hql);
		q.setParameter(0, teacherId);
		q.setParameter(1, teacherId);
		List<Course> courses = q.list();
		return courses;
	}

	public Course getCourse(Integer teacherId, String courName) {
		String hql2 = "from Course where teacherId=? and courseName=?";
		Query q2 = getSession().createQuery(hql2);
		q2.setParameter(0, teacherId);
		q2.setParameter(1, courName);
		List<Course> course1 = (List<Course>) q2.list();
		return course1.get(0);
	}

	public ArrayList<ExamRoomTime> getCurrentScheduleList(Integer teacherId, Date date) {
		String hql= "from ExamRoomTime where teacherId=? and examTime=?";
		Query q = getSession().createQuery(hql);
		q.setParameter(0, teacherId);
		q.setParameter(1, date);		
		return (ArrayList<ExamRoomTime>)q.list();
	}

	public ArrayList queryClassAndStuNum(Integer teacherId, String course) {
		String sql= "select clazz,count(clazz) from Student where studentId in(select studentId from StudentCourse where courseId in (select courseId from Course where teacherId=? and courseName=?)) group by clazz";
		Query q = getSession().createQuery(sql);
		q.setParameter(0, teacherId);
		q.setParameter(1, course);
		List list = q.list();
		return (ArrayList) list;
	}

	public ExamRoom getExamRoom(List<Integer> examRoomIds, Integer stuNum) {
		String eri="";
		for(int i = 0;i<examRoomIds.size();i++){
			if(i < examRoomIds.size() - 1){
				eri += examRoomIds.get(i).toString() + ",";
			}else{
				eri += examRoomIds.get(i).toString();
			}
		}
		String hql = "from ExamRoom where accommodateNum >=? and examRoomId not in(" + eri + ") order by accommodateNum asc";
		Query q = getSession().createQuery(hql);
		q.setParameter(0, stuNum);
		List<ExamRoom> erList = q.list();
		return erList.get(0);
	}
}
