package edu.tjcu.entities;

import java.util.Date;

public class TestProcess {
	private String courseName;
	private String teacherName;
	private String examTime;

	public String getExamTime() {
		return examTime;
	}
	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}
	private String examRoomName;
	private String invigilator;
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getExamRoomName() {
		return examRoomName;
	}
	public void setExamRoomName(String examRoomName) {
		this.examRoomName = examRoomName;
	}
	public String getInvigilator() {
		return invigilator;
	}
	public void setInvigilator(String invigilator) {
		this.invigilator = invigilator;
	}
}
