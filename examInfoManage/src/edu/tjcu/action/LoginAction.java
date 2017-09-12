package edu.tjcu.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import edu.tjcu.entities.Admin;
import edu.tjcu.entities.Student;
import edu.tjcu.entities.Teacher;
import edu.tjcu.entities.User;
import edu.tjcu.service.*;

public class LoginAction extends ActionSupport /*implements ModelDriven<User>*/ {

	/**
	 * 登录的action 验证身份..通过实现ModelDriven 获取User 对象
	 */

	private static final long serialVersionUID = 1L;
	private CheckUserService checkUserService;
	
/*	private User user;

	@Override
	public User getModel() {
		user = new User();
		return user;
	}*/

	public CheckUserService getCheckUserService() {
		return checkUserService;
	}

	public void setCheckUserService(CheckUserService checkUserService) {
		this.checkUserService = checkUserService;
	}
//能得到身份吗???
	private String status;
	private String accNub;
	private String password;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAccNub() {
		return accNub;
	}

	public void setAccNub(String accNub) {
		this.accNub = accNub;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		String key = (String)session.get("key");
		if (status.equals("教师")&&("kcap".equals(key)||"cjlr".equals(key))) {
			Integer accNum = Integer.parseInt(accNub);
			List<Teacher> teachers = checkUserService.getTeacherByAccNum(accNum);	
			if((teachers.size() != 0) && teachers.get(0).getPassword().equals(password)){
				session.put("teacherId",teachers.get(0).getTeacherId());
				session.put("status", status);
				session.put("loginFlag", "true");
				session.put("mag", "");
				return "teacher";
			}else{
				session.put("mag", "请填写正确的账号或者密码!");
				return ERROR;
			}
		} else if (status.equals("管理员")&&("kcgl".equals(key)||"jsgl".equals(key)||"xsgl".equals(key))) {
			List<Admin> admins = checkUserService.getAdminsByAccNum(accNub);	
			if((admins.size() != 0) && admins.get(0).getPassword().equals(password)){
				session.put("adminId",admins.get(0).getAdminId());
				session.put("status", status);
				session.put("loginFlag", "true");
				session.put("mag", "");
				return "admin";
			}else{
				session.put("mag", "请填写正确的账号或者密码!");
				return ERROR;
			}	
		} else if (status.equals("学生")&&("kccx".equals(key)||"cjcx".equals(key))){
			Integer stuNum = Integer.parseInt(accNub);
			List<Student> students = checkUserService.getStudentByStuNum(stuNum);	
			if((students.size() != 0) && students.get(0).getPassword().equals(password)){
				session.put("studentId",students.get(0).getStudentId());
				session.put("status", status);
				session.put("loginFlag", "true");
				session.put("mag", "");
				return "student";
			}else{
				session.put("mag", "请填写正确的账号或者密码!");
				return ERROR;
			}	
		} else {
			session.put("mag", "请选择正确的身份!");
			return ERROR;
		}

		
		/*ActionContext actionContext = ActionContext.getContext();
		
		// get HttpServletRequest
		// get HttpSession
		// Map<String,Object> session = (Map) actionContext.get("session");
		Map<String, Object> session = actionContext.getSession();
		//点击的按钮
		String key = (String)session.get("key");
		String chuanru = user.getPassword();
		String acc = user.getAccNub();
		System.out.println(acc);
		User a = checkUserService.get(user.getAccNub());
		if (a != null) {
			if (chuanru.equals(a.getPassword())) {
				String status = null;
				status = a.getStatus();
				
				 //指的是数据库里的teacherId ,其实是UserId
				session.put("status", status);
				session.put("loginFlag", "true");
				session.put("mag", "");
				
				if (status.equals("老师")&&("kcap".equals(key)||"cjlr".equals(key))) {
					Integer teacherId = a.getTeacherId();
					session.put("teacherId",teacherId);
					session.put("status", status);
					String tea = "teacher";					
					return tea;
				} else if (status.equals("管理员")&&("kcgl".equals(key)||"jsgl".equals(key)||"xsgl".equals(key))) {
					Integer adminId = a.getTeacherId();
					session.put("adminId",adminId);
					session.put("status", status);
					String admin = "admin";
					return admin;
				} else if (status.equals("学生")&&("kccx".equals(key)||"cjcx".equals(key))){
					Integer studentId = a.getTeacherId();
					session.put("studentId",studentId);
					session.put("status", status);
					String student = "student";
					return student;
				} else {
					session.put("mag", "请填写正确的账号或者密码!");
					return ERROR;
				}
			} else {
				session.put("mag", "请填写正确的账号或者密码!");
				return ERROR;
			}
		} else {
			session.put("mag", "请填写正确的账号或者密码!");
			return ERROR;
		}*/
	}
}
