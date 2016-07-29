package Serivce;

import java.util.List;

import com.mchange.v2.async.StrandedTaskReporting;

import po.User;
import userDao.UserDao;

public class UserService {

	private UserDao userDao = new UserDao();
	
	public User userLoad(User user)throws Exception{
		return userDao.userLoad(user);
	}
	
	public int addUser(User user)throws Exception{
		return userDao.addUser(user);
	}
	
	public int deleteUser(int u_id)throws Exception{
		return userDao.deleteUser(u_id);
	}
	
	public int updateUsre(User user)throws Exception{
		return userDao.updateUser(user);
	}
	
	public List<User> findNoPassUser()throws Exception{
		return userDao.findNoPassUser();
	}
	
	public int checkUser(int id)throws Exception{
		return userDao.checkUser(id);
	}
	
	public User adminLoad(User user)throws Exception{
		return userDao.adminLoad(user);
	}
	
//	修改新密码，如果旧的密码输入正确就修改
	public boolean updatePassword(User user,String oldPass,String newPass) throws Exception{
			User user1 = new User();
			user.setU_pw(oldPass);
			user1 = userDao.userLoad(user) ;
		if( user1 != null){
			User newUser = new User();
			newUser.setU_id(user.getU_id());
			newUser.setU_pw(newPass);
			int a = userDao.updateSelect(newUser);
			if(a == 1){
				return true;
			}
		}
		return false;
	}
	
//	验证姓名是否原来就存在
	public boolean findBy(String u_name)throws Exception{
		User newUser = new User();
		newUser.setU_name(u_name);
		if(userDao.findByCondition(newUser) != null){
			return false;
		}
		return true;
	}
	
//	根据条件修改用户的信息
	public int updateSelect(User user)throws Exception{
		return userDao.updateSelect(user);
	}
	
//	多天减查询用户
	public List<User> findByCondition(User user)throws Exception{
		return userDao.findByCondition(user);
	}
}
