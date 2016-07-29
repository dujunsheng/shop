package orderDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import po.Order;
import utils.MybatisUtils;
import utils.PageBean;
import utils.PageConstants;

public class OrderDao {
	
	public int addOrder(Order order){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();	
		String statement = "OrderMapper.insertSelective";
		int result = session.insert(statement, order);
		session.commit();
		session.close();
		return result;
	} 
	
	public int insertSelective(Order order){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();	
		String statement = "OrderMapper.insertSelective";
		int result = session.delete(statement, order);
		session.commit();
		session.close();
		return result;

	}
	
	public int deleteOrder(int o_id){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "OrderMapper.deleteByPrimaryKey";
		int result = session.delete(statement, o_id);
		session.commit();
		session.close();
		return result;
	}
	
	public int updateByPrimaryKeySelective(Order order){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "OrderMapper.updateByPrimaryKeySelective";
		int result = session.update(statement, order);
		session.commit();
		session.close();
		return result;
	}
	
	public Order findByO_id(int o_id){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "OrderMapper.selectByPrimaryKey";
		Order order = session.selectOne(statement, o_id);
		session.close();
		return order;
	}
	
//	先查询总数，在查询内容
	public PageBean<Order> findAll(int pc){
		PageBean<Order> pb = new PageBean<Order>();
		int ps = PageConstants.COLLECT_PAGE_SIZE;
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		int tr = session.selectOne("OrderMapper.countAll");
		Map map = new HashMap<String, Object>();
		map.put("ep", (pc-1)*ps);
		map.put("ep", pc*ps);
		String statement = "OrderMapper.findAll";
		List<Order> result = session.selectList(statement, map);
		session.close();
		pb.setPc(pc);
		pb.setPs(ps);
		pb.setTr(tr);
		pb.setBeanList(result);
		return pb;
	}
	
	public PageBean<Order> findByU_id(int u_id, int pc){
		PageBean<Order> pb = new PageBean<Order>();
		int ps = PageConstants.COLLECT_PAGE_SIZE;
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		int tr = session.selectOne("OrderMapper.countByU_id", u_id);
		Map map = new HashMap<String, Object>();
		map.put("u_id", u_id);
		map.put("sp", (pc-1)*ps);
		map.put("ep", ps);
		String statement = "OrderMapper.findByU_id";
		List<Order> result = session.selectList(statement, map);
		session.close();
		pb.setPc(pc);
		pb.setPs(ps);
		pb.setTr(tr);
		pb.setBeanList(result);
		return pb;
	}
	
//	实时修改订单中的total
//	先查询原有的total，然后再出传进选中商品的金额，然后相加
//	然后再更新数据库
	public void updateTotal(int o_id, float addPrice){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "OrderMapper.selectTotalByO_id";
		float pTotal = session.selectOne(statement, o_id);
		float nTotal = pTotal + addPrice;
		System.out.println(nTotal );
		Order order = new Order();
		order.setOrderId(o_id);
		order.setTotal(nTotal);
		String updateStatement = "OrderMapper.updateByPrimaryKeySelective";
		int update = session.update(updateStatement, order);
		session.commit();
		session.close();
		
	}
	
	public void editTotal(int o_id, float total){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		Order order = new Order();
		order.setOrderId(o_id);
		order.setTotal(total);
		String updateStatement = "OrderMapper.updateByPrimaryKeySelective";
		int update = session.update(updateStatement, order);
		session.commit();
		session.close();
	}
}
