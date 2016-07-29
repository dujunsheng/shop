package goodDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.LifecycleListener;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import po.Goods;
import utils.Condition;
import utils.MybatisUtils;
import utils.PageBean;
import utils.PageConstants;

public class GoodDao {
	
	public Goods findByG_id(int g_id){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "goodMapper.selectByPrimaryKey";
		Goods good = session.selectOne(statement, g_id);
		session.close();
		return good;
	}
	
	public PageBean<Goods> findAll(int pc){
		int ps = PageConstants.GOOD_PAGE_SIZE;
		PageBean<Goods> pb = new PageBean<Goods>();
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		int tr = session.selectOne("goodMapper.countAll");
		String statement = "goodMapper.findAll";
		Map map = new HashMap<String, Object>();
		map.put("pc", (pc-1)*ps);
		map.put("tr", ps);
		List<Goods> beanList = session.selectList(statement,map);
		session.close();
		
		pb.setPc(pc);
		pb.setBeanList(beanList);
		pb.setPs(ps);
		pb.setTr(tr);
		return pb;
		
	}
	
	public PageBean<Goods> findByC_id(int c_id, int pc){
		int ps = PageConstants.COLLECT_PAGE_SIZE;
		PageBean<Goods> pb = new PageBean<Goods>();
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		int tr = session.selectOne("goodMapper.countByC_id", c_id);
		Map map = new HashMap<String, Object>();
		map.put("c_id", c_id);
		map.put("sp", pc*ps);
		map.put("ep", ps);
		String statement = "goodMapper.findByC_id";
		List<Goods> list = session.selectList(statement, map);
		session.close();
		pb.setBeanList(list);
		pb.setPc(pc);
		pb.setPs(ps);
		pb.setTr(tr);
		return pb;
	}
	
	public int deleteByPrimaryKey(int g_id){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "goodMapper.deleteByPrimaryKey";
		int result = session.delete(statement, g_id);
		session.commit();
		session.close();
		return result;
	}
	
	public int insert(Goods good){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "goodMapper.insert";
		int result = session.delete(statement, good);
		session.commit();
		session.close();
		return result;
	}
	
	public int insertSelective(Goods good){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "goodMapper.insertSelective";
		int result = session.delete(statement, good);
		session.commit();
		session.close();
		return result;
	}
	
	public int updateByPrimaryKeySelective(Goods good){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "goodMapper.updateByPrimaryKeySelective";
		int result = session.update(statement, good);
		session.commit();
		session.close();
		return result;
	}
	
	public Goods findByName(String name){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "goodMapper.findByName";
		Goods good = session.selectOne(statement, name);
		session.close();
		return good;
	}
	
	public PageBean<Goods> findByCondition(Condition condition, int pc){
//		先将条件和页码放入hashMap中
		int ps = PageConstants.COLLECT_PAGE_SIZE;
		Map map = new HashMap<String, Object>();
		map.put("c_id", condition.getCategory());
		map.put("min", condition.getMin());
		map.put("max", condition.getMax());
		map.put("sp", (pc-1)*ps);
		map.put("ep", ps);
		PageBean<Goods> pb = new PageBean<Goods>();
//		查询数目
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		int tr = session.selectOne("goodMapper.countByCondition", map);
		List<Goods> result = session.selectList("goodMapper.findByCondition", map);
		session.close();
		pb.setTr(tr);
		pb.setPc(pc);
		pb.setBeanList(result);
		pb.setPs(ps);
		return pb;
	}
}
