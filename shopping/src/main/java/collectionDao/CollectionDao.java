package collectionDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import po.Collection;
import utils.MybatisUtils;
import utils.PageBean;
import utils.PageConstants;

public class CollectionDao {

	public PageBean<Collection> findByU_id(int u_id, int pc){
		PageBean<Collection> pb = new PageBean<Collection>();
		int ps = PageConstants.COLLECT_PAGE_SIZE;
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		int tr = session.selectOne("collectionMapper.CountByUid", u_id);
		Map map = new HashMap<String, Object>();
		map.put("u_id", u_id);
		map.put("sp", (pc-1)*ps);
		map.put("ep", ps);
		String statement = "collectionMapper.findByU_id";
		List<Collection> result = session.selectList(statement, map);
		pb.setBeanList(result);
		pb.setPc(pc);
		pb.setTr(tr);
		pb.setPs(ps);
		session.close();
		return pb;
	}
	
	public int addColleciton(Collection collection){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "collectionMapper.addCollection"; 
		int result = session.insert(statement, collection);
		session.commit();
		session.close();
		return result;
	}
	
	public int deleteCollection(Collection collection){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "collectionMapper.deleteCollection";
		int result = session.delete(statement, collection);
		session.commit();
		session.close();
		return result ;
	}
}
