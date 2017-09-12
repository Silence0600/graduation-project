package edu.tjcu.entities;

public class ExamRoomAndClass {
	private Integer examRoomId;
	public Integer getExamRoomId() {
		return examRoomId;
	}
	public void setExamRoomId(Integer examRoomId) {
		this.examRoomId = examRoomId;
	}
	private String examRoomName;
	private String clazz;
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getExamRoomName() {
		return examRoomName;
	}
	public void setExamRoomName(String examRoomName) {
		this.examRoomName = examRoomName;
	}
}
