package util;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import edu.tjcu.dao.CheckUserDao;
import edu.tjcu.dao.UserManageDao;
import edu.tjcu.entities.User;

public class TestQueryUser {

	@Test
	public void test() {
		CheckUserDao cud = new CheckUserDao();
		User user = cud.get("20134425");
		/*UserManageDao umd = new UserManageDao();
		List<User> list = umd.getAllUser();*/
		System.out.println(user.getPassword());
	}

}
