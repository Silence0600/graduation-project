package edu.tjcu.service;

import edu.tjcu.entities.Admin;
import edu.tjcu.entities.Student;
import edu.tjcu.entities.Teacher;
import edu.tjcu.entities.User;

import java.util.List;

import edu.tjcu.dao.*;
public class CheckUserService {
	
	private CheckUserDao checkUserDao;
	
	
	public CheckUserDao getCheckUserDao() {
		return checkUserDao;
	}


	public void setCheckUserDao(CheckUserDao checkUserDao) {
		this.checkUserDao = checkUserDao;
	}


	public User get(String accNub) {
		return checkUserDao.get(accNub);
	}


	public List<Teacher> getTeacherByAccNum(Integer accNum) {
		// TODO Auto-generated method stub
		return checkUserDao.getTeacherByAccNum(accNum);
	}


	public List<Admin> getAdminsByAccNum(String accNum) {
		// TODO Auto-generated method stub
		return checkUserDao.getAdminsByAccNum(accNum);
	}


	public List<Student> getStudentByStuNum(Integer stuNum) {
		
		return checkUserDao.getStudentByStuNum(stuNum) ;
	}
}
