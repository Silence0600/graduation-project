package edu.tjcu.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.tjcu.entities.User;
import edu.tjcu.service.UserManageService;

public class UserManageAcion extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private UserManageService userManageService;
	private List<User> allUser;
	public List<User> getAllUser() {
		return allUser;
	}
	public void setAllUser(List<User> allUser) {
		this.allUser = allUser;
	}
	public UserManageService getUserManageService() {
		return userManageService;
	}
	public void setUserManageService(UserManageService userManageService) {
		this.userManageService = userManageService;
	}
	public String queryAllUser() throws Exception {
		allUser = userManageService.getAllUser();		
		return "queryAllUserSuc";
	}
}
