package edu.tjcu.entities;

public class GradeList {
	private String clazz;
	private String studentName;
	private String teacherName;
	private String courseName;
	private Integer peaceTimeGrade;
	private Integer finalGrade;
	private Integer totalGrade;
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getPeaceTimeGrade() {
		return peaceTimeGrade;
	}
	public void setPeaceTimeGrade(Integer peaceTimeGrade) {
		this.peaceTimeGrade = peaceTimeGrade;
	}
	public Integer getFinalGrade() {
		return finalGrade;
	}
	public void setFinalGrade(Integer finalGrade) {
		this.finalGrade = finalGrade;
	}
	public Integer getTotalGrade() {
		return totalGrade;
	}
	public void setTotalGrade(Integer totalGrade) {
		this.totalGrade = totalGrade;
	}
}
