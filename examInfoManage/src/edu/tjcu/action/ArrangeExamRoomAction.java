package edu.tjcu.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edu.tjcu.entities.ClassAndStuNum;
import edu.tjcu.entities.Course;
import edu.tjcu.entities.ExamRoom;
import edu.tjcu.entities.ExamRoomAndClass;
import edu.tjcu.entities.ExamRoomTime;
import edu.tjcu.entities.Grade;
import edu.tjcu.entities.TestProcess;
import edu.tjcu.service.ArrangeExamRoomService;
import edu.tjcu.service.GradeInputService;
import net.sf.json.JSONArray;
import util.Algorithm;
import util.ArrayAlgorithm;

public class ArrangeExamRoomAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<Course> courses;
	private ArrangeExamRoomService arrangeExamRoomService;

	public ArrangeExamRoomService getArrangeExamRoomService() {
		return arrangeExamRoomService;
	}

	public void setArrangeExamRoomService(ArrangeExamRoomService arrangeExamRoomService) {
		this.arrangeExamRoomService = arrangeExamRoomService;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> session = actionContext.getSession();// 得到session

	public String change() throws Exception {
		Integer teacherId = (Integer) session.get("teacherId");
		session.put("key","kcap");
		courses = arrangeExamRoomService.getCourses(teacherId);
		return "changeSuccess";
	}

	// 查询出适合的教室
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	private String examTime;
	private String course;

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String queryGoodExamRoom() throws Exception {
		// 得到teacherID和Course 到StudentCourse查询人数.
		Integer teacherId = (Integer) session.get("teacherId");
		ArrayList objectList = arrangeExamRoomService.queryClassAndStuNum(teacherId, course);
		// 将得到的list<object>转成List<ClassAndStuNum>
		/*ArrayList<ClassAndStuNum> CASList = new ArrayList<ClassAndStuNum>();*/
		
		/*
		 * int stuNum =
		 * arrangeExamRoomService.queryStudentNum(teacherId,course);
		 * System.out.println(stuNum);
		 */
		// 考试时间格式化。
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf.parse(examTime);
		// 在考场时刻表查询该时刻该教师是否有考试安排,如果有返回对话框,告诉他该时刻你有考试安排,请另选时间
		ArrayList<ExamRoomTime> currentScheduleList = (ArrayList<ExamRoomTime>) arrangeExamRoomService
				.getCurrentScheduleList(teacherId, date);
		if (currentScheduleList.size() != 0) {

			return SUCCESS;
		}
		// 先要得到一个选择该课程的班级及人数的实体的list...
		/*ArrayList<ClassAndStuNum> CASList = new ArrayList<ClassAndStuNum>();*/
		List<Integer> examRoomIds = new ArrayList<Integer>();
		examRoomIds.add(0);
		List<ExamRoomAndClass> erac = new ArrayList<ExamRoomAndClass>();
		// 遍历list得到人数,遍历中得到当前处于空闲状态下的考场的集合。将符合的考场
		for (int i = 0; i < objectList.size(); i++) {	
			Object[] obj = (Object[]) objectList.get(i);
			Integer stuNum = Integer.parseInt(obj[1].toString());
			ExamRoom examRoom = arrangeExamRoomService.getExamRoom(examRoomIds,stuNum);
			ExamRoomAndClass examRoomAndClass = new ExamRoomAndClass();
			examRoomAndClass.setClazz((String)obj[0]);
			examRoomAndClass.setExamRoomName(examRoom.getExamRoomName());
			examRoomAndClass.setExamRoomId(examRoom.getExamRoomId());
			erac.add(examRoomAndClass);
			//将id传给list ,将这个id的考场排除
			examRoomIds.add(examRoom.getExamRoomId());
		/*	ClassAndStuNum classAndStuNum = new ClassAndStuNum();
			Object[] obj = (Object[]) objectList.get(i);
			classAndStuNum.setClazz((String) obj[0]);
			classAndStuNum.setStuNum(Integer.parseInt(obj[1].toString()));
			CASList.add(classAndStuNum);*/
		}
		JSONArray examRoomsJson = JSONArray.fromObject(erac); 
		result = examRoomsJson.toString();
		// 得到当前处于空闲状态下的考场的集合。
		

		// 当没有空教室的数目小于要求的返回什么????
		/*
		 * if(accList.size()<num){ return SUCCESS; }
		 */
		// 将空闲考场集合的容纳人数遍历出来 ，放到accListInteger中。
		/*ArrayList<Integer> accListInteger = new ArrayList<Integer>();
		for (int i = 0; i < accList.size(); i++) {
			accListInteger.add(accList.get(i).getAccommodateNum());
		}*/
		/*
		 * ArrayAlgorithm aa = new ArrayAlgorithm(); if
		 * (!ArrayAlgorithm.list.isEmpty()) { ArrayAlgorithm.list = new
		 * ArrayList<List<Integer>>(); } aa.combinerSelect(accListInteger, new
		 * ArrayList<Integer>(),stuNum ,num);
		 * System.out.println(ArrayAlgorithm.list); List<Integer> sumList = new
		 * ArrayList<Integer>(); for (int i = 0; i < ArrayAlgorithm.list.size();
		 * i++) { Integer sum = 0; for (int j = 0; j <
		 * ArrayAlgorithm.list.get(i).size(); j++) { sum +=
		 * ArrayAlgorithm.list.get(i).get(j); } sumList.add(sum);
		 * System.out.println(sum); } int temp = sumList.get(0); int index = 0;
		 * for (int k = 1; k < sumList.size(); k++) {
		 * //这里得到了容纳人数大于等于考试人数的考场组合,现在要选择出一组能够通过教室将班级分组的组合.. if (sumList.get(k)
		 * <= temp) { temp = sumList.get(k); index = k; } }
		 * System.out.println(ArrayAlgorithm.list.get(index));
		 * if(ArrayAlgorithm.list.get(index).isEmpty()){ //返回没有符合条件的考场 的json
		 * 建议安排其他时间. return SUCCESS; }
		 */
		// 得到了符合条件的几个考场,返回的是考场的对象,就是要选择的考场信息.
		/*
		 * ArrayList<ExamRoom> examRoomList = (ArrayList<ExamRoom>)
		 * arrangeExamRoomService.getGoodExamRoom((ArrayList)
		 * ArrayAlgorithm.list.get(index)); //将list 中的考场遍历出来再前端显示 
		 * JSONArray examRoomsJson = JSONArray.fromObject(examRoomList); 
		 * result = examRoomsJson.toString();
		 */
		return SUCCESS;
	}

	private String examRoomTimeJson;

	public String getExamRoomTimeJson() {
		return examRoomTimeJson;
	}

	public void setExamRoomTimeJson(String examRoomTimeJson) {
		this.examRoomTimeJson = examRoomTimeJson;
	}

	public String insertExamRoomTime() throws Exception {
		Integer teacherId = (Integer) session.get("teacherId");// teacherId得到了
		JSONArray examRoomTimeArray = JSONArray.fromObject(examRoomTimeJson);
		for (int i = 0; i < examRoomTimeArray.size(); i++) {
			ExamRoomTime ert = new ExamRoomTime();
			// 如果是int类型的,则json串不需要加""
			Integer examRoomId = (Integer) examRoomTimeArray.getJSONObject(i).get("examRoomId"); // 考场Id得到了
			String examT = (String) examRoomTimeArray.getJSONObject(i).get("examTime");// 得到时刻的字符串
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse(examT); // 得到了时刻
			String courName = (String) examRoomTimeArray.getJSONObject(i).get("course");
			String clazz= (String) examRoomTimeArray.getJSONObject(i).get("clazz");
			Course c = arrangeExamRoomService.getCourse(teacherId, courName);
			Integer courseId = c.getCourseId();// 课程id
			String invigilator = (String) examRoomTimeArray.getJSONObject(i).get("invigilator"); // 监考老师得到了
			ert.setExamRoomId(examRoomId);
			ert.setTeacherId(teacherId);
			ert.setCourseId(courseId);
			ert.setExamTime(date);
			ert.setInvigilator(invigilator);
			ert.setStatus(clazz);
			arrangeExamRoomService.insertExamRoomTome(ert);
		}
		return SUCCESS;
	}
}
