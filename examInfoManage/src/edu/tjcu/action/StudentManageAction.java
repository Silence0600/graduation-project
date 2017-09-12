package edu.tjcu.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.tjcu.entities.Student;
import edu.tjcu.entities.Teacher;
import edu.tjcu.service.StudentManageService;
import net.sf.json.JSONArray;

public class StudentManageAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentManageService studentManageService;
	//查询所有的teacher
	private List<Student> allStudents;
	public StudentManageService getStudentManageService() {
		return studentManageService;
	}
	public void setStudentManageService(StudentManageService studentManageService) {
		this.studentManageService = studentManageService;
	}
	public List<Student> getAllStudents() {
		return allStudents;
	}
	public void setAllStudents(List<Student> allStudents) {
		this.allStudents = allStudents;
	}
	//查出所有的学生,然后跳转到管理学生的界面 
	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> session = actionContext.getSession();
	public String queryAllStudnet() throws Exception {
		allStudents = studentManageService.queryAllStudent();
		session.put("key", "xsgl");
		return "queryAllStudent";
	}
	private Integer studentId;
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	private Integer studentNum;
	private String studentJsonString;
	public String getStudentJsonString() {
		return studentJsonString;
	}
	public void setStudentJsonString(String studentJsonString) {
		this.studentJsonString = studentJsonString;
	}
	public Integer getStudentNum() {
		return studentNum;
	}
	public void setStudentNum(Integer studentNum) {
		this.studentNum = studentNum;
	}
	public String queryStudent(){
		List<Student> student = studentManageService.queryStudent(studentNum);

		if (student != null) {
			JSONArray studentJson = JSONArray.fromObject(student);
			studentJsonString = studentJson.toString();
		}
		return SUCCESS;	
	}
	public String changeToAddPage(){
		
		return "changeToAddPageSuc";
	}
	private String studentName;
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	private String clazz;
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	private String sex;
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String saveStudent() throws Exception{
		Student student = new Student();
		student.setStudentNub(studentNum);
		student.setName(studentName);
		student.setClazz(clazz);
		student.setSex(sex);
		student.setPassword(studentNum.toString());
		studentManageService.saveStudent(student);
		return "savaOk";
	}
	
	public String deleteStudent(){
		studentManageService.deleteStudentById(studentId);
		return "deletestudentSuc";
	}
	
	public String changeToUpdatePage(){
		return "changesuc";
	}
	public String updateStudent(){
		Student student = new Student();
		student.setStudentId(studentId);
		student.setStudentNub(studentNum);
		student.setName(studentName);
		student.setClazz(clazz);
		student.setSex(sex);
		studentManageService.updateStudent(student);
		return "updatesuc";
	}
	
	//查询一个老师的信息...
	/*private Integer teacherId;
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
	}*/
}
