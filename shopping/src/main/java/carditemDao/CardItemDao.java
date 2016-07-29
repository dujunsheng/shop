package carditemDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import po.CardItem;
import utils.MybatisUtils;
import utils.PageBean;
import utils.PageConstants;

public class CardItemDao {

//	先插该用户所用有的购物车的条数，再查询内容
	public PageBean<CardItem> findByU_id(int u_id, int pc){
		PageBean<CardItem> pb = new PageBean<CardItem>();
		int ps = PageConstants.COLLECT_PAGE_SIZE;
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		int tr = session.selectOne("CardItemMapper.countByU_id", u_id);
		Map map = new HashMap<String, Object>();
		map.put("sp", (pc-1)*ps);
		map.put("ep", ps);
		map.put("u_id", u_id);
		String statement = "CardItemMapper.selectByU_id";
		List<CardItem> resultList = session.selectList(statement, map);
		session.close();
		pb.setBeanList(resultList);
		pb.setPc(pc);
		pb.setTr(tr);
		pb.setPs(ps);
		return pb;
	}
	
	public int deleteCardItem(int c_id){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "CardItemMapper.deleteByPrimaryKey";
		int result = session.delete(statement, c_id);
		session.commit();
		session.close();
		return result;
	}
	
	public int addCardItem(CardItem cardItem){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "CardItemMapper.insertSelective";
		int result = session.insert(statement, cardItem);
		session.commit();
		session.close();
		return result ;
	}
	
	//修改商品数目
	public int updateCardItemQuantity(CardItem cardItem){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "CardItemMapper.updateByPrimaryKeySelective";
		int result = session.update(statement, cardItem);
		session.commit();
		session.close();
		return result;
	}
	

}
