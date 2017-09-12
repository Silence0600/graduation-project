package edu.tjcu.entities;

public class Course {
	Integer courseId;
	Integer courseNub;
	String  courseName;
	Integer teacherId;
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Integer getCourseNub() {
		return courseNub;
	}
	public void setCourseNub(Integer courseNub) {
		this.courseNub = courseNub;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
}
