package test;

import java.util.List;

import org.junit.Test;

import Serivce.UserService;
import po.User;
import userDao.UserDao;

public class TestUser {
	private UserDao userDao = new UserDao();
	private UserService userService = new UserService();
	/*@Test
	public void testAddUser(){
		User user = new User(-1, "xiaoming", "111", "gaohzou", "000", 1);
		int result = userService.addUser(user);
		System.out.println(result);
	}*/
	
/*	@Test
	public void testUserDao(){
		User user = new User(-1, "xiaoming", "111", "gaohzou", "000", 1);
		UserDao userDao = new UserDao();
		int result = userDao.addUser(user);
		System.out.println(result);
	}*/
	
	/*@Test 
	public void testUserLoad(){
		User user = new User(-1, "xiaoming", "111", "gaohzou", "000", 1);
		User result = userService.userLoad(user);
		System.out.println(result.getU_name());
	}*/
	
	/*@Test
	public void testDeleteUer(){
		int result = userService.deleteUser(18);
		System.out.println(result);
	}*/
	
	/*@Test
	public void testAdminLoad(){
		User user = new User(0, "xiaohong", "123", "gaohzou", "789", 0);
		User result = userService.userLoad(user);
		System.out.println(result.getU_name());
	}*/
/*	
	@Test
	public void testUpdatePw(){
		User user = new User();
		user.setU_name("xiaohong");
		String oldPass = "123";
		String newPw = "456";
		boolean a;
		try {
			a = userService.updatePassword(user, oldPass, newPw);
			System.out.println(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
/*	@Test
	public void testUpdateSelect(){
		User user = new User();
		user.setU_adress("maoming");
		user.setU_email("857929980@qq.com");
		user.setU_id(2);
		user.setU_name("xiaodong");
		try {
			int result = userService.updateSelect(user);
			System.out.println(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	@Test
	public void testFindByCondition(){
		User user = new User();
//		user.setU_name("xiaodong");
		user.setU_id(2);
		try {
			List<User> users = userService.findByCondition(user);
			System.out.println(users);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
