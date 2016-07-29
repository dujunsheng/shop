package categoryDao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import po.Category;
import utils.MybatisUtils;

public class CategoryDao {

	public List<Category> findAll(){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "CategoryMapper.findAll";
		List<Category> categoryList = session.selectList(statement);
		session.close();
		return categoryList;
	}
	
	public int insert(Category category){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "CategoryMapper.insert";
		int result = session.insert(statement, category);
		session.commit();
		session.close();
		return result;
	}
	
	public int deleteByPrimaryKey(int c_id){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "CategoryMapper.deleteByPrimaryKey";
		int result = session.delete(statement, c_id);
		session.commit();
		session.close();
		return result;
	}
	
	public int insertSelective(Category category){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "CategoryMapper.insertSelective";
		int result = session.insert(statement, category);
		session.commit();
		session.close();
		return result;
	}
	
	public int updateByPrimaryKeySelective(Category category)throws Exception{
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "CategoryMapper.updateByPrimaryKeySelective";
		int result = session.insert(statement, category);
		session.commit();
		session.close();
		return result;
	}

}
