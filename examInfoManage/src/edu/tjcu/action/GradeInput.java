package edu.tjcu.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edu.tjcu.entities.Course;
import edu.tjcu.entities.Grade;
import edu.tjcu.entities.Student;
import edu.tjcu.entities.StudentCourse;
import edu.tjcu.service.GradeInputService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;





public class GradeInput extends ActionSupport{
	private GradeInputService gradeInputService;
	private ArrayList<Course> courses;
		
	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	public GradeInputService getGradeInputService() {
		return gradeInputService;
	}

	public void setGradeInputService(GradeInputService gradeInputService) {
		this.gradeInputService = gradeInputService;
	}

	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> session = actionContext.getSession();//得到session ,获取里面的id
	public String queryCourse() throws Exception{		
		Integer teacherId = (Integer) session.get("teacherId");
		session.put("key", "cjlr");
		System.out.println(teacherId);
		//通过Id在课程表中获取老师的课程的list 传给jsp页面.
		courses = (ArrayList<Course>) gradeInputService.getCourses(teacherId);		
		return "okokok";
	}
	//查询学生信息的方法
	private String course;
	private String teacherId;

	public String getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	public String getCourse() {
		return course;
	}   

	public void setCourse(String course) {
		this.course = course;
	}
   //设置result 是json格式的
	private String result;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String queryStudent(){	
		Integer taeId = Integer.parseInt(teacherId);
		System.out.println(taeId);
		System.out.println(course);
		//将session中放入课程名,以后会用到的...
		Integer courseId = gradeInputService.getCourse(taeId,course).getCourseId();
		session.put("courseId",courseId);		
		List<Student> students = gradeInputService.getStudents(taeId,course);
		/*System.out.println(students.get(0).getClazz());	*/
		//list转json
		JSONArray jsonArray = JSONArray.fromObject(students);
		//测试一下
		result = jsonArray.toString();
	    System.out.println(result);
		return SUCCESS;		
	}
	private String gradeJson;
	public String getGradeJson() {
		return gradeJson;
	}
	public void setGradeJson(String gradeJson) {
		this.gradeJson = gradeJson;
	}
	
	public String saveGrade(){		
		JSONArray gradeJsonArray = JSONArray.fromObject(gradeJson);
		for(int i = 0; i<gradeJsonArray.size();i++){	
			Grade grade = new Grade();
			Integer sid = (Integer)gradeJsonArray.getJSONObject(i).get("studentId");
			Integer peaceTimeGrade = (Integer)gradeJsonArray.getJSONObject(i).get("peaceTimeGrade");
			Integer finalGrade = (Integer)gradeJsonArray.getJSONObject(i).get("finalGrade");
			Integer totalGrade = (Integer)gradeJsonArray.getJSONObject(i).get("totalGrade");
			grade.setStudentId(sid);
			grade.setTeacherId((Integer)session.get("teacherId"));
			grade.setPeacetimeGrade(peaceTimeGrade);   
			grade.setFinalGrade(finalGrade);  
			grade.setTotalGrade(totalGrade);
			grade.setCourseId((Integer)session.get("courseId"));
			gradeInputService.saveGrade(grade);
		}		
		return SUCCESS;
	}
	
}
