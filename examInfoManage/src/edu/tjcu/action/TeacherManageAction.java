package edu.tjcu.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.tjcu.entities.ExamRoom;
import edu.tjcu.entities.Teacher;
import edu.tjcu.service.TeacherManageService;
import net.sf.json.JSONArray;

public class TeacherManageAction extends ActionSupport {
	private TeacherManageService teacherManageService;
	public TeacherManageService getTeacherManageService() {
		return teacherManageService;
	}
	public void setTeacherManageService(TeacherManageService teacherManageService) {
		this.teacherManageService = teacherManageService;
	}
	//查询所有的teacher
	private List<Teacher> allTeachers;
	public List<Teacher> getAllTeachers() {
		return allTeachers;
	}
	public void setAllTeachers(List<Teacher> allTeachers) {
		this.allTeachers = allTeachers;
	}
	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> session = actionContext.getSession();
	
	public String queryAllTeacher() throws Exception {
		allTeachers = teacherManageService.queryAllTeacher();
		session.put("key", "jsgl");
		return "queryAllTeacherSuc";
	}
	//查询一个老师的信息...
	private Integer teacherId;
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	private Integer teacherNum;
	private String teacherName;
	private Integer age;
	private String sex;
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	private String teacherJsonString;
	public String getTeacherJsonString() {
		return teacherJsonString;
	}
	public void setTeacherJsonString(String teacherJsonString) {
		this.teacherJsonString = teacherJsonString;
	}
	public Integer getTeacherNum() {
		return teacherNum;
	}
	public void setTeacherNum(Integer teacherNum) {
		this.teacherNum = teacherNum;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String queryOne() throws Exception{
		List<Teacher> teacher = teacherManageService.query(teacherNum, teacherName);

		if (teacher != null) {
			JSONArray teacherJson = JSONArray.fromObject(teacher);
			teacherJsonString = teacherJson.toString();
		}
		return SUCCESS;	
	}
	public String changeToAddPage() throws Exception{
		return "changeToAddPage";	
	}
	public String saveTeacher() throws Exception{
		Teacher teacher = new Teacher();
		teacher.setTeacherNum(teacherNum);
		teacher.setTeacherName(teacherName);
		teacher.setAge(age);
		teacher.setSex(sex);
		teacher.setPassword(teacherNum.toString());
		teacherManageService.saveTeacher(teacher);
		return "saveTeacherSuc";
	}
	
	public String changeToUpdatePage() throws Exception{
		return "changeToTpdatePageSuc";
	}
	public String updateTeacher() throws Exception{
		Teacher teacher = new Teacher();
		teacher.setTeacherId(teacherId);
		teacher.setTeacherNum(teacherNum);
		teacher.setTeacherName(teacherName);
		teacher.setAge(age);
		teacher.setSex(sex);
		teacherManageService.updateTeacher(teacher);
		return "ok";
	}
	public String deleteTeacher(){
		teacherManageService.deleteTeacherById(teacherId);
		return "deleteTeacherSuc";
	}
}
