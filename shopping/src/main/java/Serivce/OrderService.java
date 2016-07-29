package Serivce;

import java.util.List;

import orderDao.OrderDao;
import orderItemDao.OrderItemDao;
import po.Order;
import utils.PageBean;

public class OrderService {

	private OrderDao orderDao = new OrderDao();
	
	public int addOrder (Order order){
		return orderDao.addOrder(order);
	}
	
	public int insertSelective(Order order){
		return orderDao.insertSelective(order);
	}
	
	public int deleteOrder(int o_id){
		return orderDao.deleteOrder(o_id);
	}
	
	public int updateByPrimaryKeySelective(Order order){
		return orderDao.updateByPrimaryKeySelective(order);
	}
	
	public Order findByO_id(int o_id){
		return orderDao.findByO_id(o_id);
	}
	
	public PageBean<Order> findAll(int pc){
		return orderDao.findAll(pc);
	}
	
	public PageBean<Order> findByU_id(int u_id, int pc){
		return orderDao.findByU_id(u_id, pc);
	}
	
	public void updateTotal(int o_id, float addPrice){
		orderDao.updateTotal(o_id, addPrice);
	}
	
	public void editTotal(int o_id){
		OrderItemDao orderItemDao = new OrderItemDao();
		float total = orderItemDao.findTotal(o_id);
		orderDao.editTotal(o_id, total);
	}
}
