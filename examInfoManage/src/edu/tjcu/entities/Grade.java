package edu.tjcu.entities;

public class Grade {
	Integer gradeId;
	Integer courseId;
	Integer teacherId;
	Integer studentId;
	Integer peacetimeGrade;
	Integer finalGrade;
	Integer totalGrade;
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public Integer getPeacetimeGrade() {
		return peacetimeGrade;
	}
	public void setPeacetimeGrade(Integer peacetimeGrade) {
		this.peacetimeGrade = peacetimeGrade;
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
