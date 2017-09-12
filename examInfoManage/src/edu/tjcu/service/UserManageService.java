package edu.tjcu.service;

import java.util.List;

import edu.tjcu.dao.UserManageDao;
import edu.tjcu.entities.User;

public class UserManageService {
	private UserManageDao userManageDao;

	public UserManageDao getUserManageDao() {
		return userManageDao;
	}

	public void setUserManageDao(UserManageDao userManageDao) {
		this.userManageDao = userManageDao;
	}
	
	public List<User> getAllUser(){
		return userManageDao.getAllUser();
	}
	
}
