package edu.tjcu.entities;

import java.util.Date;

public class ExamRoomTime {
	private Integer examRoomTimeId;
	private Integer examRoomId;
	private Integer teacherId;
	private Integer courseId;
	private Date examTime;
	private String invigilator;
	public String getInvigilator() {
		return invigilator;
	}
	public void setInvigilator(String invigilator) {
		this.invigilator = invigilator;
	}
	private String status; 
	public Integer getExamRoomTimeId() {
		return examRoomTimeId;
	}
	public void setExamRoomTimeId(Integer examRoomTimeId) {
		this.examRoomTimeId = examRoomTimeId;
	}
	public Integer getExamRoomId() {
		return examRoomId;
	}
	public void setExamRoomId(Integer examRoomId) {
		this.examRoomId = examRoomId;
	}
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Date getExamTime() {
		return examTime;
	}
	public void setExamTime(Date examTime) {
		this.examTime = examTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
