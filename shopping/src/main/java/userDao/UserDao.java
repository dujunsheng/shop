package userDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import po.User;
import utils.MybatisUtils;

public class UserDao {

	public User userLoad(User user)throws Exception{
		SqlSessionFactory factory = MybatisUtils.getFactory();
		String statement = "userDao.userMapper.userLoad";
		SqlSession session = factory.openSession();
		User result = session.selectOne(statement, user);
		session.close();
		return result;
	}
	
	public int addUser(User user)throws Exception{
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "userDao.userMapper.addUser";
		int result = session.insert(statement, user);
		session.commit();
		session.close();
		return result;
	}
	
	public int deleteUser(int u_id)throws Exception{
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "userDao.userMapper.deleteUser";
		int result = session.delete(statement, u_id);
		session.commit();
		session.close();
		return result;
	}
	
	public int updateUser(User user)throws Exception{
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "userDao.userMapper.updateUser";
		int result = session.update(statement, user);
		session.commit();
		session.close();
		return result;
	}
	
	public User adminLoad(User user)throws Exception{
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "userDao.userMapper.adminLoad";
		User result = session.selectOne(statement, user);
		session.close();
		return result;
	}
	
	public List<User> findNoPassUser()throws Exception{
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "userDao.userMapper.findNoPassUsr";
		List<User> userList = session.selectList(statement);
		session.close();
		return userList;
	}
	
	public int checkUser(int id)throws Exception{
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "userDao.userMapper.checkUser";
		int result = session.update(statement, id);
		session.commit();
		session.close();
		return result;
	}
//	 多条件查询
	public List<User> findByCondition(User user)throws Exception{
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "userDao.userMapper.findByCondition";
		List<User> users = session.selectList(statement, user);
		session.close();
		return users;
	}
	
//	根据条件修改
	public int updateSelect(User user)throws Exception{
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "userDao.userMapper.updateSelect";
		int result = session.update(statement, user);
		session.commit();
		session.close();
		return result;
	}
}

