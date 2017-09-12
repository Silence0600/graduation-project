package edu.tjcu.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import edu.tjcu.entities.User;

public class UserManageDao extends BaseDao{
	
		public List<User> getAllUser(){				
		String hql = "from User";//必须是类名....不是表名
		List<User> userList = (List<User>) getSession().createQuery(hql).list();
		return userList;
		
	}
}
