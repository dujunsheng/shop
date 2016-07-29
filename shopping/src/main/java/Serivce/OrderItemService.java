package Serivce;

import java.util.List;

import orderItemDao.OrderItemDao;
import po.OrderItem;
import utils.PageBean;

public class OrderItemService {

	private  OrderItemDao orderItemDao = new OrderItemDao();
	
	public int addOrderItem(OrderItem orderItem){
		return orderItemDao.addOrderItem(orderItem);
	}
	
	public int deleteOrderItem(int orderItem_id){
		return  orderItemDao.deleteOrderItem(orderItem_id);
	}
	
	public int updateOrderItem(OrderItem orderItem){
		return orderItemDao.updateOrderItem(orderItem);
	}
	
	public OrderItem findByOrderItem_id(int orderItem_id){
		return orderItemDao.findByOrderItem_id(orderItem_id);
	}
	
	public PageBean<OrderItem> findByO_id(int o_id, int pc){
		return orderItemDao.findByOid(o_id, pc);
	}
	
	public float findTotal(int o_id){
		return orderItemDao.findTotal(o_id);
	}
}
