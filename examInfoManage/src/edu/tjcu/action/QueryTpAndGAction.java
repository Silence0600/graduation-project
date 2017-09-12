package edu.tjcu.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.tjcu.entities.Grade;
import edu.tjcu.entities.GradeList;
import edu.tjcu.entities.Student;
import edu.tjcu.entities.Teacher;
import edu.tjcu.entities.TestProcess;
import edu.tjcu.service.QueryTpAndGService;

public class QueryTpAndGAction extends ActionSupport {
	private QueryTpAndGService queryTpAndGService;

	public QueryTpAndGService getQueryTpAndGService() {
		return queryTpAndGService;
	}

	public void setQueryTpAndGService(QueryTpAndGService queryTpAndGService) {
		this.queryTpAndGService = queryTpAndGService;
	}

	private String gjz;

	public String getGjz() {
		return gjz;
	}

	public void setGjz(String gjz) {
		this.gjz = gjz;
	}

	private List<TestProcess> TpList;

	public List<TestProcess> getTpList() {
		return TpList;
	}

	public void setTpList(List<TestProcess> tpList) {
		TpList = tpList;
	}

	public String queryTp() {
		System.out.println(gjz);
		List list = queryTpAndGService.queryTp(gjz);
		// 将查询出来的list转TestProcess泛型
		TpList = new ArrayList<TestProcess>();
		for (int i = 0; i < list.size(); i++) {
			TestProcess testProcess = new TestProcess();
			Object[] obj = (Object[]) list.get(i);
			testProcess.setCourseName((String) obj[0]);
			testProcess.setTeacherName((String) obj[1]);
			String time = obj[2].toString();
			StringBuffer sb = new StringBuffer(time);
			sb.delete(sb.length() - 2, sb.length());
			testProcess.setExamTime(sb.toString());
			testProcess.setExamRoomName((String) obj[3]);
			testProcess.setInvigilator((String) obj[4]);
			TpList.add(testProcess);
		}

		return SUCCESS;
	}

	public String changeTp() {
		// 首先根据studentId 查询出班级
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		session.put("key", "kccx");
		Integer studentId = (Integer) session.get("studentId");
		Student stu = queryTpAndGService.getStudent(studentId);
		// 然后根据班级查询考程
		String clazz = stu.getClazz();
		List myTplist = queryTpAndGService.queryMyTp(clazz);
		TpList = new ArrayList<TestProcess>();
		for (int i = 0; i < myTplist.size(); i++) {
			TestProcess testProcess = new TestProcess();
			Object[] obj = (Object[]) myTplist.get(i);
			testProcess.setCourseName((String) obj[0]);
			testProcess.setTeacherName((String) obj[1]);
			String time = obj[2].toString();
			StringBuffer sb = new StringBuffer(time);
			sb.delete(sb.length() - 2, sb.length());
			testProcess.setExamTime(sb.toString());
			testProcess.setExamRoomName((String) obj[3]);
			testProcess.setInvigilator((String) obj[4]);
			TpList.add(testProcess);
		}
		return "changeTpSuccess";
	}

