package orderItemDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.Session;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import po.OrderItem;
import utils.MybatisUtils;
import utils.PageBean;
import utils.PageConstants;

public class OrderItemDao {
	
	public int addOrderItem(OrderItem orderItem){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "OrderItemMapper.insertOrderItemSelect";
		int result = session.insert(statement, orderItem);
		session.commit();
		session.close();
		return result;
	}
	
	public int deleteOrderItem(int orderItem_id){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "OrderItemMapper.deleteOrderItem";
		int result = session.delete(statement, orderItem_id);
		session.commit();
		session.close();
		return result;
	}
	
	public int updateOrderItem(OrderItem orderItem){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "OrderItemMapper.updateOrderItemSelect";
		int result = session.update(statement, orderItem);
		session.commit();
		session.close();
		return result; 
				
	}
	
	public OrderItem findByOrderItem_id(int orderItem_id){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "OrderItemMapper.OrderItem_id";
		OrderItem result = session.selectOne(statement, orderItem_id);
		session.close();
		return result;
	}
	
/*	//先查询所有
	public PageBean<OrderItem> findAll(){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "orderItemMapper.findAll";
		List<OrderItem> resultList = session.selectList(statement);
		session.close();
		return resultList;
	}*/
	
//	对用户的订单中的商品就行分页，先查询改订单中商品的数量的多少 ,实时修改订单的总金额
	public PageBean<OrderItem> findByOid(int o_id, int pc){
		int ps = PageConstants.COLLECT_PAGE_SIZE;
		PageBean<OrderItem> pb = new PageBean<OrderItem>();
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		int tr = session.selectOne("OrderItemMapper.countByO_id", o_id);
		Map map = new HashMap<String, Object>();
		map.put("o_id", o_id);
		map.put("sp", (pc-1)*ps);
		map.put("ep", ps);
		String statement = "OrderItemMapper.findByO_id";
		List<OrderItem> result = session.selectList(statement, map);
		pb.setBeanList(result);
		pb.setPc(pc);
		pb.setTr(tr);
		pb.setPs(ps);
		session.close();
		return pb;
	}
	
//	查询某o_id下的总金额,返回该订单的总金额,
	public float findTotal(int o_id){
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String statement = "OrderItemMapper.findTotal";
		List<OrderItem> list = session.selectList(statement, o_id);
		float total = 0;
		for(OrderItem orderItem : list){
			total  = total + orderItem.getG_quantity() * orderItem.getGood().getgPrice();
		}
		session.close();
		return total;
	}
	
} 