	public String changeG() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		session.put("key", "cjcx");
		Integer studentId = (Integer) session.get("studentId");
		List myGradelist = queryTpAndGService.queryMyGrade(studentId);
		gradeList = new ArrayList<GradeList>();
		for (int i = 0; i < myGradelist.size(); i++) {
			GradeList grade = new GradeList();
			Object[] obj = (Object[]) myGradelist.get(i);
			grade.setClazz((String) obj[0]);
			grade.setStudentName((String) obj[1]);
			grade.setCourseName((String) obj[2]);
			grade.setTeacherName((String) obj[3]);
			grade.setPeaceTimeGrade((Integer) obj[4]);
			grade.setFinalGrade((Integer) obj[5]);
			grade.setTotalGrade((Integer) obj[6]);
			gradeList.add(grade);
		}
		return "changeGradeSuccess";
	}

	// 根据学号查询成绩
	private Integer studentNum;
	private List<GradeList> gradeList;

	public List getGradeList() {
		return gradeList;
	}

	public void setGradeList(List gradeList) {
		this.gradeList = gradeList;
	}

	public Integer getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(Integer studentNum) {
		this.studentNum = studentNum;
	}

	public String queryGrade() {
		List list = queryTpAndGService.queryGrade(studentNum);
		gradeList = new ArrayList<GradeList>();
		for (int i = 0; i < list.size(); i++) {
			GradeList grade = new GradeList();
			Object[] obj = (Object[]) list.get(i);
			grade.setClazz((String) obj[0]);
			grade.setStudentName((String) obj[1]);
			grade.setCourseName((String) obj[2]);
			grade.setTeacherName((String) obj[3]);
			grade.setPeaceTimeGrade((Integer) obj[4]);
			grade.setFinalGrade((Integer) obj[5]);
			grade.setTotalGrade((Integer) obj[6]);
			gradeList.add(grade);
		}
		return "queryGradeSuccess";
	}
	private List<TestProcess> teacherTPList;
	public List<TestProcess> getTeacherTPList() {
		return teacherTPList;
	}

	public void setTeacherTPList(List<TestProcess> teacherTPList) {
		this.teacherTPList = teacherTPList;
	}
	
	private List<TestProcess> teacherTPList2;
	public List<TestProcess> getTeacherTPList2() {
		return teacherTPList2;
	}

	public void setTeacherTPList2(List<TestProcess> teacherTPList2) {
		this.teacherTPList2 = teacherTPList2;
	}

	public String queryTeacherTP() throws Exception{
			// 首先根据studentId 查询出姓名
			ActionContext actionContext = ActionContext.getContext();
			Map<String, Object> session = actionContext.getSession();
			Integer teacherId = (Integer) session.get("teacherId");
			Teacher teacher = queryTpAndGService.getTeacherById(teacherId);
			// 然后根据姓名查询以前的考程
			List teacherTPListObj = queryTpAndGService.getTeacherTPList(teacher.getTeacherName());
			teacherTPList = new ArrayList<TestProcess>();
			for (int i = 0; i < teacherTPListObj.size(); i++) {
				TestProcess testProcess = new TestProcess();
				Object[] obj = (Object[]) teacherTPListObj.get(i);
				testProcess.setCourseName((String) obj[0]);
				testProcess.setTeacherName((String) obj[1]);
				String time = obj[2].toString();
				StringBuffer sb = new StringBuffer(time);
				sb.delete(sb.length() - 2, sb.length());
				testProcess.setExamTime(sb.toString());
				testProcess.setExamRoomName((String) obj[3]);
				testProcess.setInvigilator((String) obj[4]);
				teacherTPList.add(testProcess);
			}
			session.put("teacherTPList",teacherTPList);  
			//然后根据姓名查询以後的考程
			List teacherTPListObj2 = queryTpAndGService.getTeacherTPList2(teacher.getTeacherName());
			teacherTPList2 = new ArrayList<TestProcess>();
			for (int i = 0; i < teacherTPListObj2.size(); i++) {
				TestProcess testProcess = new TestProcess();
				Object[] obj = (Object[]) teacherTPListObj2.get(i);
				testProcess.setCourseName((String) obj[0]);
				testProcess.setTeacherName((String) obj[1]);
				String time = obj[2].toString();
				StringBuffer sb = new StringBuffer(time);
				sb.delete(sb.length() - 2, sb.length());
				testProcess.setExamTime(sb.toString());
				testProcess.setExamRoomName((String) obj[3]);
				testProcess.setInvigilator((String) obj[4]);
				teacherTPList2.add(testProcess);
			}
			session.put("teacherTPList2",teacherTPList2);
			return "changeTeacherTPSuccess";
	}
}
